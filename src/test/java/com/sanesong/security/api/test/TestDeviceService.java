package com.sanesong.security.api.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sanesong.security.api.WebApplication;
import com.sanesong.security.api.entity.Device;
import com.sanesong.security.api.service.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDeviceService {

	@Autowired
	private DeviceService deviceService;
	
	@Test
	public void testSaveDevices() {
		final List<Device> devices = new ArrayList<Device>();
		
		final Random random = new Random();
		random.setSeed(65536);
		
		for(int i = 0; i < 100; i++) {
			final Device device = new Device();
			device.setDeviceId(UUID.randomUUID().toString());
			device.setDeviceName(String.format("Device-%02d", i + 1));
			device.setDeviceModel(String.format("Model-%02d", i + 1));
			device.setIpAddressV4(String.format("IP-V4-%02d", i + 1));
			device.setIpAddressV6(String.format("IP-V6-%02d", i + 1));
			device.setPort(random.nextInt());
			final BigDecimal longtitude = new BigDecimal((double)((double)(1143600 + i) / 10000));
			device.setLongtitude(longtitude.doubleValue());
			final BigDecimal latitude = new BigDecimal((double)((double)(305400 + 1) / 10000));
			device.setLatitude(latitude.doubleValue());
			device.setPlaceCode(String.format("PalceCode-%02d", i + 1));
			device.setPlace(String.format("Palce-%02d", i + 1));
			device.setOrgCode(String.format("OrgCode-%02d", i + 1));
			device.setIsOnline(i / 2);
			device.setSortKey(i+1);
			devices.add(device);
		}
		
		final List<Device> saved = deviceService.saveDevices(devices);
		assertNotNull(saved);
	}
}
