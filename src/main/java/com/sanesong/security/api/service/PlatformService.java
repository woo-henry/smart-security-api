package com.sanesong.security.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sanesong.security.api.entity.Platform;
import com.sanesong.security.api.repository.PlatformRepository;

@Service
@Transactional
public class PlatformService extends BaseService {

	@Autowired
	private PlatformRepository platformRepository;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public List<Platform> findPlatforms() {
		return platformRepository.findAll(Sort.by(Order.desc("sortKey")));
	}
	
	public Platform findPlatformById(final String objectId) {
		return platformRepository.findPlatformById(objectId);
	}
	
	public Platform savePlatform(final Platform entity) {
		return platformRepository.save(entity);
	}
	
	public List<Platform> savePlatforms(final List<Platform> entities) {
		return platformRepository.saveAll(entities);
	}
	
	public void deletePlatform(final Platform entity) {
		platformRepository.delete(entity);
	}
	
	public void deletePlatforms(final List<String> ids) {
		final List<Platform> entities = platformRepository.findAllById(ids);
		platformRepository.deleteAll(entities);
	}
}
