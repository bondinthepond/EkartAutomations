package Reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.util.Date;

/**
 * Created by aditya.mullela on 13/02/17.
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReservationPayload {

        @JsonProperty("fulfill_reference_id")
        private String fulfillReferenceId;

        @JsonProperty("customer_id")
        private String customerId;

        @JsonProperty("address_id")
        private String addressId;

        @JsonProperty("compliance_forms_required")
        private Boolean complianceFormsRequired;

        @JsonProperty("fsn")
        private String fsn;

        @JsonProperty("sku")
        private String sku;

        @JsonProperty("promised_after_date")
        private Date promisedAfterDate;

        @JsonProperty("promised_date")
        private Date promisedDate;

        @JsonProperty("ekl.ekl_databag")
        private JsonNode eklEklDatabag;

        @JsonProperty("ship_together_preference_id")
        private String shipTogetherPreferenceId;

        @JsonProperty("sales_channel")
        private String salesChannel;

        @JsonProperty("hold")
        private Boolean hold;

        @JsonProperty("breach_cost")
        private Integer breachCost;

        @JsonProperty("gift_message")
        private String giftMessage;

        @JsonProperty("gift_wrap")
        private Boolean giftWrap;

        @JsonProperty("seller_id")
        private String sellerId;

        @JsonProperty("action")
        private String action;

        @JsonProperty("is_replacement")
        private Boolean isReplacement;

        @JsonProperty("deliver_after_capability")
        private Boolean deliverAfterCapability;

        @JsonProperty("deliver_after_date")
        private Date deliverAfterDate;

        @JsonProperty("warehouse_id")
        private String warehouseId;

        @JsonProperty("freebie")
        private Freebie freebie;

        @JsonProperty("order_item_id")
        private String orderItemId;

        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("supplier")
        private CustomSupplier customSupplier;

        @JsonProperty("size")
        private String size;

        @JsonProperty("logistics_type")
        private String logisticsType;

        @JsonProperty("lpht")
        private Date lpht;

        @JsonProperty("vendor_id")
        private String vendorId;

        @JsonProperty("handover_ready_after_time")
        private Date handoverReadyAfterTime;

        @JsonProperty("handover_ready_by_time")
        private Date handoverReadyByTime;

        public String getFulfillReferenceId() {
                return fulfillReferenceId;
        }

        public void setFulfillReferenceId(String fulfillReferenceId) {
                this.fulfillReferenceId = fulfillReferenceId;
        }

        public String getCustomerId() {
                return customerId;
        }

        public void setCustomerId(String customerId) {
                this.customerId = customerId;
        }

        public String getAddressId() {
                return addressId;
        }

        public void setAddressId(String addressId) {
                this.addressId = addressId;
        }

        public Boolean getComplianceFormsRequired() {
                return complianceFormsRequired;
        }

        public void setComplianceFormsRequired(Boolean complianceFormsRequired) {
                this.complianceFormsRequired = complianceFormsRequired;
        }

        public String getFsn() {
                return fsn;
        }

        public void setFsn(String fsn) {
                this.fsn = fsn;
        }

        public String getSku() {
                return sku;
        }

        public void setSku(String sku) {
                this.sku = sku;
        }

        public Date getPromisedAfterDate() {
                return promisedAfterDate;
        }

        public void setPromisedAfterDate(Date promisedAfterDate) {
                this.promisedAfterDate = promisedAfterDate;
        }

        public Date getPromisedDate() {
                return promisedDate;
        }

        public void setPromisedDate(Date promisedDate) {
                this.promisedDate = promisedDate;
        }

        public JsonNode getEklEklDatabag() {
                return eklEklDatabag;
        }

        public void setEklEklDatabag(JsonNode eklEklDatabag) {
                this.eklEklDatabag = eklEklDatabag;
        }

        public String getShipTogetherPreferenceId() {
                return shipTogetherPreferenceId;
        }

        public void setShipTogetherPreferenceId(String shipTogetherPreferenceId) {
                this.shipTogetherPreferenceId = shipTogetherPreferenceId;
        }

        public String getSalesChannel() {
                return salesChannel;
        }

        public void setSalesChannel(String salesChannel) {
                this.salesChannel = salesChannel;
        }

        public Boolean getHold() {
                return hold;
        }

        public void setHold(Boolean hold) {
                this.hold = hold;
        }

        public Integer getBreachCost() {
                return breachCost;
        }

        public void setBreachCost(Integer breachCost) {
                this.breachCost = breachCost;
        }

        public String getGiftMessage() {
                return giftMessage;
        }

        public void setGiftMessage(String giftMessage) {
                this.giftMessage = giftMessage;
        }

        public Boolean getGiftWrap() {
                return giftWrap;
        }

        public void setGiftWrap(Boolean giftWrap) {
                this.giftWrap = giftWrap;
        }

        public String getSellerId() {
                return sellerId;
        }

        public void setSellerId(String sellerId) {
                this.sellerId = sellerId;
        }

        public String getAction() {
                return action;
        }

        public void setAction(String action) {
                this.action = action;
        }

        public Boolean getReplacement() {
                return isReplacement;
        }

        public void setReplacement(Boolean replacement) {
                isReplacement = replacement;
        }

        public Boolean getDeliverAfterCapability() {
                return deliverAfterCapability;
        }

        public void setDeliverAfterCapability(Boolean deliverAfterCapability) {
                this.deliverAfterCapability = deliverAfterCapability;
        }

        public Date getDeliverAfterDate() {
                return deliverAfterDate;
        }

        public void setDeliverAfterDate(Date deliverAfterDate) {
                this.deliverAfterDate = deliverAfterDate;
        }

        public String getWarehouseId() {
                return warehouseId;
        }

        public void setWarehouseId(String warehouseId) {
                this.warehouseId = warehouseId;
        }

        public Freebie getFreebie() {
                return freebie;
        }

        public void setFreebie(Freebie freebie) {
                this.freebie = freebie;
        }

        public String getOrderItemId() {
                return orderItemId;
        }

        public void setOrderItemId(String orderItemId) {
                this.orderItemId = orderItemId;
        }

        public String getOrderId() {
                return orderId;
        }

        public void setOrderId(String orderId) {
                this.orderId = orderId;
        }

        public CustomSupplier getCustomSupplier() {
                return customSupplier;
        }

        public void setCustomSupplier(CustomSupplier customSupplier) {
                this.customSupplier = customSupplier;
        }

        public String getSize() {
                return size;
        }

        public void setSize(String size) {
                this.size = size;
        }

        public String getLogisticsType() {
                return logisticsType;
        }

        public void setLogisticsType(String logisticsType) {
                this.logisticsType = logisticsType;
        }

        public Date getLpht() {
                return lpht;
        }

        public void setLpht(Date lpht) {
                this.lpht = lpht;
        }

        public String getVendorId() {
                return vendorId;
        }

        public void setVendorId(String vendorId) {
                this.vendorId = vendorId;
        }

        public Date getHandoverReadyAfterTime() {
                return handoverReadyAfterTime;
        }

        public void setHandoverReadyAfterTime(Date handoverReadyAfterTime) {
                this.handoverReadyAfterTime = handoverReadyAfterTime;
        }

        public Date getHandoverReadyByTime() {
                return handoverReadyByTime;
        }

        public void setHandoverReadyByTime(Date handoverReadyByTime) {
                this.handoverReadyByTime = handoverReadyByTime;
        }

        public Boolean getHandInHand() {
                return handInHand;
        }

        public void setHandInHand(Boolean handInHand) {
                this.handInHand = handInHand;
        }

        @JsonProperty("hand_in_hand")
        private Boolean handInHand;

}

