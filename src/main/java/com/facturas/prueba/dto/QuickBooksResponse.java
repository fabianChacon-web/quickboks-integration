package com.facturas.prueba.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuickBooksResponse {
    @JacksonXmlProperty(localName = "QBXMLMsgsRs")
    private PurchaseOrderQueryRsDTO qBXMLMsgsRs;
}