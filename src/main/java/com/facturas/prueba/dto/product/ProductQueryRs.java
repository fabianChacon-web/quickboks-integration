package com.facturas.prueba.dto.product;

import com.facturas.prueba.dto.ContentResponseDTO;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductQueryRs {

    @JacksonXmlProperty(localName = "ItemQueryRs")
    private ContentProductResponseDTO itemQueryRs;
}
