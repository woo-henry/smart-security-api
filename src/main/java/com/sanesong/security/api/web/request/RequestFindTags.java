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
public final class RequestFindTags implements Serializable {

	private static final long serialVersionUID = 4393194627936692313L;

	@JsonProperty(value = "group_id")
    private String groupId;
}
