package com.facturas.prueba.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VendorDTO {

    @JacksonXmlProperty(localName = "ListID")
    private String listId;
    @JacksonXmlProperty(localName = "FullName")
    private String fullName;
}
