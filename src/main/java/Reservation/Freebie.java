package Reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by aditya.mullela on 13/02/17.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Freebie {

    public String getFlipkart() {
        return flipkart;
    }

    public void setFlipkart(String flipkart) {
        this.flipkart = flipkart;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("flipkart")
    private String flipkart;

    @JsonProperty("supplier")
    private String supplier;

}
