package com.greatlearning.customerrelations.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customerrelations.entity.Customer;
import com.greatlearning.customerrelations.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private Session session;

	/*
	 * the sessionFactory dependency from 'servlet.xml' file is injected using @Autowired
	 * 
	 * On failing to fetch current session the constructor attempts starting new session
	 */
	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	/*
	 * All service methods are annotated with @Transactional annotation to maintain
	 * data integrity.
	 * Also each method needs to create its own transaction, as the changes need to be 
	 * commited for every operation
	 */

	/*
	 * Starts transaction, retrieves all records from DB using from query
	 * and stores them Customer List object, which is then returned to calling
	 * function after commiting the transaction
	 */
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();

		List<Customer> customers = session.createQuery("from Customer").list();

		tx.commit();

		return customers;
	}

	/*
	 * Takes id as parameter
	 * Starts transaction, retrieves record with matching id from DB using session.get()
	 * function and stores it in Customer object
	 * commits the transaction
	 * and returns the Customer object
	 */
	@Transactional
	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();

		Customer customer1 = session.get(Customer.class, id);

		tx.commit();

		return customer1;
	}

	/*
	 * takes a Customer object to be saved as argument
	 * Starts transaction, saves the object record
	 * commits the transaction
	 */
	@Transactional
	public void save(Customer customer2) {
		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(customer2);

		tx.commit();

	}

	/*
	 * takes id as a parameter
	 * Starts transaction, retrieves record with matching id from DB using session.get()
	 * function and stores it in newly created Customer object
	 * deletes the corresponding record from DB using session.delete() method
	 * commits the transaction
	 */
	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();

		Customer customer3 = session.get(Customer.class, id);

		session.delete(customer3);

		tx.commit();

	}

}
