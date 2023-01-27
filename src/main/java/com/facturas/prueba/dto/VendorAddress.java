package com.facturas.prueba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VendorAddress {
    @JacksonXmlProperty(isAttribute = true, localName = "Addr1")
    private String addr1;
    @JacksonXmlProperty(isAttribute = true, localName = "Addr2")
    private String addr2;
    @JacksonXmlProperty(isAttribute = true, localName = "Addr3")
    private String addr3;
    @JacksonXmlProperty(isAttribute = true, localName = "Addr4")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String addr4;
    @JacksonXmlProperty(isAttribute = true, localName = "Addr5")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String addr5;
    @JacksonXmlProperty(isAttribute = true, localName = "City")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;
    @JacksonXmlProperty(isAttribute = true, localName = "PostalCode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String postalCode;
    @JacksonXmlProperty(isAttribute = true, localName = "State")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String state;
    @JacksonXmlProperty(isAttribute = true, localName = "Note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;
    @JacksonXmlProperty(isAttribute = true, localName = "Country")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;
}
