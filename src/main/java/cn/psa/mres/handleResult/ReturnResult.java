package cn.psa.mres.handleResult;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ReturnResult implements Serializable
{
    //禁止new创建对象
    private ReturnResult() {}

    /**
     * 统一创建ReturnResultBean对象
     * 方便后期扩展
     * @return
     */
    public static ReturnResult newInstance(){
        return new ReturnResult();
    }

    //消息提示
    private String msg;
    //状态信息
    private boolean successFlag = true;
    //返回结构
    private Object result;
    //接口相应时间毫秒单位
    private long time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }



    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
