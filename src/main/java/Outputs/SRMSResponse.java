package Outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * Created by aditya.mullela on 16/02/17.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SRMSResponse {

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<ServiceRequest> getResponse() {
        return response;
    }

    public void setResponse(List<ServiceRequest> response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("response")
    private List<ServiceRequest> response = null;

    @JsonProperty("status")
    private String status;
}
