package Flows;

import Reservation.Reservation;
import Utils.PreparePayload;

import java.io.IOException;

/**
 * Created by aditya.mullela on 13/02/17.
 */
public class MultiItemMultiQuantity extends OneItemOneQuantity {

    private static PreparePayload preparePayload;

    @Override
    public Reservation prepareThePayload(String currentFulfillReferenceId, String currentRestBusMessageId,
                                         String currentShipTogetherReferenceId, int businessServiceType) throws IOException {

        preparePayload = new PreparePayload();

        return preparePayload.getReservationObject(currentFulfillReferenceId, currentShipTogetherReferenceId, businessServiceType);
    }
}
