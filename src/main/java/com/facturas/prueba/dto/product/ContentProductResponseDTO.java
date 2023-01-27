package com.facturas.prueba.dto.product;

import com.facturas.prueba.dto.PurchaseOrderDTO;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContentProductResponseDTO {

    @JacksonXmlProperty(localName = "statusMessage")
    private String statusMessage;
    @JacksonXmlProperty(localName = "statusCode")
    private String statusCode;
    @JacksonXmlProperty(localName = "statusSeverity")
    private String statusSeverity;
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ItemNonInventoryRet")
    private List<ProductInventoryDTO> purchaseOrderRet;
}
