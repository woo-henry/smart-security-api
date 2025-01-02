package com.sanesong.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
interface BaseRepository<T> extends Repository<T, String>, JpaRepository<T, String>, JpaSpecificationExecutor<T> {
	
}
