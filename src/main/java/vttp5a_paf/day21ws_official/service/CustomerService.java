package vttp5a_paf.day21ws_official.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp5a_paf.day21ws_official.model.Customer;
import vttp5a_paf.day21ws_official.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public JsonObject getAllCustomers(int limit, int offset) {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        List<Customer> customersList = customerRepository.getAllCustomers(limit, offset);
        for (Customer c : customersList){
            jsonArrayBuilder.add(Customer.toJson(c));
        }

        JsonObject jObject = Json.createObjectBuilder()
                .add("customers", jsonArrayBuilder.build())
                .build();

        return jObject;
    }

    public JsonObject getCustomerById(int customer_id){
        Optional<Customer> opt = customerRepository.getCustomerById(customer_id);

        if(opt.isEmpty()) {
            JsonObject error = Json.createObjectBuilder()
                    .add("error", "The customer id specified does not exist!")
                    .build();
            return error;
        } else {
            return Customer.toJson(opt.get());
        }
    }
}
