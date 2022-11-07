package com.greatlearning.customerrelations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerrelations.entity.Customer;
import com.greatlearning.customerrelations.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	/*
	 * using the @Autowired annotation, spring injects the service object of
	 * concrete-class implementing given interface
	 */
	@Autowired
	CustomerService custServ;

	/*
	 * URL: '/customerRelationshipManagement/customers/list' returns the model
	 * containing list of all customers along with viewname "list-customers"
	 */
	@RequestMapping("/list")
	public String showCustomerList(Model model1) {

		List<Customer> customers = custServ.findAll();

		model1.addAttribute("customers", customers);

		return "list-customers";
	}

	/*
	 * URL: "/customerRelationshipManagement/customers/showFormForAdd" takes Model
	 * object as an argument creates and returns an empty customer model to be
	 * populated by the user also returns viewname "customer-form"
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model2) {

		Customer customer1 = new Customer();

		model2.addAttribute("customer", customer1);

		return "customer-form";
	}

	/*
	 * URL:/customerRelationshipManagement/customers/showFormForUpdate
	 * takes customer id using @RequestParam and a Model object as argumnets.
	 * a record to be updated must be having an id, thus it retrieves the customer
	 * record from database using its id and passes it to server using Model object
	 * Also returns viewname "customer-form"
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model3) {

		Customer customer2 = custServ.findById(id);

		model3.addAttribute("customer", customer2);

		return "customer-form";
	}

	/*
	 * URL: /customerRelationshipManagement/customers/save
	 * takes all the user entered parameters using @RequestParam
	 * This button is used to save both new records and any updates
	 * 
	 * Case-1: New record will always have id=0
	 * 	new Customer object is created using constructor
	 * 
	 * Case-2: Existing records will have non-zero ids
	 * in this case updated fields are set using setters
	 * 
	 * Saves the record and redirects to "customers/list" page
	 */
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer3;
		if (id != 0) {
			customer3 = custServ.findById(id);
			customer3.setFirstName(firstName);
			customer3.setLastName(lastName);
			customer3.setEmail(email);
		} else {
			customer3 = new Customer(firstName, lastName, email);
		}

		custServ.save(customer3);

		return "redirect:/customers/list";
	}

	/*
	 * takes user entered customer id using request parameter annotation
	 * deletes the record using service object
	 * 
	 * redirects to "customers/list" page
	 */
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		custServ.deleteById(id);

		return "redirect:/customers/list";
	}

}
