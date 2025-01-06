package com.sanesong.security.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sanesong.security.api.entity.User;
import com.sanesong.security.api.repository.UserRepository;

@Service
@Transactional
public class UserService extends BaseService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public List<User> findUsers() {
		return userRepository.findAll(Sort.by(Order.desc("sortKey")));
	}
	
	public User findUser(final String userName, final String password) {
		return userRepository.findUser(userName, password);
	}
	
	public User findUserById(final String objectId) {
		return userRepository.findUserById(objectId);
	}
	
	public User saveUser(final User entity) {
		return userRepository.save(entity);
	}
	
	public List<User> saveUsers(final List<User> entities) {
		return userRepository.saveAll(entities);
	}
	
	public void deleteUser(final User entity) {
		userRepository.delete(entity);
	}
	
	public void deleteUsers(final List<String> ids) {
		final List<User> entities = userRepository.findAllById(ids);
		userRepository.deleteAll(entities);
	}
	
	public User updateUser(final String id, final String oldPassword, final String newPassowrd) {
		final User entity = userRepository.findUserById(id);
		if(ObjectUtils.isEmpty(entity))
			return null;
		
		if(!entity.getPassword().equalsIgnoreCase(oldPassword))
			return null;
		
		entity.setPassword(newPassowrd);
		
		return userRepository.save(entity);
	}
}
