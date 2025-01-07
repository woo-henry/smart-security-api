package com.sanesong.security.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanesong.security.api.entity.Tag;
import com.sanesong.security.api.service.TagService;
import com.sanesong.security.api.web.request.RequestDeleteTags;
import com.sanesong.security.api.web.request.RequestFindGroupTags;
import com.sanesong.security.api.web.request.RequestSaveTags;
import com.sanesong.security.api.web.response.ResponseResult;

@Controller
@RequestMapping(value = "/api/tags")
public class TagController extends BaseController {

	@Autowired
	private TagService tagService;
	
	@ResponseBody
	@PostMapping(value = "/find-tags")
	public ResponseResult<List<Tag>> findTags() {
		final List<Tag> result = tagService.findTags();
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/find-group-tags")
	public ResponseResult<List<Tag>> findGroupTags(@RequestBody final RequestFindGroupTags request) {
		final List<Tag> result = tagService.findTags(request.getGroupId());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/save-tags")
	public ResponseResult<List<Tag>> saveTags(@RequestBody final RequestSaveTags request) {
		final List<Tag> result = tagService.saveTags(request.getTags());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/delete-tags")
	public ResponseResult<Void> deleteTags(@RequestBody final RequestDeleteTags request) {
		tagService.deleteTags(request.getTagIds());
        return getSuccessResponseResult();
	}
}
