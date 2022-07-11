package com.ssg.potato.item.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssg.potato.item.model.AuctionThumb;

public interface AuctionSearchRepository extends JpaRepository<AuctionThumb, String>{

	List<AuctionThumb> findByTitleContaining(String title);
}
