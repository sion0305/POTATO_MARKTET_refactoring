package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;

@Mapper
public interface HistoryMapper {

	public List<ItemThumb> PurchasedItemFind(String member_id);

	public List<GroupThumb> PurchasedGItemFind(String member_id);
	
	public List<AuctionThumb> PurchasedAItemFind(String member_id);

}
