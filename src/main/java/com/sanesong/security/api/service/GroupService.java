package com.sanesong.security.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sanesong.security.api.entity.Group;
import com.sanesong.security.api.repository.GroupRepository;

@Service
@Transactional
public class GroupService extends BaseService {

	@Autowired
	private GroupRepository groupRepository;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public List<Group> findGroups() {
		return groupRepository.findAll(Sort.by(Order.desc("sortKey")));
	}
	
	public List<Group> findGroups(final int groupType) {
		return groupRepository.findGroups(groupType);
	}
	
	public Group findGroupById(final String objectId) {
		return groupRepository.findGroupById(objectId);
	}
	
	public Group saveGroup(final Group entity) {
		return groupRepository.save(entity);
	}
	
	public List<Group> saveGroups(final List<Group> entities) {
		return groupRepository.saveAll(entities);
	}
	
	public void deleteGroup(final Group entity) {
		groupRepository.delete(entity);
	}
	
	public void deleteGroups(final List<String> ids) {
		final List<Group> entities = groupRepository.findAllById(ids);
		groupRepository.deleteAll(entities);
	}
}
