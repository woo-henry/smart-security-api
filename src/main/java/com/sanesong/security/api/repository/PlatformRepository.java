package com.sanesong.security.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.Platform;

public interface PlatformRepository extends BaseRepository<Platform> {

	@Query("select t from Platform t where t.objectId = :objectId")
	public Platform findPlatformById(@Param(value = "objectId") final String objectId);
}