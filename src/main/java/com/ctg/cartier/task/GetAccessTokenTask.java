package com.ctg.cartier.task;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.alibaba.fastjson.JSONObject;
import com.ctg.cartier.pojo.until.AuthUtil;
import com.ctg.cartier.pojo.until.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.ctg.cartier.pojo.until.Constant.errCode8;
import static com.ctg.cartier.pojo.until.Constant.errMsg8;

//@EnableScheduling
@Slf4j
@Component
public class GetAccessTokenTask {

    @Value("${wx.accessTokenUrl}")
    private String accessTokenUrl;
    @Value("${wx.corpsecret:}")
    private String corpSecret;
    @Value("${wx.corpid:}")
    private String corpId;

    /**
     * 触发拿到微信access_token
     */

    @Scheduled(cron = "0 0 0/2 * * ?")//每2小时触发一次
    public void QryCustTrip() {

        String getTokenUrl = accessTokenUrl.replace("ID", corpId).replace("SECRET", corpSecret);
        JSONObject jsonObject = AuthUtil.doGetJson(getTokenUrl);
        //从返回的JSON数据中取出access_token,拉取用户信息时用
        if (jsonObject.containsKey("access_token")) {
            String token =  jsonObject.getString("access_token");
            log.info("token:"+token);
            Token.access_token = token;
        }else {
            String errcode =  jsonObject.getString("errcode");
            String errmsg = jsonObject.getString("errmsg");
            log.info("errcode:"+errcode+";"+"errmsg:"+errmsg);
            log.info("调用企业微信接口获取access_token信息失败："+"ret_result（返回结果）:"+"errcode:"+errcode+"errmsg:"+errmsg);
            throw new CartierNotFoundException(errCode8,errMsg8);
        }
    }
}
