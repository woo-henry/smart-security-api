package com.sanesong.security.api.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sanesong.security.api.entity.Device;
import com.sanesong.security.api.entity.DeviceGroup;
import com.sanesong.security.api.entity.DeviceTag;
import com.sanesong.security.api.repository.DeviceGroupRepository;
import com.sanesong.security.api.repository.DeviceRepository;
import com.sanesong.security.api.repository.DeviceTagRepository;

@Service
@Transactional
public class DeviceService extends BaseService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceGroupRepository deviceGroupRepository;
	
	@Autowired
	private DeviceTagRepository deviceTagRepository;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public List<Device> findDevices() {
		return deviceRepository.findAll(Sort.by(Order.desc("sortKey")));
	}
	
	public List<Device> findDevicesByGroupId(final String groupId) {
		final List<DeviceGroup> deviceGroups = deviceGroupRepository.findDeviceGroups(groupId);
		final List<String> deviceIds = deviceGroups.stream().map(DeviceGroup::getDeviceId).collect(Collectors.toList());
		return deviceRepository.findAllById(deviceIds);
	}
	
	public List<Device> findDevicesByTagId(final String tagId) {
		final List<DeviceTag> deviceTags = deviceTagRepository.findDeviceTags(tagId);
		final List<String> deviceIds = deviceTags.stream().map(DeviceTag::getDeviceId).collect(Collectors.toList());
		return deviceRepository.findAllById(deviceIds);
	}
	
	public Device findDeviceById(final String objectId) {
		return deviceRepository.findDeviceById(objectId);
	}
	
	public Device saveDevice(final Device entity) {
		return deviceRepository.save(entity);
	}
	
	public List<Device> saveDevices(final List<Device> entities) {
		return deviceRepository.saveAll(entities);
	}
	
	public void deleteDevice(final Device entity) {
		deviceRepository.delete(entity);
	}
	
	public void deleteDevices(final List<String> ids) {
		final List<Device> entities = deviceRepository.findAllById(ids);
		deviceRepository.deleteAll(entities);
	}
}
