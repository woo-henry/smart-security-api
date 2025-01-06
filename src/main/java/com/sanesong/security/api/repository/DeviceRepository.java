package com.sanesong.security.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.Device;

public interface DeviceRepository extends BaseRepository<Device> {

	@Query("select t from Device t where t.objectId = :objectId")
	public Device findDeviceById(@Param(value = "objectId") final String objectId);
}