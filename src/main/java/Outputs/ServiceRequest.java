package Outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by aditya.mullela on 16/02/17.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ServiceRequest {

    public Long getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Long serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getClientServiceRequestId() {
        return clientServiceRequestId;
    }

    public void setClientServiceRequestId(String clientServiceRequestId) {
        this.clientServiceRequestId = clientServiceRequestId;
    }

    @JsonProperty("serviceRequestId")
    private Long serviceRequestId;
    @JsonProperty("clientServiceRequestId")
    private String clientServiceRequestId;

}
