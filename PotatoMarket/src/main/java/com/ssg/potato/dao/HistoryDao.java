package com.ssg.potato.dao;

import java.util.List;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;

public interface HistoryDao {

	//직접거래아이템정보 찾기
	public List<ItemThumb> PurchasedItemFind(String member_id)throws Exception;
	//공동구매아이템정보 찾기
	public List<GroupThumb> PurchasedGItemFind(String member_id) throws Exception;
	//경매아이템정보 찾기
	public List<AuctionThumb> PurchasedAItemFind(String member_id) throws Exception;
		
}
