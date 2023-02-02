package com.facturas.prueba.dto.purchase.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {

    private String reference;
    private Long quantity;
}
