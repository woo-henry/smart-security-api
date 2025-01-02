package com.sanesong.security.api.web.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class ResponseMap<T> implements Serializable {

	private static final long serialVersionUID = -3976794226177807256L;
	
	public ResponseMap(String key, List<T> value) {
		super();
		this.key = key;
		this.value = value;
	}

	private String key;
	
	private List<T> value;
}
