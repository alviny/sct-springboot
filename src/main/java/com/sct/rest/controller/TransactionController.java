package com.sct.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sct.dao.PurchasedItemDAO;
import com.sct.rest.vo.PurchasedItem;

@RestController
@RequestMapping(value="/service")
@CrossOrigin()
public class TransactionController {
	@Autowired
	PurchasedItemDAO dao;
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	@ResponseBody
	public List<PurchasedItem> getItems() {
	    return dao.getItems();
	}
}
