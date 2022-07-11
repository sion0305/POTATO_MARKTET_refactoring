package com.ssg.potato.item.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssg.potato.item.model.GroupThumb;

public interface GroupSearchRepository extends JpaRepository<GroupThumb, String>{

	List<GroupThumb> findByTitleContaining(String title);
}
