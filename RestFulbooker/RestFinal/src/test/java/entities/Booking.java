package entities;

import lombok.Getter;
import lombok.Setter;

public class Booking {
    @Getter @Setter
    private String firstname;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String totalprice;

    @Getter @Setter
    private String depositpaid;

    @Getter @Setter
    private BookingDates bookingdates;

    @Getter @Setter
    private String additionalneeds;

    // Clase anidada para las fechas
    public static class BookingDates {
        @Getter @Setter
        private String checkin;

        @Getter @Setter
        private String checkout;
    }
}
