package Utils;

import Reservation.Reservation;
import Reservation.ReservationPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.mullela on 13/02/17.
 */
@Setter
@Getter
public class PreparePayload {

    private static ObjectMapper mapper;
    private Reservation reservation;
    private IdGenerators idGenerators;
    private List<ReservationPayload> reservationPayloadList;
    private ReservationPayload reservationPayload;

    public Reservation getReservationObject(String currentFulfillReferenceId,
                                            String currentShipTogetherReferenceId, int businessServiceType) throws IOException {

        reservation = new Reservation();
        reservationPayloadList = new ArrayList<ReservationPayload>();

        reservationPayload = getStandardReservationPayload(businessServiceType);

        reservationPayload.setFulfillReferenceId(currentFulfillReferenceId);
        reservationPayload.setShipTogetherPreferenceId(currentShipTogetherReferenceId);

        reservationPayloadList.add(reservationPayload);

        reservation.setReservationPayloads(reservationPayloadList);

        return reservation;
    }

    public Reservation getReservationObjectForMIOQ (String currentFulfillReferenceId,
                                                    String currentShipTogetherReferenceId, int numberOfItems,
                                                    int businessServiceType) throws IOException {

        reservation = new Reservation();
        reservationPayloadList = new ArrayList<ReservationPayload>();
        idGenerators = new IdGenerators();

        for(int i = 0; i < numberOfItems; i++){
            String temp = idGenerators.getNextFulfillReferenceIdForMIOQ(currentFulfillReferenceId, i);
            ReservationPayload reservationPayload = getStandardReservationPayload(businessServiceType);
            reservationPayload.setFulfillReferenceId(temp);
            reservationPayload.setShipTogetherPreferenceId(currentShipTogetherReferenceId);
            reservationPayloadList.add(reservationPayload);
        }

        reservation.setReservationPayloads(reservationPayloadList);

        return reservation;
    }


    public ReservationPayload getStandardReservationPayload(int businessServiceType) throws IOException {

        mapper = new ObjectMapper();

        String pathName = null;

        if(businessServiceType == 1) {
            pathName = "/Users/aditya.mullela/git2/Automations/src/main/resources/FAForwardE2EEkart.json";
        } else if(businessServiceType == 2) {
            pathName = "/Users/aditya.mullela/git2/Automations/src/main/resources/FAForward3PLhandover.json";
        } else if(businessServiceType == 3) {
            pathName = "/Users/aditya.mullela/git2/Automations/src/main/resources/FAFwdE2EEkartWithIT.json";
        } else if(businessServiceType == 4) {
            pathName = "/Users/aditya.mullela/git2/Automations/src/main/resources/FAFwd3PLhandoverWithIT.json";
        }

            ReservationPayload reservationPayload = mapper.readValue(new File(pathName),
                        ReservationPayload.class);

        return reservationPayload;
    }

    public String convertPayloadToString(Reservation reservation){

        try {
            return mapper.writeValueAsString(reservation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
