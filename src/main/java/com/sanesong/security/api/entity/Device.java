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
@Table(name = "se_devices", indexes = { 
		@Index(name = "device_object_id", columnList = "object_id", unique = true),
})
public class Device implements Serializable {

	private static final long serialVersionUID = 2744318912094744072L;

	@JsonProperty(value = "object_id")
	@Id
	@GeneratedValue(generator = "primaryIdGenerator")
	@GenericGenerator(name = "primaryIdGenerator", strategy = "uuid.hex")
	@Column(name = "object_id", length = 32, nullable = false, unique = true)
	private String objectId;
	
	@JsonProperty(value = "device_id")
	@Column(name = "device_id", length = 128, nullable = false)
	private String deviceId;
	
	@JsonProperty(value = "device_name")
	@Column(name = "device_name", length = 128, nullable = false)
	private String deviceName;
	
	@JsonProperty(value = "device_model")
	@Column(name = "device_model", length = 64, nullable = false)
	private String deviceModel;
	
	@JsonProperty(value = "ip_address_v4")
	@Column(name = "ip_address_v4", length = 32, nullable = false)
	private String ipAddressV4;
	
	@JsonProperty(value = "ip_address_v6")
	@Column(name = "ip_address_v6", length = 64, nullable = false)
	private String ipAddressV6;
	
	@JsonProperty(value = "port")
	@Column(name = "port", nullable = false)
	private int port;
	
	@JsonProperty(value = "longtitude")
	@Column(name = "longtitude", nullable = false)
	private double longtitude;
	
	@JsonProperty(value = "latitude")
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
	@JsonProperty(value = "place_code")
	@Column(name = "place_code", nullable = false)
	private String placeCode;
	
	@JsonProperty(value = "place")
	@Column(name = "place", nullable = false)
	private String place;
	
	@JsonProperty(value = "org_code")
	@Column(name = "org_code", nullable = false)
	private String orgCode;
	
	@JsonProperty(value = "is_online")
	@Column(name = "is_online", nullable = false)
	private int isOnline;
	
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
