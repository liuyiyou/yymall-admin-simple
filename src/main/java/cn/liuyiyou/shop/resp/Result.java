package cn.liuyiyou.shop.resp;

import com.alibaba.fastjson.JSON;


public class Result<T> {
    private Integer code = 200;
    private String message = "success";
    private T data;

    public Result setHttpCode(HttpCode resultCode) {
        this.code = resultCode.value();
        this.message = resultCode.msg();
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
