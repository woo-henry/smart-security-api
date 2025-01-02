package com.sanesong.security.api.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {

	//错误码
    SUCCESS(0L, "成功"),
    REQUEST_NULL(40000L, "请求有错误"),
    SESSION_TIMEOUT(40000L, "会话超时"),
    NO_PERMISSION(40005L, "权限不足"),
    NO_PERMISSION_APP(40006L, "无该应用权限"),
    METHOD_NOT_SUPPORT(40007L, "请求方法不正确"),
    ACCESS_TOKEN_INVALID(40008L, "access_token已过期或失效"),
    SERVER_ERROR(50000L, "服务异常"),
    SYSTEM_VERSION_ERROR(70000L, "系统版本错误"),

    LOGIN_TIMEOUT(10000L, "登录超时"),
    GET_USERINFO_ERR(10001L, "获取用户信息失败"),
    UNAUTHORIZED(10002L, "未授权"),
    CHILD_TABLE_NULL(10003L, "空的子表对象"),
    JSON_PASE_ERR(10004L, "json 解析异常"),
    ILLEGAL_PARAMETER_ERR(10005L, "非法的参数"),
    REMOTING_ERR(10006L, "调用引擎服务失败，请检查引擎服务是否正常运行"),
    DING_SYNC_ERR(10007L, "同步失败，详情请查看同步日志"),
    DING_ABNORMAL_USER(10026L,"不可同步异常用户"),
    GET_DEPARTMENT_ERR(10008L, "获取组织机构失败"),
    CLASS_CAST_ERR(10009L, "类型转换异常"),
    STAFF_SELECTOR_ERR(10010L, "选人控件配置有问题"),
    SCHEMA_NOT_FOUNT_ERR(10011L, "业务模型不存在"),
    FILE_READ_WRITE_ERR(10012L, "读取或写入文件失败"),
    OSS_CONFIG_NOT_EXIST(10013L, "OSS 配置不存在"),
    OSS_UPLOAD_ERR(10014L, "文件上传失败"),
    OSS_DOWNLOAD_ERR(10015L, "文件下载失败"),
    OSS_DOWNLOAD_PERMISSION_ERR(10016L, "无文件下载权限"),
    OSS_DELETE_ERR(10017L, "删除上传的文件失败"),
    FILE_CHECK_ERR(10018L, "测试文件上传失败"),
    OSS_PARAMETER_ERR(10019L, "文件存储参数错误"),
    OSS_PARAMETER_EMPTY_ERR(10020L, "文件存储参数未配置"),
    DINGTALK_CONFIG_EMPTY_ERR(10021L, "钉钉集成参数未配置"),
    PROPERTY_REMOVE_ERR(10022L, "删除数据项失败"),
    OVER_LICENSE_USER_NUM(10023L, "你所在企业的用户数已经达到或超过授权的用户数！"),
    NOT_CAN_URGE_SELF(10024L, "不能催办自己！"),
    OSS_UPLOAD_SIZE_LIMIT_EXCEEDED(10025L,"文件上传超出大小限制"),
    CLIENT_EXIST_ERR(10026L,"客户端已存在"),
    CLIENT_NOT_EXIST_ERR(10027L,"客户端不存在"),
    FILE_TYPE_ILLEGAL(10028L, "上传文件有异常，已被系统拒绝！"),
    ADD_BUTTON_RELATIVE_CODE_ERR(10029L, "关联的表单/流程不存在或不在当前模型下，请重新配置！"),

    MEETING_USE_OCCUPIED(800001L,"会议室该时间段已经被占用"),
    MEETING_START_TIME_FAIL(800002L,"会议开始时间不能早于会议结束时间"),
    MEETING_TIME_FAIL(800003L,"会议开始时间不能早于当前时间"),
    UNKNOWN_ERROR(999999L, "未知错误");

    private long key;
    private String text;
}
