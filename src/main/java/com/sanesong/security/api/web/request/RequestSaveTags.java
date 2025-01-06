package com.sanesong.security.api.web.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanesong.security.api.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class RequestSaveTags implements Serializable {

	private static final long serialVersionUID = 5951727674219706026L;

	@JsonProperty(value = "tags")
    private List<Tag> tags;
}
