package com.facturas.prueba.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseOrderQueryRsDTO {
    @JacksonXmlProperty(localName = "PurchaseOrderQueryRs")
    private ContentResponseDTO purchaseOrderQueryRs;
}
