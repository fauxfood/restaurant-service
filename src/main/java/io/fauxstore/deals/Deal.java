package io.fauxstore.deals;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Deal {
    private final UUID id;
    private final String description;
    private final String promoCode;

    public static Deal fakeDeal(){
        var faker = new Faker();

        return Deal.builder()
                .id(UUID.randomUUID())
                .description(faker.commerce().productName())
                .promoCode(faker.commerce().promotionCode().toUpperCase())
            .build();
    }
}
