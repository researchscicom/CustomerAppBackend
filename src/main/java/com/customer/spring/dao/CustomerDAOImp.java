package com.customer.spring.dao;

import com.customer.spring.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImp implements CustomerDAO {
    @Autowired
    public SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> ls=sessionFactory.getCurrentSession().createQuery("from Customer").list();
        return ls;
    }

    @Override
    public Customer getCustomer(long id) {
        return sessionFactory.getCurrentSession().get(Customer.class,id);
    }

    @Override
    public Long saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer2 = session.byId(Customer.class).load(id);
        customer2.setAge(customer.getAge());
        customer2.setCity(customer.getCity());
        customer2.setEmail(customer.getEmail());
        customer2.setGender(customer.getGender());
        customer2.setName(customer.getName());
        customer2.setProId(customer.getProId());
        session.flush();
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer=sessionFactory.getCurrentSession().byId(Customer.class).load(id);
        sessionFactory.getCurrentSession().delete(customer);
    }
}
