package io.fauxstore.deals;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Deal {
    private final String description;
    private final String promoCode;

    public static Deal fakeDeal(){
        var faker = new Faker();

        return Deal.builder()
                .description(faker.commerce().productName())
                .promoCode(faker.commerce().promotionCode().toUpperCase())
            .build();
    }
}
