package entities;
import lombok.Getter;
import lombok.Setter;

public class BookingFail {
    @Getter
    @Setter
    private int firstname;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private int totalprice;

    @Getter @Setter
    private Boolean depositpaid;

    @Getter @Setter
    private Booking.BookingDates bookingdates;

    @Getter @Setter
    private String additionalneeds;


    public static class BookingDates {
        @Getter @Setter
        private String checkin;

        @Getter @Setter
        private String checkout;
    }
}
