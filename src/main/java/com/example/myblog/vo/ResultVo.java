package com.example.myblog.vo;

import lombok.Data;

import javax.xml.transform.Result;

@Data
public class ResultVo<T>{
    private T data;
    private Integer code;
    private String msg;
    public ResultVo(Integer code, String msg){
        this.code = code;
        this.msg= msg;
    }

    public ResultVo setData(T data){
        this.data = data;
        return this;
    }

    public static ResultVo create(Integer code, String msg){
        return new ResultVo(code, msg);
    }

    /**
     * 成功没数据返回
     * @return
     */
    public static ResultVo success(String msg){
        return create(200, msg);
    }

    /**
     * 成功有数据返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> successAndData(T data){
        return success("成功").setData(data);

    }

    /**
     * 失败无数据返回
     * @param code
     * @param msg
     * @return
     */
    public static ResultVo fail(Integer code, String msg){
        return create(code, msg);
    }

    /**
     * 错误默认返回400,错误信息自定义
     * @param msg
     * @return
     */
    public static ResultVo failMsg(String msg){
        return fail(400, msg);
    }

}
