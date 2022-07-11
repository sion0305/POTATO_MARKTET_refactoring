package com.ssg.potato.item.service;

import com.ssg.potato.item.model.Group;

public interface GroupService {
	void insert(Group group, String member_id);

	void update(Group group);

	void delete(int group_id);

	Group selectGroup(int group_id);
	
	int selectGroupId(String member_id);
}
