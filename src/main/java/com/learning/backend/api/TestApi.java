package com.learning.backend.api;

import com.learning.backend.business.TestBusiness;
import com.learning.backend.exception.BaseException;
import com.learning.backend.model.MRegisterRequest;
import com.learning.backend.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestApi {

    //method 1 => field injection
//    @Autowired
//    private TestBusiness business;

    //method 2 => constructor injection
    private final TestBusiness business;

    public TestApi(TestBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test() {
        TestResponse response = new TestResponse();
        response.setName("Tae");
        response.setFood("Thai Food");

        return response;
    }


    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody MRegisterRequest request) throws BaseException {
        String response = business.register(request);
        return ResponseEntity.ok(response);

    }
}
