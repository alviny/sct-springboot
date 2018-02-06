package com.sct.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sct.rest.vo.Item;

@Repository
public class ItemDAO {
    private JdbcTemplate jdbcTemplate;
	public ItemDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Item> getItems(){
		RowMapper<Item> rm = new BeanPropertyRowMapper<Item>(Item.class);
		List<Item> items = jdbcTemplate.query("select * from item", rm);
		return items;
	}
	public Item getItem(Long id) throws SQLException {
		RowMapper<Item> rm = new BeanPropertyRowMapper<Item>(Item.class);
		List<Item> items =jdbcTemplate.query("select * from item where id=?",new Object[] {id}, rm);
		Item item = null;
		if( items.size() == 1) {
			item = items.get(0);
		}else {
			throw new SQLException("Returned more than one row.");
		}
		return item;
	}
	public void saveItem(Item item) throws SQLException{
		jdbcTemplate.update("INSERT INTO ITEM(SUMMARY,DESCRIPTION,PRICE) VALUES(?,?,?)",item.getSummary(),item.getDescription(),item.getPrice());
	}
}
