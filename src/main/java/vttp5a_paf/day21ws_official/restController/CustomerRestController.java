package vttp5a_paf.day21ws_official.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    

    @GetMapping(path = "/cutomers", produces = "application/json")
    public ResponseEntity<String> getAllCustomers(@RequestParam (defaultValue = "5") int limit, 
    @RequestParam (defaultValue = "0") int offset) {
        
        
        return null;
    }
}
