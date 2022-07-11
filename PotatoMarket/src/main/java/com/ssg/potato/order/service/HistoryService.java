package com.ssg.potato.order.service;

import java.util.List;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;

public interface HistoryService {
	List<ItemThumb> findItem(String member_id) throws Exception;
	List<GroupThumb> findGItem(String member_id) throws Exception;
	List<AuctionThumb> findAItem(String member_id) throws Exception;

}
