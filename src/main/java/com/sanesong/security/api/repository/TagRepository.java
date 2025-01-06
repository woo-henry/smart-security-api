package com.sanesong.security.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.Tag;

public interface TagRepository extends BaseRepository<Tag> {

	@Query("select t from Tag t where t.objectId = :objectId")
	public Tag findTagById(@Param(value = "objectId") final String objectId);
}