package com.sanesong.security.api.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sanesong.security.api.entity.Tag;
import com.sanesong.security.api.entity.TagGroup;
import com.sanesong.security.api.repository.TagGroupRepository;
import com.sanesong.security.api.repository.TagRepository;

@Service
@Transactional
public class TagService extends BaseService {

	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private TagGroupRepository tagGroupRepository;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public List<Tag> findTags() {
		return tagRepository.findAll(Sort.by(Order.desc("sortKey")));
	}
	
	public List<Tag> findTags(final String groupId) {
		final List<TagGroup> tagGroups = tagGroupRepository.findTagGroups(groupId);
		final List<String> tagIds = tagGroups.stream().map(TagGroup::getTagId).collect(Collectors.toList());
		return tagRepository.findAllById(tagIds);
	}
	
	public Tag findTagById(final String objectId) {
		return tagRepository.findTagById(objectId);
	}
	
	public Tag saveTag(final Tag entity) {
		return tagRepository.save(entity);
	}
	
	public List<Tag> saveTags(final List<Tag> entities) {
		return tagRepository.saveAll(entities);
	}
	
	public void deleteTag(final Tag entity) {
		tagRepository.delete(entity);
	}
	
	public void deleteTags(final List<String> ids) {
		final List<Tag> entities = tagRepository.findAllById(ids);
		tagRepository.deleteAll(entities);
	}
}
