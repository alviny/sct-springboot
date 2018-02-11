package com.sct.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sct.rest.vo.Customer;

@Repository
public class CustomerDAO {
    private JdbcTemplate jdbcTemplate;
	public CustomerDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Customer> getCustomers(){
		RowMapper<Customer> rm = new BeanPropertyRowMapper<Customer>(Customer.class);
		List<Customer> customers = jdbcTemplate.query("select * from customer", rm);
		return customers;
	}
	public Customer getCustomer(Long id) throws SQLException {
		RowMapper<Customer> rm = new BeanPropertyRowMapper<Customer>(Customer.class);
		List<Customer> customers =jdbcTemplate.query("select * from customer where id=?",new Object[] {id}, rm);
		Customer customer = null;
		if( customers.size() == 1) {
			customer = customers.get(0);
		}else {
			throw new SQLException("Returned more than one row.");
		}
		return customer;
	}
	public void saveCustomer(Customer customer) throws SQLException{
		jdbcTemplate.update("INSERT INTO customer(first_name,last_name) VALUES(?,?)",customer.getFirstName(),customer.getLastName());
	}
	public void updateCustomer(Long id, Customer customer) throws SQLException{
		jdbcTemplate.update("UPDATE customer set first_name=?,last_name=? WHERE id=?",customer.getFirstName(),customer.getLastName(), id);
	}
	public void deleteCustomer(Long id) throws SQLException{
		jdbcTemplate.update("DELETE FROM customer WHERE id=?", id);		
	} 
	
}
