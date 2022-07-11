package com.ssg.potato.item.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ssg.potato.item.model.ItemThumb;

public interface ItemSearchRepository extends JpaRepository<ItemThumb, String>{

	List<ItemThumb> findByTitleContaining(String title);
}
