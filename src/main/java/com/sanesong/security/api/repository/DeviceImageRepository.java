package com.sanesong.security.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.DeviceImage;

public interface DeviceImageRepository extends BaseRepository<DeviceImage> {

	@Query("select t from DeviceImage t where t.deviceId = :deviceId")
	public List<DeviceImage> findDeviceImages(@Param(value = "deviceId") final String deviceId);
}