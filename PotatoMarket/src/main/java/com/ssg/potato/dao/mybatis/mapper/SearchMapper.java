package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;
import com.ssg.potato.item.model.Thumb;

@Mapper
public interface SearchMapper {
	List<GroupThumb> getGroupsList();
	
	List<Thumb> getMainList();

	List<ItemThumb> getItemsList();

	List<AuctionThumb> getAuctionsList();

	List<GroupThumb> getGroupsAddList(String member_id);

	List<AuctionThumb> getAuctionsAddList(String member_id);

	List<ItemThumb> getItemsAddList(String member_id);

}
