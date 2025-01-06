package com.sanesong.security.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanesong.security.api.entity.Group;
import com.sanesong.security.api.service.GroupService;
import com.sanesong.security.api.web.request.RequestDeleteGroups;
import com.sanesong.security.api.web.request.RequestFindGroups;
import com.sanesong.security.api.web.request.RequestSaveGroups;
import com.sanesong.security.api.web.response.ResponseResult;

@Controller
@RequestMapping(value = "/api/groups")
public class GroupController extends BaseController {

	@Autowired
	private GroupService groupService;
	
	@ResponseBody
	@PostMapping(value = "/find-groups")
	public ResponseResult<List<Group>> findGroups(@RequestBody final RequestFindGroups request) {
		final List<Group> result = groupService.findGroups(request.getGroupType());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/save-groups")
	public ResponseResult<List<Group>> saveGroups(@RequestBody final RequestSaveGroups request) {
		final List<Group> result = groupService.saveGroups(request.getGroups());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/delete-groups")
	public ResponseResult<Void> deleteGroups(@RequestBody final RequestDeleteGroups request) {
		groupService.deleteGroups(request.getGroupIds());
        return getSuccessResponseResult();
	}
}
