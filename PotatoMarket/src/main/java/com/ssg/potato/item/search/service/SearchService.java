package com.ssg.potato.item.search.service;

import java.util.List;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;
import com.ssg.potato.item.model.Thumb;

public interface SearchService {
	List<GroupThumb> getGroupsList();

	List<ItemThumb> getItemsList();

	List<AuctionThumb> getAuctionsList();

	List<GroupThumb> getGroupsAddList(String member_id);

	List<AuctionThumb> getAuctionsAddList(String member_id);

	List<ItemThumb> getItemsAddList(String member_id);

	List<Thumb> getMainList();

	//검색창 검색
	List<ItemThumb> searchItemList(String title);

	List<GroupThumb> searchGroupList(String title);

	List<AuctionThumb> searchAuctionList(String title);
}
