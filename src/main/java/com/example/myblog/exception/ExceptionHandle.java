package com.example.myblog.exception;

import com.example.myblog.vo.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler({ServiceException.class})
    public ResultVo serviceException(ServiceException e){
        return ResultVo.failMsg(e.getMessage());
    }
    @ExceptionHandler(NullPointerException.class)
    public ResultVo nullPointer(NullPointerException e){
        return ResultVo.failMsg("参数为空: "+e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResultVo excption(Exception e){
        return ResultVo.failMsg("未知异常"+e.getMessage());
    }

}
