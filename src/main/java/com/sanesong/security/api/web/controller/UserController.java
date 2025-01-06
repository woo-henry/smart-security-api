package com.sanesong.security.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanesong.security.api.entity.User;
import com.sanesong.security.api.service.UserService;
import com.sanesong.security.api.web.request.RequestDeleteUsers;
import com.sanesong.security.api.web.request.RequestFindUser;
import com.sanesong.security.api.web.response.ResponseResult;

@Controller
@RequestMapping(value = "/api/users")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping(value = "/find-user")
	public ResponseResult<User> login(@RequestBody final RequestFindUser request) {
		final User result = userService.findUser(request.getUserName(), request.getPassword());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/delete-users")
	public ResponseResult<Void> deleteUsers(@RequestBody final RequestDeleteUsers request) {
		userService.deleteUsers(request.getUserIds());
        return getSuccessResponseResult();
	}
}
