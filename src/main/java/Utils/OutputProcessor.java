package Utils;

import Outputs.RawStoreOutput;
import Outputs.SRMSResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by aditya.mullela on 16/02/17.
 */
public class OutputProcessor {

    RawStoreOutput rawStoreObject;
    GetDataFromDBs getDataFromDBs;
    SRMSResponse srmsResponse;

    public void processOutput(String result){

        OutputWriter writer = new OutputWriter();
        rawStoreObject = getRawStoreObject(result);


        getDataFromDBs = new GetDataFromDBs();

        String responseFromSRMS = getDataFromDBs.getData(rawStoreObject.getServiceRequestBundleId());

        if(responseFromSRMS != null) {
            srmsResponse = getSrmsResponse(responseFromSRMS);
            writer.writeToOutput(result.toString(), srmsResponse.getResponse());
        } else {
            writer.writeToOutputWithoutSRMSResponse(result.toString());
        }

        System.out.println(result.toString());

    }

    public RawStoreOutput getRawStoreObject(String result) {

        ObjectMapper mapper = new ObjectMapper();
        RawStoreOutput output = null;
        try {
            output = mapper.readValue(result.toString(), RawStoreOutput.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public SRMSResponse getSrmsResponse(String srmsResponse) {

        ObjectMapper mapper = new ObjectMapper();
        SRMSResponse output = null;
        try {
            output = mapper.readValue(srmsResponse, SRMSResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;

    }
}
