package com.sct.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sct.rest.vo.Item;

@RestController
@RequestMapping(value="/service")
@CrossOrigin()
public class CustomerOrderController {

	@RequestMapping(value="customer-order", method=RequestMethod.GET)
	@ResponseBody
	public List<Item> getCustomerOrder(){
		return null;
	}
}
