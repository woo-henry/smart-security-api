package com.sanesong.security.api.web.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class RequestDeleteUsers implements Serializable {

	private static final long serialVersionUID = -3974428923265331752L;
	
	@JsonProperty(value = "user_ids")
    private List<String> userIds;
}
