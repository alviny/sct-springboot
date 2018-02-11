package com.sct.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import com.sct.dao.CustomerDAO;
import com.sct.rest.vo.Customer;

@RestController
@RequestMapping(value="/service")
@CrossOrigin()
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	@Autowired
	CustomerDAO dao;
    @ControllerAdvice
    static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    		public JsonpAdvice() {
            super("callback");
        }
    }	
	@RequestMapping(value="customer", method=RequestMethod.GET)
	@ResponseBody
	public List<Customer> getCustomers(){
		logger.info("get customers");
		return dao.getCustomers();
	}
	@RequestMapping(value="customers/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Customer getCustomer(@PathVariable Long id){
		Customer customer = null;
		try {
			customer =  dao.getCustomer(id);
		} catch (SQLException e) {
			logger.error(ExceptionUtils.getRootCause(e));
		}
		return customer;
	}
	@RequestMapping(value="customer", method=RequestMethod.PUT)
	public ResponseEntity<String> newCustomer(@RequestBody Customer customer) {
		ResponseEntity<String> resp;
		logger.info("create customer ");
		try {
			dao.saveCustomer(customer);
			resp = ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(SQLException e) {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return resp;
	}
	@RequestMapping(value="customer/{id}", method=RequestMethod.POST)
	public ResponseEntity<String> updateCustomer( @PathVariable Long id,@RequestBody Customer customer) {
		ResponseEntity<String> resp;
		logger.info("update customer id:" + id );
		try {
			dao.updateCustomer(id, customer);
			resp = ResponseEntity.status(HttpStatus.OK).build();
		}catch(SQLException e) {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return resp;
	}	
	@RequestMapping(value="customer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer( @PathVariable Long id) {
		ResponseEntity<String> resp;
		logger.info("delete customer id:" + id );

		try {
			dao.deleteCustomer(id);
			resp = ResponseEntity.status(HttpStatus.OK).build();
		}catch(SQLException e) {
			resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return resp;
	}	
}
