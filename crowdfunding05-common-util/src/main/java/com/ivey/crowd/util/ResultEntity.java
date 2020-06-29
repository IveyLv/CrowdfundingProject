package com.ivey.crowd.util;

/**
 * @Description 统一整个项目中Ajax请求返回的结果（也可用于分布式架构中）
 * @Author IveyLv
 * @Date 2020/6/29 21:49
 * @Version 1.0
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    private String result;
    private String message;
    private T data;

    /**
     * 请求处理成功且不需要返回数据时使用的工具方法
     */
    public static ResultEntity successWithoutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     * @param data 要返回的数据
     */
    public static <E> ResultEntity<E> successWithData(E data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    /**
     * 请求处理失败时使用的工具方法
     * @param message 失败的错误消息
     */
    public static ResultEntity failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
