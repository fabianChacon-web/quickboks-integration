package com.facturas.prueba.dto.purchase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrderLineRetDTO {
    @JacksonXmlProperty(localName = "TxnLineID")
    private String txnLineID;
    @JacksonXmlProperty(localName = "ItemRef")
    private VendorDTO itemRef;
    @JacksonXmlProperty(localName = "ManufacturerPartNumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String manufacturerPartNumber;
    @JacksonXmlProperty(localName = "Desc")
    private String desc;
    @JacksonXmlProperty(localName = "Quantity")
    private Long quantity;
    @JacksonXmlProperty(localName = "Rate")
    private String rate;
    @JacksonXmlProperty(localName = "Amount")
    private String amount;
    @JacksonXmlProperty(localName = "CustomerRef")
    private VendorDTO customerRef;
    @JacksonXmlProperty(localName = "ReceivedQuantity")
    private Integer receivedQuantity;
    @JacksonXmlProperty(localName = "IsBilled")
    private Boolean isBilled;
    @JacksonXmlProperty(localName = "IsManuallyClosed")
    private Boolean isManuallyClosed;
}
