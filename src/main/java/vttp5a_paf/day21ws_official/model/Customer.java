package vttp5a_paf.day21ws_official.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Customer {
    private Integer customerId;
    private String company;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String address;
    private String city;

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public static Customer toCustomer(SqlRowSet rs) {
        Customer c = new Customer();

        c.setCustomerId(rs.getInt("id"));
        c.setCompany(rs.getString("company"));
        c.setLastName(rs.getString("last_name"));
        c.setFirstName(rs.getString("first_name"));
        c.setJobTitle(rs.getString("job_title"));
        c.setAddress(rs.getString("address"));
        c.setCity(rs.getString("city"));

        return c;
    }

    public static JsonObject toJson(Customer c) {
        JsonObject jObject = Json.createObjectBuilder()
                .add("customer_id", c.getCustomerId())
                .add("company", c.getCompany())
                .add("last_name", c.getLastName())
                .add("first_name", c.getFirstName())
                .add("job_title", c.getJobTitle())
                .add("address", c.getAddress())
                .add("city", c.getCity())
                .build();

        return jObject;
    }

}
