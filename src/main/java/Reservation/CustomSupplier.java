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

public class CustomSupplier {

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @JsonProperty("supplier_id")
    private String supplierId;

    @JsonProperty("external_order_id")
    private String externalOrderId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("order_item_id")
    private String orderItemId;

    @JsonProperty("address_id")
    private String addressId;

}