package Flows;

import ExternalCommunications.UserInput;
import Reservation.Reservation;
import Utils.IdGenerators;
import Utils.MessageClient;
import Utils.PreparePayload;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * Created by aditya.mullela on 13/02/17.
 */

@Setter
@Getter
public class OneItemOneQuantity implements GenericFlow {

    private static UserInput userInput;
    private static IdGenerators idGenerators;
    private static PreparePayload preparePayload;
    private Reservation reservation;
    private MessageClient client;

    public static UserInput getUserInput() {
        return userInput;
    }

    public static void setUserInput(UserInput userInput) {
        OneItemOneQuantity.userInput = userInput;
    }

    public static IdGenerators getIdGenerators() {
        return idGenerators;
    }

    public static void setIdGenerators(IdGenerators idGenerators) {
        OneItemOneQuantity.idGenerators = idGenerators;
    }

    public static PreparePayload getPreparePayload() {
        return preparePayload;
    }

    public static void setPreparePayload(PreparePayload preparePayload) {
        OneItemOneQuantity.preparePayload = preparePayload;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public MessageClient getClient() {
        return client;
    }

    public void setClient(MessageClient client) {
        this.client = client;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getCurrentFulfillReferenceId() {
        return currentFulfillReferenceId;
    }

    public void setCurrentFulfillReferenceId(String currentFulfillReferenceId) {
        this.currentFulfillReferenceId = currentFulfillReferenceId;
    }

    public String getCurrentRestBusMessageId() {
        return currentRestBusMessageId;
    }

    public void setCurrentRestBusMessageId(String currentRestBusMessageId) {
        this.currentRestBusMessageId = currentRestBusMessageId;
    }

    public String getCurrentShipTogetherReferenceId() {
        return currentShipTogetherReferenceId;
    }

    public void setCurrentShipTogetherReferenceId(String currentShipTogetherReferenceId) {
        this.currentShipTogetherReferenceId = currentShipTogetherReferenceId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getBusinessServiceType() {
        return BusinessServiceType;
    }

    public void setBusinessServiceType(int businessServiceType) {
        BusinessServiceType = businessServiceType;
    }

    private int numberOfReservations;
    private int mode;

    private String currentFulfillReferenceId;
    private String currentRestBusMessageId;
    private String currentShipTogetherReferenceId;

    private String warehouseId;

    private String payload;
    private int BusinessServiceType;

    public IdGenerators setIdGenerators(){
        return new IdGenerators();
    }

    public UserInput setUserInput() {
        return new UserInput();
    }

    public void execute() throws IOException {

        userInput = setUserInput();

        setNumberOfReservations(userInput.askNumberOfReservations());
        setMode(userInput.askMode());

        if(mode == 0) {
            int offset = userInput.askOffset();

            setCurrentFulfillReferenceId("b2c_6789340" + offset);
            setCurrentRestBusMessageId("HRISHIDADA8" + offset);
            setCurrentShipTogetherReferenceId("CNTCTBE01B19903B67893408" + offset);
        } else {
            setCurrentFulfillReferenceId(userInput.askInitialFulfillReferenceId());
            setCurrentRestBusMessageId(userInput.askInitialRestBusMessageId());
            setCurrentShipTogetherReferenceId(userInput.askInitialShipTogetherConstraintId());
        }

        setBusinessServiceType(userInput.askTypeOfBusinessService());

        idGenerators = setIdGenerators();
        client = new MessageClient();
        preparePayload = new PreparePayload();

        for(int i = 0; i < getNumberOfReservations(); i++){
            reservation = new Reservation();
            reservation = prepareThePayload(getCurrentFulfillReferenceId(), getCurrentRestBusMessageId(),
                    getCurrentShipTogetherReferenceId(), getBusinessServiceType());

            payload = preparePayload.convertPayloadToString(reservation);

            client.makeCall(getCurrentRestBusMessageId(), payload);

            setCurrentFulfillReferenceId(idGenerators.getNextFulfillReferenceId(getCurrentFulfillReferenceId()));
            setCurrentRestBusMessageId(idGenerators.getNextrestBusMessageId(getCurrentRestBusMessageId()));
            setCurrentShipTogetherReferenceId(idGenerators.getNextShipTogetherReferenceId(getCurrentShipTogetherReferenceId()));
            }
    }


    public Reservation prepareThePayload(String currentFulfillReferenceId, String currentRestBusMessageId,
                                  String currentShipTogetherReferenceId, int businessServiceType ) throws IOException {

        preparePayload = new PreparePayload();

        return preparePayload.getReservationObject(currentFulfillReferenceId, currentShipTogetherReferenceId, businessServiceType);
    }
}
