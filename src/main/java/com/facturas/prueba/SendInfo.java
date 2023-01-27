package com.facturas.prueba;

import com.facturas.prueba.dto.GenericResponse;
import com.facturas.prueba.dto.product.QuickProductDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;
public class SendInfo {

    public void sendInfo(List<QuickProductDTO> quick){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<QuickProductDTO>> httpEntity = new HttpEntity<>(quick, headers);
        RestTemplate restTemplate = new RestTemplate();
        try{
            restTemplate.postForEntity("http://localhost:8080/api/quickProduct/saveQuickProducts",httpEntity, GenericResponse.class);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo");
        }
    }
}
