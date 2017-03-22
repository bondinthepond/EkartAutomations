import ExternalCommunications.UserInput;
import Flows.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * Created by aditya.mullela on 13/02/17.
 */
@Getter
@Setter
public class InitialInputs {

    private int numberOfReservations;
    private int typeOfReservations;

    private String initialRestBusMessageId;
    private String initialFulfillReferenceId;
    private String initialShipTogetherConstraintId;

    String currentRestBusMessageId;
    String currentFulfillReferenceId;
    String currentShipTogetherConstraintId;

    public void takeInitialInputs() throws IOException {

        UserInput userInput = new UserInput();

        setTypeOfReservations(userInput.askTypeOfReservation());

        GenericFlow genericFlow = null;
        if(getTypeOfReservations() == 1) {

            genericFlow = new OneItemOneQuantity();

        } else if(getTypeOfReservations() == 2) {

            genericFlow = new OneItemMultiQuantity();

        } else if(getTypeOfReservations() == 3) {

            genericFlow = new MultiItemOneQuantity();

        } else if(getTypeOfReservations() == 4) {

            genericFlow = new MultiItemMultiQuantity();

        }
            genericFlow.execute();
        }
}
