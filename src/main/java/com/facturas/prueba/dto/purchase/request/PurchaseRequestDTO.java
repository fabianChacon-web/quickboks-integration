package com.facturas.prueba.dto.purchase.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestDTO {

    private String orderReference;
    private String vendor;
    private Date creationDate;
    private List<OrderProductDTO> products;
}
