package com.facturas.prueba.dto.product;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesOrPurchase {
    @JacksonXmlProperty(localName = "Desc")
    private String desc;
    @JacksonXmlProperty(localName = "Price")
    private String price;
    @JacksonXmlProperty(localName = "AccountRef")
    private GenericRef accountRef;

}
