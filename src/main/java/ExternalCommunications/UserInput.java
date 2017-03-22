package ExternalCommunications;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * Created by aditya.mullela on 13/02/17.
 */

@Setter
@Getter
public class UserInput {

    private static Scanner scanner;
    private int numberOfReservations;
    private int codeForTypeOfReservation;

    private String initialFulfillReferenceId;
    private String initialRestBusMessageId;
    private String initialShipTogetherReferenceId;
    private String warehouseId;

    private Scanner getScanner() {
        initiateScanner();
        return scanner;
    }

    private static Scanner initiateScanner() {
        scanner = new Scanner(System.in);
        return scanner;
    }

    public int askTypeOfReservation(){

        System.out.println("Enter type of reservations to be created");
        System.out.println("Type of possilbe reservations :" + "1. 1 Item 1 Quantity \n" +
                "2. 1 Item multiple Quantity \n" + "3. MultiItem 1 quantity \n"
                    + "4. MultiItem MultiQuantity");

        setCodeForTypeOfReservation(getScanner().nextInt());

        return getCodeForTypeOfReservation();
    }

    public int askNumberOfReservations(){

        System.out.println("Enter number of reservations to be created");

        setNumberOfReservations(getScanner().nextInt());

        return getNumberOfReservations();
    }

    public String askInitialFulfillReferenceId(){

        System.out.println("Enter the first in the series of fulfill reference ids");
        System.out.println("It should be of the format b2c_xxxxx");

        setInitialFulfillReferenceId(getScanner().next());

        return getInitialFulfillReferenceId();
    }

    public String askInitialRestBusMessageId(){

        System.out.println("Enter the first in the series of rest bus message ids");
        System.out.println("It should be of the format some chars followed by some digits");
        setInitialRestBusMessageId(getScanner().next());

        return getInitialRestBusMessageId();
    }

    public String askInitialShipTogetherConstraintId(){

        System.out.println("Enter the first in the series of ship together constraint ids");
        System.out.println("It should be of the format some chars followed by some digits");
        setInitialShipTogetherReferenceId(getScanner().next());

        return getInitialShipTogetherReferenceId();

    }

    public String askWareHouseId(){

        System.out.println("Enter the warehouse id in which the test should be done");
        System.out.println("Please make sure the right WH id is correct");

        setWarehouseId(getScanner().next());

        return getWarehouseId();
    }

    public int askForNumberOfItems(){

        System.out.println("Enter the number of items");

        return getScanner().nextInt();
    }

    public int askTypeOfBusinessService(){

        System.out.println("Enter type of request (BS types) to be created");
        System.out.println("Type of possible business service types :" + "1. FA_FORWARD_E2E_EKART \n" +
                "2. FA_FORWARD_3PL_HANDOVER \n" + "3. FA_FORWARD_E2E_EKART_WITH_INVERNTORY_TRANSFER \n"
                + "4. FA_FORWARD_3PL_HANDOVER_WITH_INVERNTORY_TRANSFER \n" + "5. NON_FA_FORWARD_E2E_EKART \n"
                        + "6. NON_FA_FORWARD_3PL_HANDOVER \n");

        return getScanner().nextInt();
    }

    public int askMode(){

        System.out.println("Enter mode to be created");
        System.out.println("Modes :" + "0. Give offset \n" + "1. set data explicilty");

        return getScanner().nextInt();

    }

    public int askOffset(){

        System.out.println("Enter offset for ffid, restbus messageID, ship together id");

        return getScanner().nextInt();
    }
}
