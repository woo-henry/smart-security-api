package com.sanesong.security.api.web;

/**
 * 错误代码定义
 */
public enum ErrorCode {

    SUCCESS(0, "成功"),
    FAILED(1, "失败"),
    
    ERROR_DATA_EXIST(1000, "数据已存在"),
    ERROR_DATA_NOT_EXIST(1001, "数据不存在"),
    ERROR_DATA_FORMAT(1002, "数据格式错误"),
    ERROR_DATA_VALUE(1003, "数据值错误"),
    ERROR_DATA_DELETE(1004, "删除数据错误"),
    ERROR_DATA_INSERT(1005, "插入数据错误"),
    
    ERROR_PARAMETER_EMPTY(2000, "参数为空"),
    ERROR_PARAMETER_INVALID(2001, "参数无效"),
    
    ERROR_FILE_NOT_EXIST(3000, "文件不存在"),
    ERROR_FILE_NAME_INVALID(3001, "文件名无效"),
    ERROR_FILE_UPLOAD_INVALID(3002, "文件上传失败"),
    ERROR_FILE_DELETE_INVALID(3003, "文件删除失败"),
    
    ERROR_SMS_SEND_FAILED(4000, "短信验证码发送失败"),
    ERROR_SMS_CHECK_FAILED(4001, "短信验证码校验失败"),
    
    ERROR_USER_NOT_EXIST(5000, "用户不存在"),
    
    ERROR_CARD_ALREADY_INUSE(6000, "密卡已核销"),
    ERROR_CARD_ALREADY_INVALID(6001, "密卡已失效"),
    ERROR_CARD_WRITEOFF(6002, "密卡核销失败"),
    ERROR_CARD_STATUS_UPDATE(6003, "密卡状态更新失败"),
    
    ERROR_CAPACITY_INSUFFICIENT(7000, "账户充值算力不足"),
    ERROR_INSUFFICIENT_ACCOUNT_BALANCE(7001, "账户余额不足"),
    ERROR_GENERAL_MODEL_PRESENT_INSUFFICIENT(7011, "通用模型赠送次数已用完"),
    ERROR_GENERAL_MODEL_EXPIRATION(7012, "通用模型算力已经过期"),
    ERROR_GENERAL_MODEL_COMPUTE_INSUFFICIENT(7013, "通用模型算力余额不足"),
    ERROR_ADVANCE_MODEL_PRESENT_INSUFFICIENT(7021, "高级模型赠送次数已用完"),
    ERROR_ADVANCE_MODEL_EXPIRATION(7022, "高级模型算力已经过期"),
    ERROR_ADVANCE_MODEL_COMPUTE_INSUFFICIENT(7023, "高级模型算力余额不足"),
    ERROR_BAIDU_MODEL_PRESENT_INSUFFICIENT(7031, "文心一言赠送次数已用完"),
    ERROR_BAIDU_MODEL_EXPIRATION(7032, "文心一言算力已经过期"),
    ERROR_BAIDU_MODEL_COMPUTE_INSUFFICIENT(7033, "文心一言算力余额不足"),
    ERROR_MIDJOURNEY_MODEL_PRESENT_INSUFFICIENT(7041, "Midjourney赠送次数已用完"),
    ERROR_MIDJOURNEY_MODEL_EXPIRATION(7042, "Midjourney次数已经过期"),
    ERROR_MIDJOURNEY_MODEL_COMPUTE_INSUFFICIENT(7043, "Midjourney余额不足"),
    
    UNKNOW_ERROR(999999, "未知错误");

    private final long code;
    private final String message;

    ErrorCode(final long code, final String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    public static ErrorCode valueOf(final long code) {
    	final ErrorCode[] errors = ErrorCode.values();
    	
    	for(ErrorCode error : errors) {
    		if(error.getCode() == code)
    			return error;
    	}
    	
    	return ErrorCode.UNKNOW_ERROR;
    }
    
    public static boolean isSuccess(ErrorCode errorCode) {
    	return errorCode == ErrorCode.SUCCESS;
    }
}
