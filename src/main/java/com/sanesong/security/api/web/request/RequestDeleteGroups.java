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
public final class RequestDeleteGroups implements Serializable {

	private static final long serialVersionUID = -3740369046348223524L;
	
	@JsonProperty(value = "group_ids")
    private List<String> groupIds;
}
