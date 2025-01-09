package vttp5a_paf.day21ws_official.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import vttp5a_paf.day21ws_official.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers", produces = "application/json")
    public ResponseEntity<String> getAllCustomers(@RequestParam (defaultValue = "5") int limit, 
    @RequestParam (defaultValue = "0") int offset) {
        
        return ResponseEntity.ok().body(customerService.getAllCustomers(limit, offset).toString());
    }

    @GetMapping(path = "/customer/{customer_id}", produces = "application/json")
    public ResponseEntity<String> getCustomerById(@PathVariable int customer_id) {
        JsonObject jObject = customerService.getCustomerById(customer_id);
        try {
            jObject.getString("error");
            return ResponseEntity.status(404).body(jObject.toString());
        } catch (Exception e) {
            return ResponseEntity.status(200).body(jObject.toString());
        }
    }
}
