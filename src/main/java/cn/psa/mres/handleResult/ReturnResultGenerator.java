package cn.psa.mres.handleResult;

import javax.servlet.http.HttpServletRequest;

public final class ReturnResultGenerator
{
    /**
     * 创建普通消息方法
     * @param flag 执行接口状态，true:执行成功,false:执行失败
     * @param msg 返回消息内容
     * @param result 返回结果
     * @return
     */
    public static ReturnResult result(boolean flag, String msg, Object result, Throwable throwable)
    {
        //创建返回对象
        ReturnResult returnResult = ReturnResult.newInstance();
        returnResult.setSuccessFlag(flag);
        returnResult.setMsg(msg == "" ? "成功返回" : msg);
        returnResult.setResult(result);
        returnResult.setTime(System.currentTimeMillis());
        return returnResult;
    }

    /**
     * 返回执行成功视图方法
     * @param result 执行成功后的返回内容
     * @return
     */
    public static ReturnResult successResult(Object result)
    {
        return result(true,"",result,null);
    }

    /**
     * 成功没有内容方法
     * @return
     */
    public static ReturnResult successResult(HttpServletRequest request){
        return successResult("");
    }

    /**
     * 执行失败后返回视图方法
     * @param msg 执行失败后的错误消息内容
     * @return
     */
    public static ReturnResult errorResult(String msg,Object result, Throwable throwable)
    {
        return result(false,msg,result,throwable);
    }
}
