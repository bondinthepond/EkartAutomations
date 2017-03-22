package Reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.mullela on 13/02/17.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reservation {

    public List<ReservationPayload> getReservationPayloads() {
        return reservationPayloads;
    }

    public void setReservationPayloads(List<ReservationPayload> reservationPayloads) {
        this.reservationPayloads = reservationPayloads;
    }

    @JsonProperty("reservations")
    private List<ReservationPayload> reservationPayloads = new ArrayList();
}
