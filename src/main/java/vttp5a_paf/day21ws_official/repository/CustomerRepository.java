package vttp5a_paf.day21ws_official.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5a_paf.day21ws_official.model.Customer;

@Repository
public class CustomerRepository {
    
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getAllCustomers(int limit, int offset) {
        List<Customer> customersList = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_CUSTOMERS, limit, offset);

        while (rs.next()){
            customersList.add(Customer.toCustomer(rs));
        }

        return customersList;
    }
}
