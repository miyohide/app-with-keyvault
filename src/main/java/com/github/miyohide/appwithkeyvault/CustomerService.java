package com.github.miyohide.appwithkeyvault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomerList() {
        log.info("Start getCustomerList ...");
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        List<Customer> customers = jdbcTemplate.query(
                "SELECT * FROM customers", rowMapper);
        log.info("End getCustomerList");
        return customers;
    }

    public void insertCustomers() {
        log.info("Start insertCustomers");
        List<Object[]> splitUpNames = Arrays.asList(
                "John Woo", "Jeff Dean", "Josh Bloch", "Josh Long"
        ).stream().map(name -> name.split(" "))
                        .collect(Collectors.toList());
        jdbcTemplate.batchUpdate(
                "INSERT INTO customers(first_name, last_name) VALUES (?, ?)",
                splitUpNames
        );
        log.info("End insertCustomers");
    }
}
