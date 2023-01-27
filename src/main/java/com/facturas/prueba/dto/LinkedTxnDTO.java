package com.facturas.prueba.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinkedTxnDTO {

    @JacksonXmlProperty(localName = "TxnID")
    private String txnID;
    @JacksonXmlProperty(localName = "TxnType")
    private String txnType;
    @JacksonXmlProperty(localName = "TxnDate")
    private Date txnDate;
    @JacksonXmlProperty(localName = "RefNumber")
    private String refNumber;
    @JacksonXmlProperty(localName = "LinkType")
    private String linkType;
    @JacksonXmlProperty(localName = "Amount")
    private Double amount;

}
