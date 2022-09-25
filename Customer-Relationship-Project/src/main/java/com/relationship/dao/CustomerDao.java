package com.relationship.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.relationship.Customer;

public class CustomerDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int saveCustomerData(Customer customer) {
		String sql="insert into customerdata (custId,firstname,lastname,email) values("+customer.getCustId()+",'"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getEmail()+"')";    

		return template.update(sql);
	}

	public List<Customer> getCustomers(){    
	    return template.query("select * from customerdata ",new RowMapper<Customer>(){    
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
	        	Customer customer=new Customer();    
	        	customer.setCustId(rs.getInt(1));
	        	customer.setFirstName(rs.getString(2));
	        	customer.setLastName(rs.getString(3));
	        	customer.setEmail(rs.getString(4));
	        	
	            return customer;    
	       }    
	    });    
	}    
	
	public Customer getCustomerById(int custId) {
		String sql="select * from customerdata where custId=?";    
	    return template.queryForObject(sql, new Object[]{custId},new BeanPropertyRowMapper<Customer>(Customer.class)); 
	}

	public int updateCustomer(Customer customer) {
		 String sql="update customerdata set firstname='"+customer.getFirstName()+"', lastname='"+customer.getLastName()+"',email='"+customer.getEmail()+"' where custId="+customer.getCustId()+"";    
		 return template.update(sql); 		
	}

	public int deleteCustomer(int custId) {
		String sql="delete from customerdata where custId="+custId+"";    
	    return template.update(sql);    		
	}
	
	
}
