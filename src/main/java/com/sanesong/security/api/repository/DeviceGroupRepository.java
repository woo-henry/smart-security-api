package com.sanesong.security.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.DeviceGroup;

public interface DeviceGroupRepository extends BaseRepository<DeviceGroup> {

	@Query("select t from DeviceGroup t where t.groupId = :groupId")
	public List<DeviceGroup> findDeviceGroups(@Param(value = "groupId") final String groupId);
}