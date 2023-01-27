package com.facturas.prueba.dto.product;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuickBooksResponseProduct {
    @JacksonXmlProperty(localName = "QBXMLMsgsRs")
    private ProductQueryRs qBXMLMsgsRs;
}
