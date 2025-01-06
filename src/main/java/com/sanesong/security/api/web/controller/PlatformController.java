package com.sanesong.security.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanesong.security.api.entity.Platform;
import com.sanesong.security.api.service.PlatformService;
import com.sanesong.security.api.web.request.RequestDeletePlatforms;
import com.sanesong.security.api.web.request.RequestSavePlatforms;
import com.sanesong.security.api.web.response.ResponseResult;

@Controller
@RequestMapping(value = "/api/platforms")
public class PlatformController extends BaseController {

	@Autowired
	private PlatformService platformService;
	
	@ResponseBody
	@PostMapping(value = "/find-platforms")
	public ResponseResult<List<Platform>> findPlatforms() {
		final List<Platform> result = platformService.findPlatforms();
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/save-platforms")
	public ResponseResult<List<Platform>> savePlatforms(@RequestBody final RequestSavePlatforms request) {
		final List<Platform> result = platformService.savePlatforms(request.getPlatforms());
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/delete-platforms")
	public ResponseResult<Void> deletePlatforms(@RequestBody final RequestDeletePlatforms request) {
		platformService.deletePlatforms(request.getPlatformIds());
        return getSuccessResponseResult();
	}
}
