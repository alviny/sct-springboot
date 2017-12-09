package com.sct.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sct.rest.vo.PurchasedItem;

@RestController
@RequestMapping(value="/service")
@CrossOrigin()
public class TransactionController {

	@RequestMapping(value="items", method=RequestMethod.GET)
	@ResponseBody
	public List<PurchasedItem> getItems() {
		List<PurchasedItem> items = new ArrayList<PurchasedItem>();
		PurchasedItem item = new PurchasedItem();
		item.setPrice(5.50F);
		item.setDescription("Fish");
		items.add(item);
	    return items;
	}
}
