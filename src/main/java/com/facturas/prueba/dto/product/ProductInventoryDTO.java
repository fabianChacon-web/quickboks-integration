package com.facturas.prueba.dto.product;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductInventoryDTO {

    @JacksonXmlProperty(localName = "ListID")
    private String listId;
    @JacksonXmlProperty(localName = "TimeCreated")
    private Date timeCreated;
    @JacksonXmlProperty(localName = "TimeModified")
    private Date timeModified;
    @JacksonXmlProperty(localName = "EditSequence")
    private String editSequence;
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "FullName")
    private String fullName;
    @JacksonXmlProperty(localName = "IsActive")
    private Boolean isActive;
    @JacksonXmlProperty(localName = "Sublevel")
    private String subLevel;
    @JacksonXmlProperty(localName = "ManufacturerPartNumber")
    private String manufacturerPartNumber;
    @JacksonXmlProperty(localName = "ParentRef")
    private GenericRef parentRef;
    @JacksonXmlProperty(localName = "SalesTaxCodeRef")
    private GenericRef salesTaxCodeRef;
    @JacksonXmlProperty(localName = "SalesOrPurchase")
    private SalesOrPurchase salesOrPurchase;
}
