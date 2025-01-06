package com.sanesong.security.api.web.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanesong.security.api.entity.Group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class RequestSaveGroups implements Serializable {

	private static final long serialVersionUID = -8338934345856749574L;
	
	@JsonProperty(value = "groups")
    private List<Group> groups;
}
