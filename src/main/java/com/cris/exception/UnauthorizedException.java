package com.cris.exception;

/**
 * 无权限进行管理员操作时的异常
 */
public class UnauthorizedException extends Exception{
    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String msg) {
        super(msg);
    }
}
