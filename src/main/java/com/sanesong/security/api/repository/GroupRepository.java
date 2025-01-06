package com.sanesong.security.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.Group;

public interface GroupRepository extends BaseRepository<Group> {

	@Query("select t from Group t where t.groupType = :groupType")
	public List<Group> findGroups(@Param(value = "groupType") final int groupType);
	
	@Query("select t from Group t where t.objectId = :objectId")
	public Group findGroupById(@Param(value = "objectId") final String objectId);
}