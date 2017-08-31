package com.example.vaadindemo.service;

import com.example.vaadindemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bk on 31/08/2017.
 */
@Component
public class CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List findAll() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                        rs.getString("first_name"), rs.getString("last_name")));
    }
    public void update(Customer customer) {
        jdbcTemplate.update(
                "UPDATE customers SET first_name=?, last_name=? WHERE id=?",
                customer.getFirstName(), customer.getLastName(), customer.getId());
    }

    public List findAllWithProcedure() {
        return jdbcTemplate.query("CALL find_all_customers()", (rs, rowNum) -> new Customer(rs.getLong("id"),
                rs.getString("first_name"), rs.getString("last_name")));
    }
}
