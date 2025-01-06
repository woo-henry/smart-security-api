package com.sanesong.security.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.DeviceTag;

public interface DeviceTagRepository extends BaseRepository<DeviceTag> {

	@Query("select t from DeviceTag t where t.tagId = :tagId")
	public List<DeviceTag> findDeviceTags(@Param(value = "tagId") final String tagId);	
}