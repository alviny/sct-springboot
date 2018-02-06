package com.sct.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sct.dao.ItemDAO;
import com.sct.rest.vo.Item;

@RestController
@RequestMapping(value="/service")
@CrossOrigin()
public class ItemController {
	private static final Logger logger = Logger.getLogger(ItemController.class);
	@Autowired
	ItemDAO dao;
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	@ResponseBody
	public List<Item> getItems(){
		return dao.getItems();
	}
	@RequestMapping(value="items/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Item getItem(@PathVariable Long id){
		Item item = null;
		try {
			item =  dao.getItem(id);
		} catch (SQLException e) {
			logger.error(ExceptionUtils.getRootCause(e));
		}
		return item;
	}
	@RequestMapping(value="item", method=RequestMethod.PUT)
	public ResponseEntity<String> newItem(@RequestBody Item item) {
		ResponseEntity<String> resp;
		try {
			dao.saveItem(item);
			resp = ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(SQLException e) {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return resp;
	}
	@RequestMapping(value="item", method=RequestMethod.POST)
	public ResponseEntity<String> updateItem(@RequestBody Item item) {
		ResponseEntity<String> resp;
		try {
			dao.saveItem(item);
			resp = ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(SQLException e) {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return resp;
	}	
}
