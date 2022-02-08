package com.cjr.elec.common.api;

/**
 * 枚举一些常用的API操作码
 * Created by holdice on 2021/3/15
 */
public enum ResultCode implements ErrorCode {

    SUCCESS(1, "操作成功"),
    FAILED(-1, "操作失败"),
    VALIDATE_FAILED(101, "参数检验失败"),
    UNAUTHORIZED(102, "暂未登录或token已经过期"),
    FORBIDDEN(103, "没有相关权限"),
    TOKEN_MISSING(104, "未检测到token"),
    USER_NOT_EXISTS(105, "用户不存在"),
    USER_ALREADY_EXISTS(106, "用户已存在"),
    TEACHER_ALREADY_EXISTS(107,"老师已存在"),
    CLASS_ALREADY_EXISTS(108,"班级已存在"),
    CLASS_AND_TEACHER_ALREADY_EXISTS(109, "班级和老师的关系已存在"),
    INTERVAL_CONFLICT(110, "设置的时间区间与数据库现有区间冲突"),
    DUPLICATE_GENERATE(111, "重复请求生成"),
    EXCESSIVE_GENERATE(112, "当前请求生成用户过多"),
    NO_DATA(113, "无数据");

    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
