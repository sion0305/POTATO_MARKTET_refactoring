package com.ssg.potato.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.item.model.AuctionThumb;
import com.ssg.potato.item.model.GroupThumb;
import com.ssg.potato.item.model.ItemThumb;
import com.ssg.potato.item.model.Thumb;

public interface SearchDao {
	
	public List<GroupThumb> getGroupsList() throws DataAccessException ;
	
	public List<ItemThumb> getItemsList() throws DataAccessException ;
	
	public List<AuctionThumb> getAuctionsList() throws DataAccessException ;
	
	public List<GroupThumb> getGroupsAddList(String member_id) throws DataAccessException ;
	
	public List<ItemThumb> getItemsAddList(String member_id) throws DataAccessException ;
	
	public List<AuctionThumb> getAuctionsAddList(String member_id) throws DataAccessException ;
	
	public List<Thumb> getMainList() throws DataAccessException;
	
}
