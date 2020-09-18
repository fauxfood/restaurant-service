package io.fauxstore.deals;

import io.fauxstore.deals.db.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RootController {
    private final DealsRepository dealsRepo;

    @Autowired
    public RootController(DealsRepository dealsRepo) {
        this.dealsRepo = dealsRepo;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to Deals service (maybe you wanted /deals)";
    }

    @RequestMapping("/deals")
    List<Deal> deals() {
        final List<Deal> deals = dealsRepo.selectSomeDeals(10);
        return deals;
    }
}
