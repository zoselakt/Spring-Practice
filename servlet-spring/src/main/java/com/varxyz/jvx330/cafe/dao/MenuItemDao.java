package com.varxyz.jvx330.cafe.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.cafe.MenuItem;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MenuItemDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insertMenu(MenuItem menuItem) {
		String sql = "insert into cafemenu (menuItem, addother, menuPrice, menuItemCount, ishot) values(?,?,?,?,?)";
		return jdbcTemplate.update(sql, menuItem.getMenuItem(), menuItem.getAddOther(), 
				menuItem.getMenuPrice(), menuItem.getMenuItemCount(), menuItem.isHot());
	}
}
