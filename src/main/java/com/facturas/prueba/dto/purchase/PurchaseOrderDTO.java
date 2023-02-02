package com.facturas.prueba.dto.purchase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseOrderDTO {

    @JacksonXmlProperty(localName = "TxnID")
    private String txnID;
    @JacksonXmlProperty(localName = "TimeCreated")
    private Date timeCreated;
    @JacksonXmlProperty(localName = "TimeModified")
    private Date timeModified;
    @JacksonXmlProperty(localName = "EditSequence")
    private Long editSequence;
    @JacksonXmlProperty(localName = "TxnNumber")
    private Integer txnNumber;
    @JacksonXmlProperty(localName = "VendorRef")
    private VendorDTO vendorRef;
    @JacksonXmlProperty(localName = "ShipToEntityRef")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VendorDTO shipToEntityRef;
    @JacksonXmlProperty(localName = "TemplateRef")
    private VendorDTO templateRef;
    @JacksonXmlProperty(localName = "TxnDate")
    private Date txnDate;
    @JacksonXmlProperty(localName = "RefNumber")
    private String refNumber;
    @JacksonXmlProperty(localName = "VendorAddress")
    private VendorAddress vendorAddress;
    @JacksonXmlProperty(localName = "VendorAddressBlock")
    private VendorAddress vendorAddressBlock;
    @JacksonXmlProperty(localName = "ShipAddress")
    private VendorAddress shipAddress;
    @JacksonXmlProperty(localName = "ShipAddressBlock")
    private VendorAddress shipAddressBlock;
    @JacksonXmlProperty(localName = "TermsRef")
    private VendorDTO termsRef;
    @JacksonXmlProperty(localName = "DueDate")
    private Date dueDate;
    @JacksonXmlProperty(localName = "ExpectedDate")
    private Date ExpectedDate;
    @JacksonXmlProperty(isAttribute = true, localName = "ShipMethodRef")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String shipMethodRef;
    @JacksonXmlProperty(localName = "FOB")
    private String fOB;
    @JacksonXmlProperty(localName = "TotalAmount")
    private String totalAmount;
    @JacksonXmlProperty(localName = "IsManuallyClosed")
    private Boolean isManuallyClosed;
    @JacksonXmlProperty(localName = "IsFullyReceived")
    private Boolean isFullyReceived;
    @JacksonXmlProperty(isAttribute = true, localName = "Memo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memo;
    @JacksonXmlProperty(localName = "VendorMsg")
    private String vendorMsg;
    @JacksonXmlProperty(localName = "IsToBePrinted")
    private Boolean isToBePrinted;
    @JacksonXmlProperty(localName = "IsToBeEmailed")
    private Boolean isToBeEmailed;
    @JacksonXmlProperty(localName = "LinkedTxn")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LinkedTxnDTO linkedTxn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String other1;
    @JacksonXmlProperty(localName = "Other2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String other2;

    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "PurchaseOrderLineRet")
    private List<PurchaseOrderLineRetDTO> purchaseOrderLineRetDTO;


}
