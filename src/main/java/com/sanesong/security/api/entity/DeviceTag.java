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
public class DeviceTag implements Serializable {

	private static final long serialVersionUID = -6795602886251410636L;
	
	@JsonProperty(value = "object_id")
	@Id
	@GeneratedValue(generator = "primaryIdGenerator")
	@GenericGenerator(name = "primaryIdGenerator", strategy = "uuid.hex")
	@Column(name = "object_id", length = 32, nullable = false, unique = true)
	private String objectId;
	
	@JsonProperty(value = "device_id")
	@Column(name = "device_id", length = 32, nullable = false)
	private String deviceId;
	
	@JsonProperty(value = "tag_id")
	@Column(name = "tag_id", length = 32, nullable = false)
	private String tagId;
	
	@JsonProperty(value = "created_time")
	@CreatedDate
	@Column(name = "created_time", insertable = true, updatable = false)
	private Date createdTime = new Date();
	
	@JsonIgnore
	@LastModifiedBy
	@Column(name = "updated_time", insertable = true, updatable = true)
	private Date updatedTime = new Date();
}
