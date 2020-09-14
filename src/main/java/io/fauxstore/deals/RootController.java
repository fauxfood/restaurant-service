package io.fauxstore.deals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RootController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to Deals service (maybe you wanted /deals)";
    }

    @RequestMapping("/deals")
    List<Deal> deals() {
        var response = Arrays.asList(
                Deal.fakeDeal(),
                Deal.fakeDeal(),
                Deal.fakeDeal(),
                Deal.fakeDeal(),
                Deal.fakeDeal(),
                Deal.fakeDeal()
        );
        return response;
    }
}
