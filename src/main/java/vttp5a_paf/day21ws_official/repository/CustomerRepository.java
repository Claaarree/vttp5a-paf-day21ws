package vttp5a_paf.day21ws_official.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5a_paf.day21ws_official.model.Customer;
import vttp5a_paf.day21ws_official.model.Order;

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

    public Optional<Customer> getCustomerById(int customer_id) {
        
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_CUSTOMER_BY_ID, customer_id);

        if(!rs.next()) {
            return Optional.empty();
        } else {
            return Optional.of(Customer.toCustomer(rs));
        }
    }

    public Optional<List<Order>> getCutomerOrders(int customer_id) {
        Optional<Customer> opt = getCustomerById(customer_id);
        if (opt.isEmpty()){
            return Optional.empty();
        } else {
            List<Order> ordersList = new ArrayList<>();
            SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_CUSTOMER_ORDERS, customer_id);
            while (rs.next()){
                ordersList.add(Order.toOrder(rs));
            }
            return Optional.of(ordersList);
        }
    }
}
