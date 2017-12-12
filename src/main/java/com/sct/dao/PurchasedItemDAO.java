package com.sct.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sct.rest.vo.PurchasedItem;

@Repository
public class PurchasedItemDAO {
    private JdbcTemplate jdbcTemplate;
	public PurchasedItemDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<PurchasedItem> getItems(){
		RowMapper<PurchasedItem> rm = new BeanPropertyRowMapper<PurchasedItem>(PurchasedItem.class);
		List<PurchasedItem> items = jdbcTemplate.query("select * from purchased_item", rm);
		return items;
	}
}
