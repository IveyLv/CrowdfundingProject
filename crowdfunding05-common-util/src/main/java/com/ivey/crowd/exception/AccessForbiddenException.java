package com.ivey.crowd.exception;

/**
 * @Description 表示用户没有登录就访问受保护的资源时抛出的异常
 * @Author IveyLv
 * @Date 2020/7/2 15:06
 * @Version 1.0
 */
public class AccessForbiddenException extends RuntimeException {

    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
