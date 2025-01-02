package com.sanesong.security.api.web.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class RequestUpdateUser implements Serializable {

	private static final long serialVersionUID = 4235523666289090710L;

	@JsonProperty(value = "user_id")
    private String userId;
	
	@JsonProperty(value = "old_password")
    private String oldPassword;
	
	@JsonProperty(value = "new_password")
    private String newPassword;
}
