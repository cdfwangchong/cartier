package com.ctg.cartier.controller;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.alibaba.fastjson.JSONObject;
import com.ctg.cartier.pojo.dto.Saleuserlist;
import com.ctg.cartier.pojo.dto.WechatCode;
import com.ctg.cartier.pojo.until.AuthUtil;
import com.ctg.cartier.pojo.until.Result;

import com.ctg.cartier.pojo.until.Token;
import com.ctg.cartier.service.UserService;
import com.ctg.cartier.task.GetAccessTokenTask;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.ctg.cartier.pojo.until.Constant.*;

/*
 * project name :自助邮寄
 * for:用户注册
 * author：wangc
 * time：2020-10-10
 * */

@Api(tags = "用户注册")
@CrossOrigin
@RequestMapping("/cdfg")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService registerservice;

    @Autowired
    private GetAccessTokenTask getAccessTokenTask;

    @Value("${wx.userInfoUrl}")
    private String userInfoUrl;

    @Value("${wx.getuserUrl}")
    private String getuserUrl;

    private static String access_token;

    /**
     * 获取Userid接口
     * @param code
     * @return
     */
    @PostMapping("/getUserid")
    @ResponseBody
    public Result<Map> wechatopenid(@RequestBody WechatCode code) {
        if(StringUtils.isEmpty(code.getVer_code()) ){
            throw new CartierNotFoundException(errCode,"code为空！");
        }

        Map<String,String> retparam=new HashMap<String,String>();
        String vercode = code.getVer_code();
        log.info("取到code"+vercode);
        JSONObject jsonObject;
        String token = Token.access_token;
        if(StringUtils.isEmpty(token)) {
//            GetAccessTokenTask getAccessTokenTask = new GetAccessTokenTask();
            getAccessTokenTask.QryCustTrip();
        }
        token = Token.access_token;
        String getUserIdUrl = userInfoUrl.replace("ACCESS_TOKEN", token).replace("CODE", vercode);
        jsonObject = AuthUtil.doGetJson(getUserIdUrl);

        //从返回的JSON数据中取出userId，拉取用户信息时用
        if (jsonObject.containsKey("UserId")) {
            String userid =  jsonObject.getString("UserId");
            log.info("UserId:"+userid+";");
            //判断是否有值，有就不调用接口，直接查出员工信息
            List<Saleuserlist> saleuserlist;
            try{
                saleuserlist=registerservice.selectByPrimaryKey(userid);
            } catch (RuntimeException e) {
                log.error("获取openid存储过程的返回值异常");
                throw new CartierNotFoundException(errCode8,errMsg8);
            }
            //获得返回值
            if (saleuserlist.size()== 0) {
                String getuserUrl_rep = getuserUrl.replace("ACCESS_TOKEN",token).replace("USERID",userid);
                jsonObject = AuthUtil.doGetJson(getuserUrl_rep);

                //从返回的JSON数据中取出access_token和openid，拉取用户信息时用
                if (jsonObject.containsKey("userid")) {
                    String userid1 =  jsonObject.getString("userid");
                    String name= jsonObject.getString("name");
                    String department = jsonObject.getString("department");
                    String position = jsonObject.getString("position");
                    String mobile = jsonObject.getString("mobile");
                    String gender = jsonObject.getString("gender");

                    retparam.put("user_id",userid1);
                    retparam.put("user_name",name);
                    retparam.put("department",department);
                    retparam.put("position",position);
                    retparam.put("role","S");
                    retparam.put("mobile",mobile);
                    retparam.put("gender",gender);

                    Saleuserlist saleuser = new Saleuserlist();
                    saleuser.setUsername(name);
                    saleuser.setUserid(userid1);
                    saleuser.setPosition(position);
                    saleuser.setDepartment(department);
                    saleuser.setGender(gender);
                    try{
                        registerservice.insertSelective(saleuser);
                    } catch (RuntimeException e) {
                        log.error("获取openid存储过程的返回值异常");
                        throw new CartierNotFoundException(errCode8,errMsg8);
                    }
                }else {
                    String errcode =  jsonObject.getString("errcode");
                    String errmsg = jsonObject.getString("errmsg");
                    log.info("errcode:"+errcode+";"+"errmsg:"+errmsg);
                    log.info("调用企业微信接口获取成员信息失败："+"ret_result（返回结果）:"+"errcode:"+errcode+"errmsg:"+errmsg);
                    throw new CartierNotFoundException(errCode8,errMsg8);
                }
            }else {
                String userid1 =  saleuserlist.get(0).getUserid();
                String name= saleuserlist.get(0).getUsername();
                String department = saleuserlist.get(0).getDepartment();
                String position = saleuserlist.get(0).getPosition();
                String mobile = saleuserlist.get(0).getTelNum();
                String gender = saleuserlist.get(0).getGender();
                String isApprover = saleuserlist.get(0).getIsApprover();
                if("Y".equals(isApprover)){
                    isApprover="A";
                }else{
                    isApprover="S";
                }

                retparam.put("user_id",userid1);
                retparam.put("user_name",name);
                retparam.put("department",department);
                retparam.put("position",position);
                retparam.put("role",isApprover);
                retparam.put("mobile",mobile);
                retparam.put("gender",gender);

            }
        }else {
            String errcode =  jsonObject.getString("errcode");
            String errmsg = jsonObject.getString("errmsg");
            log.info("errcode:"+errcode+";"+"errmsg:"+errmsg);
            log.info("调用企业微信接口获取userId失败："+"ret_result（返回结果）:"+"errcode:"+errcode+"errmsg:"+errmsg);
            throw new CartierNotFoundException(errCode8,errMsg8);
        }

        return new Result<Map>(sucCode,sucMsg,retparam);
    }
}
