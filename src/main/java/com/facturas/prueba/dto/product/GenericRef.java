package com.facturas.prueba.dto.product;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenericRef {

    @JacksonXmlProperty(localName = "ListID")
    private String listID;

    @JacksonXmlProperty(localName = "FullName")
    private String fullName;
}
