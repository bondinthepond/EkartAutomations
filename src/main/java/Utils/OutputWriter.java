package Utils;

import Outputs.ServiceRequest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by aditya.mullela on 16/02/17.
 */


public class OutputWriter {

    public void writeToOutput(String result, List<ServiceRequest> SRIDs) {

        String FILENAME = "/Users/aditya.mullela/Desktop/CreatedStuff/Output.txt";

        try {

            FileWriter fw = new FileWriter(FILENAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String content = result;

            bw.write(content);
            bw.flush();

            for(int i = 0; i< SRIDs.size(); i++) {
                bw.write(SRIDs.get(i).getServiceRequestId().toString());
                bw.flush();
            }

            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToOutputWithoutSRMSResponse(String result) {

        String FILENAME = "/Users/aditya.mullela/Desktop/CreatedStuff/Output.txt";

        try {

            FileWriter fw = new FileWriter(FILENAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String content = result;

            bw.flush();
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
