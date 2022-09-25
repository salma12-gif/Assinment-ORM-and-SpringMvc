package com.relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.relationship.Customer;
import com.relationship.dao.CustomerDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/customerForm")
	public String viewForm(Model m) {
		m.addAttribute("command",new Customer());
		return "OpenCustomerForm";
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public String addCustomerData(@ModelAttribute("customer") Customer customer) {
		customerDao.saveCustomerData(customer);
		
		return "redirect:/customer/viewList";
	}

	@RequestMapping("/viewList")
	public String viewCustomer(Model m) {
		List<Customer> customerList =customerDao.getCustomers();
		m.addAttribute("customerList",customerList);
		return "index";
	}
	
	@RequestMapping("/update/{custId}")
	public String updateCustomer(@PathVariable int custId,Model m) {
		Customer customer = customerDao.getCustomerById(custId);
		m.addAttribute("command",customer);
		return "customerUpdateForm";
	}
	 /* It updates model object. */    
    @RequestMapping(value="/saveUpdate",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("customer") Customer customer){    
    	customerDao.updateCustomer(customer);    
        return "redirect:/customer/viewList";    
    }    
    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteCustomer/{custId}",method = RequestMethod.GET)    
    public String delete(@PathVariable int custId){    
    	customerDao.deleteCustomer(custId);    
        return "redirect:/customer/viewList";    
    } 
    
  
    @RequestMapping(value="/index")    
    public String getList(){    
    	    
        return "redirect:/customer/viewList";    
    } 
}
