package vttp5a_paf.day21ws_official.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    
    @Autowired
    private JdbcTemplate template;

    public void getAllCustomers(int limit, int offset) {
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_CUSTOMERS, limit, offset);
    }
}
