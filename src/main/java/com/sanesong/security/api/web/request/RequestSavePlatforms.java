package com.sanesong.security.api.web.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanesong.security.api.entity.Platform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class RequestSavePlatforms implements Serializable {
	
	private static final long serialVersionUID = 7441225656137338600L;
	
	@JsonProperty(value = "platforms")
    private List<Platform> platforms;
}
