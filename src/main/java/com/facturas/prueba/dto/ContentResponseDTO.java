package com.facturas.prueba.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContentResponseDTO {

    @JacksonXmlProperty(localName = "statusMessage")
    private String statusMessage;
    @JacksonXmlProperty(localName = "statusCode")
    private String statusCode;
    @JacksonXmlProperty(localName = "statusSeverity")
    private String statusSeverity;
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "PurchaseOrderRet")
    private List<PurchaseOrderDTO> purchaseOrderRet;
}
