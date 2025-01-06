package com.sanesong.security.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.TagGroup;

public interface TagGroupRepository extends BaseRepository<TagGroup> {

	@Query("select t from TagGroup t where t.groupId = :groupId")
	public List<TagGroup> findTagGroups(@Param(value = "groupId") final String groupId);
}