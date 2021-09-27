package com.techgatha.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
	
	ConcurrentHashMap<Integer, Customer> customers = new ConcurrentHashMap<Integer, Customer>();

	public CustomerResource() {
		customers.put(1, new Customer(1, "Shalini"));
		customers.put(2, new Customer(2, "Siya"));
	}
	@GetMapping
	public String message()
	{
		return "Hello from customer resource";
	}
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id)
	{
		
		return new Customer(id, "Shalini");
	}
	@GetMapping("/")
	public ArrayList<Customer> getCustomers()
	{
		
		return new ArrayList<Customer>(customers.values());
	}
	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		System.out.println("Post "+customer);
		customers.put(customer.getCid(), customer);
		return customer;
	}
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		for(int i=0;i<customers.size();i++)
		{
			Customer customer = customers.get(id);
			if(customer.getCid() == id)
			{
				customers.remove(id);
				break;
			}
		}
		System.out.println("deleted");
		System.out.println(customers);
		return "Deleted";
	}
}
