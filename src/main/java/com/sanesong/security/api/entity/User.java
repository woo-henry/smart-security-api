package com.sanesong.security.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "se_users", indexes = { 
		@Index(name = "user_object_id", columnList = "object_id", unique = true),
})
public class User implements Serializable {

	private static final long serialVersionUID = -6795602886251410636L;
	
	@JsonProperty(value = "object_id")
	@Id
	@GeneratedValue(generator = "primaryIdGenerator")
	@GenericGenerator(name = "primaryIdGenerator", strategy = "uuid.hex")
	@Column(name = "object_id", length = 32, nullable = false, unique = true)
	private String objectId;
	
	@JsonProperty(value = "user_name")
	@Column(name = "user_name", length = 32, nullable = false)
	private String userName;
	
	@JsonProperty(value = "password")
	@Column(name = "password", length = 32, nullable = false)
	private String password;
	
	@JsonProperty(value = "sort_key")
	@Column(name = "sort_key", nullable = false)
	private int sortKey;
	
	@JsonProperty(value = "created_time")
	@CreatedDate
	@Column(name = "created_time", insertable = true, updatable = false)
	private Date createdTime = new Date();
	
	@JsonIgnore
	@LastModifiedBy
	@Column(name = "updated_time", insertable = true, updatable = true)
	private Date updatedTime = new Date();
}
