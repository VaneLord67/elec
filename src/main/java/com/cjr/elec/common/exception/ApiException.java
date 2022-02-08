package com.cjr.elec.common.exception;

import com.cjr.elec.common.api.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义API异常
 * Created by holdice on 2021/3/15.
 */
@Getter
@Setter
public class ApiException extends RuntimeException {
    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
