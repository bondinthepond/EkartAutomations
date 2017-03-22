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
public class RawStoreOutput {

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("clientServiceRequestBundleId")
    private String clientServiceRequestBundleId;

    @JsonProperty("serviceRequestBundleId")
    private String serviceRequestBundleId;

    @JsonProperty("message")
    private String message;
}
