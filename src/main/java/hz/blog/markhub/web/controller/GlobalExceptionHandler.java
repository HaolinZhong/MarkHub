package hz.blog.markhub.web.controller;

import hz.blog.markhub.exception.ServiceException;
import hz.blog.markhub.exception.ServiceExceptionEnum;
import hz.blog.markhub.web.model.CommonReturnType;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonReturnType AllExceptionHandler(Exception e) {

        Map<String, Object> responseData = new HashMap<>();

        if (e instanceof ServiceException) {
            ServiceException se = (ServiceException) e;
            responseData.put("errCode", se.getErrCode());
            responseData.put("errMsg", se.getErrMsg());
        } else if (e instanceof ShiroException) {
            responseData.put("errCode", ServiceExceptionEnum.AUTHENTICATION_FAILED.getErrCode());
            responseData.put("errMsg", ServiceExceptionEnum.AUTHENTICATION_FAILED.getErrMsg());
        } else{
            responseData.put("errCode", ServiceExceptionEnum.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", ServiceExceptionEnum.UNKNOWN_ERROR.getErrMsg());
        }

        return CommonReturnType.builder().status("fail").data(responseData).build();
    }
}
