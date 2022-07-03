package org.ldh.web.controller.ulits;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public OperationResult doException(Exception ex) {
        //记录日志
        //通知开发
        ex.printStackTrace();
        return new  OperationResult(500,"服务器故障，请联系管理员,exmsg=" + ex.getMessage());
    }
}
