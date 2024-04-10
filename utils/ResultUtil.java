package com.xust.ffms.utils;

import java.util.List;

/**
 * 接口访问返回
 */
public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setCode(Config.SUCCESS);
        result.setMsg("Successful operation！");
        return result;
    }

    public static Result success(List list){
        Result result = new Result();
        result.setCode(Config.SUCCESS);
        result.setMsg("Successful operation！");
        result.setDatas(list);
        return result;
    }

    public static Result success(Object o){
        Result result = new Result();
        result.setCode(Config.SUCCESS);
        result.setMsg("Successful operation！");
        result.setData(o);
        return result;
    }

    public static Result success(String msg, Object object){
        Result result = new Result();
        result.setCode(Config.SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(Exception e){
        Result result = new Result();
        result.setCode(Config.ERROR);
        result.setMsg("The operation failed and an exception occurred");
        //如果启用自定义日志，则在控制台打印错误信息
        Utils.log(e.getMessage());
        return result;
    }

    public static Result unSuccess(){
        Result result = new Result();
        result.setCode(Config.UNSUCCESS);
        result.setMsg("Operation failure！");
        return result;
    }

    public static Result unSuccess(String msg){
        Result result = new Result();
        result.setCode(Config.UNSUCCESS);
        result.setMsg(msg);
        return result;
    }
}
