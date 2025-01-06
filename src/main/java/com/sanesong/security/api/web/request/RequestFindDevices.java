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
public final class RequestFindDevices implements Serializable {

	private static final long serialVersionUID = 4635442069733877348L;
	
	@JsonProperty(value = "group_id")
    private String groupId;
	
	@JsonProperty(value = "tag_id")
    private String tagId;
}
