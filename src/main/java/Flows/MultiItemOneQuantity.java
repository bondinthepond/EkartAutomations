package Flows;

import ExternalCommunications.UserInput;
import Reservation.Reservation;
import Utils.PreparePayload;

import java.io.IOException;

/**
 * Created by aditya.mullela on 13/02/17.
 */
public class MultiItemOneQuantity extends OneItemOneQuantity {

    private static PreparePayload preparePayload;
    private static UserInput userInput;

    @Override
    public Reservation prepareThePayload(String currentFulfillReferenceId, String currentRestBusMessageId,
                                         String currentShipTogetherReferenceId, int businessServiceType) throws IOException {

        userInput = new UserInput();
        int numberOfItems = userInput.askForNumberOfItems();
        preparePayload = new PreparePayload();

        return preparePayload.getReservationObjectForMIOQ(currentFulfillReferenceId, currentShipTogetherReferenceId,
                numberOfItems,businessServiceType);
    }
}
