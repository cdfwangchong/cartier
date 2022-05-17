package com.ctg.cartier.controller;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.pojo.until.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 自定义异常接口
 */
@CrossOrigin
@ControllerAdvice
public class CartierExceptionController {
    @ExceptionHandler(value = CartierNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(produces="json/html; charset=UTF-8")
    @ResponseBody

    public Result<String> exception (CartierNotFoundException exception){
        int code= exception.getRetCode();
        String Msg = exception.getMsg();
        return new Result<String>(code,Msg,"");
    }
}
