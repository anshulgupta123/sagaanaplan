package com.example.userservicesaga.projection;

import com.example.commonservicesaga.modals.CardDetails;
import com.example.commonservicesaga.modals.User;
import com.example.commonservicesaga.query.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        //Ideally Get the details from the DB
        CardDetails cardDetails
                = CardDetails
                .builder()
                .name("Shabbir Dawoodi")
                .validUntilYear(2022)
                .validUntilMonth(01)
                .cardNumber("123456789")
                .cvv(111)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .cardDetails(cardDetails)
                .build();
    }
}
