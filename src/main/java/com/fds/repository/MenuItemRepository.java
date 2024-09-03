package com.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fds.model.MenuItems;

@Repository
public interface MenuItemRepository  extends JpaRepository<MenuItems, Integer> {
	
}