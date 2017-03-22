package Utils;

/**
 * Created by aditya.mullela on 13/02/17.
 */
public class IdGenerators {

    public String getNextShipTogetherReferenceId(String currentShipTogetherReferenceId) {

        return getNextString(currentShipTogetherReferenceId);
    }

    public String getNextFulfillReferenceId(String currentFulfillReferenceReferenceId) {

        return getNextString(currentFulfillReferenceReferenceId);
    }

    public String getNextrestBusMessageId(String currentRestBusMessageId) {

        return getNextString(currentRestBusMessageId);
    }

    public String getNextString(String string){

        StringBuilder stringBuilder = new StringBuilder(string);

        int offset = Character.getNumericValue(string.charAt(string.length() - 1));
        stringBuilder.deleteCharAt(string.length() - 1);
        offset++;
        stringBuilder.append(offset);

        return stringBuilder.toString();
    }

    public String getNextFulfillReferenceIdForMIOQ(String currentFulfillReferenceReferenceId, int i) {

        StringBuilder stringBuilder = new StringBuilder(currentFulfillReferenceReferenceId);
        stringBuilder.append(i);

        return stringBuilder.toString();
    }


}
