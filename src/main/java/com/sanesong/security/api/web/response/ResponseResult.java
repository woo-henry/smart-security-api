package com.sanesong.security.api.web.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
	
	private static final long serialVersionUID = -5734417299472900553L;

	private long code;		//错误码

	private String message;	//提示消息

	private T data;			//返回结果
}
