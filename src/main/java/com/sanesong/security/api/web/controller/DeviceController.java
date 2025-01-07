package com.sanesong.security.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanesong.security.api.entity.Device;
import com.sanesong.security.api.service.DeviceService;
import com.sanesong.security.api.web.request.RequestFindDevices;
import com.sanesong.security.api.web.response.ResponseResult;

@Controller
@RequestMapping(value = "/api/devices")
public class DeviceController extends BaseController {

	@Autowired
	private DeviceService deviceService;
	
	@ResponseBody
	@PostMapping(value = "/find-all-devices")
	public ResponseResult<List<Device>> findAllDevices() {
		final List<Device> result = deviceService.findDevices();
		return getSuccessResponseResult(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/find-devices")
	public ResponseResult<List<Device>> findDevices(@RequestBody final RequestFindDevices request) {
		final List<Device> result = deviceService.findDevicesByGroupId(request.getGroupId());
		return getSuccessResponseResult(result);
	}
}
