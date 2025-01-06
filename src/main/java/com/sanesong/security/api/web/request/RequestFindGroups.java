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
public final class RequestFindGroups implements Serializable {

	private static final long serialVersionUID = 1848904037051043305L;
	
	@JsonProperty(value = "group_type")
    private int groupType;
}
