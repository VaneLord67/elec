package com.cjr.elec.common.exception;


import com.cjr.elec.common.api.ErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by holdice on 2021/3/15.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}

