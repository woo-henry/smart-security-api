package com.sanesong.security.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanesong.security.api.entity.User;

public interface UserRepository extends BaseRepository<User> {

	@Query("select t from User t where t.userName = :userName and t.password = :password")
	public User findUser(@Param(value = "userName") final String userName, @Param(value = "password") final String password);
	
	@Query("select t from User t where t.objectId = :objectId")
	public User findUserById(@Param(value = "objectId") final String objectId);
}