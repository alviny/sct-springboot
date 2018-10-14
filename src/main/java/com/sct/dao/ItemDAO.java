package com.sct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sct.rest.controller.ItemController;
import com.sct.rest.vo.Item;

@Repository
public class ItemDAO {
	private static final Logger logger = Logger.getLogger(ItemDAO	.class);

    private JdbcTemplate jdbcTemplate;
	public ItemDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Item> getItems(){
		logger.info("get items");

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
		jdbcTemplate.update("insert into item(summary,description,price) values(?,?,?)",item.getSummary(),item.getDescription(),item.getPrice());
	}
	public void updateItem(Long id, Item item) throws SQLException{
		jdbcTemplate.update("update item set summary=?,description=?,price=? where id=?",item.getSummary(),item.getDescription(),item.getPrice(), id);
	}
	public void deleteItem(Long id) throws SQLException{
		jdbcTemplate.update("delete from item where id=?", id);		
	} 
	
}
