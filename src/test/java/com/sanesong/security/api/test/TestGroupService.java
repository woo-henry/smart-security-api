package com.sanesong.security.api.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sanesong.security.api.WebApplication;
import com.sanesong.security.api.entity.Group;
import com.sanesong.security.api.entity.GroupType;
import com.sanesong.security.api.service.GroupService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestGroupService {

	@Autowired
	private GroupService groupService;
	
	@Test
	public void testSaveGroups() {
		final List<Group> groups = new ArrayList<Group>();
		for(int i = 0; i < 10; i++) {
			final Group group = new Group();
			group.setGroupName(String.format("Group-%02d", i + 1));
			group.setGroupType(GroupType.GROUP_DEVICE);
			group.setSortKey(i+1);
			groups.add(group);
		}
		
		for(int i = 10; i < 20; i++) {
			final Group group = new Group();
			group.setGroupName(String.format("Group-%02d", i + 1));
			group.setGroupType(GroupType.GROUP_SYSTEM);
			group.setSortKey(i+1);
			groups.add(group);
		}
		
		for(int i = 20; i < 30; i++) {
			final Group group = new Group();
			group.setGroupName(String.format("Group-%02d", i + 1));
			group.setGroupType(GroupType.GROUP_TAG);
			group.setSortKey(i+1);
			groups.add(group);
		}
		
		final List<Group> saved = groupService.saveGroups(groups);
		assertNotNull(saved);
	}
}
