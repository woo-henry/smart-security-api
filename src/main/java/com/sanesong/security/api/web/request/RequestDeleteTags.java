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
public final class RequestDeleteTags implements Serializable {

	private static final long serialVersionUID = -1682716714421840216L;
	
	@JsonProperty(value = "tag_ids")
    private List<String> tagIds;
}
