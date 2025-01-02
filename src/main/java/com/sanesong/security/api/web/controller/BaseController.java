package com.sanesong.security.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sanesong.security.api.web.ErrorCode;
import com.sanesong.security.api.web.response.ResponseResult;

class BaseController {
	
	protected final Logger log;
	
	protected BaseController() {
		log = LoggerFactory.getLogger(getClass());
	}
	
	protected <T> ResponseResult<T> getErrorResponseResult() {
		return getErrorResponseResult(ErrorCode.FAILED);
	}
	
	protected <T> ResponseResult<T> getErrorResponseResult(final ErrorCode errorCode) {
		return ResponseResult.<T>builder().code(errorCode.getCode()).message(errorCode.getMessage()).build();
	}

	protected <T> ResponseResult<T> getErrorResponseResult(final long code, final String message) {
		return ResponseResult.<T>builder().code(code).message(message).build();
	}
	
	protected ResponseResult<Void> getSuccessResponseResult() {
		return ResponseResult.<Void>builder().code(ErrorCode.SUCCESS.getCode()).message(ErrorCode.SUCCESS.getMessage()).build();
	}

	protected <T> ResponseResult<T> getSuccessResponseResult(final T t) {
		return ResponseResult.<T>builder().data(t).code(ErrorCode.SUCCESS.getCode()).message(ErrorCode.SUCCESS.getMessage()).build();
	}
	
	protected <T> ResponseResult<T> getSuccessResponseResult(final T t, final String message) {
		return ResponseResult.<T>builder().data(t).code(ErrorCode.SUCCESS.getCode()).message(message).build();
	}
}
