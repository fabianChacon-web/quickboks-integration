package com.facturas.prueba;

import com.facturas.prueba.dto.purchase.QuickBooksResponse;
import com.facturas.prueba.dto.product.QuickBooksResponseProduct;
import com.facturas.prueba.dto.product.QuickProductDTO;
import com.facturas.prueba.dto.purchase.request.OrderProductDTO;
import com.facturas.prueba.dto.purchase.request.PurchaseRequestDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(PruebaApplication.class, args);
		Variant QBPermissionMode = new Variant(1);
		Variant QBaccessMode = new Variant(2);
		String fileLocation = "";  //not needed unless opening QB file which is currently not opened
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)- 1);
		Date prevDate = calendar.getTime();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		String XMLRequest ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<?qbxml version=\"13.0\"?>\n" +
				"<QBXML>\n" +
				"        <QBXMLMsgsRq onError=\"stopOnError\">\n" +
				"                <ItemQueryRq  >\n" +
				"						<FromModifiedDate>"+dateFormat.format(prevDate)+"</FromModifiedDate> <!-- optional -->"+
				"						<ToModifiedDate>"+dateFormat.format(date)+"</ToModifiedDate>"+
				"                </ItemQueryRq >\n" +
				"        </QBXMLMsgsRq>\n" +
				"</QBXML>";
		String XMLRequestPur = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<?qbxml version=\"13.0\"?>\n" +
				"<QBXML>\n" +
				"  <QBXMLMsgsRq onError=\"stopOnError\">\n" +
				"    <PurchaseOrderQueryRq>\n" +
				"    <TxnDateRangeFilter> <!-- optional -->\n" +
				"                <FromTxnDate>"+dateFormat.format(prevDate)+"</FromTxnDate> <!-- optional -->\n" +
				"                <ToTxnDate>"+dateFormat.format(date)+"</ToTxnDate> <!-- optional -->\n" +
				"           </TxnDateRangeFilter>"+
				"           <IncludeLineItems >true</IncludeLineItems>\n" +
				"           <IncludeLinkedTxns >true</IncludeLinkedTxns>\n" +
				"    </PurchaseOrderQueryRq>\n" +
				"  </QBXMLMsgsRq>\n" +
				"</QBXML>";
		String appID = "";//not needed unless you want to set AppID
		String applicationName = "QB Sync Test";
		try{
			Dispatch MySessionManager = new Dispatch("QBXMLRP2.RequestProcessor");
			Dispatch.call(MySessionManager, "OpenConnection2", appID, applicationName, QBPermissionMode);
			Variant ticket = Dispatch.call(MySessionManager, "BeginSession",fileLocation, QBaccessMode);
			Variant apiResponse = Dispatch.call(MySessionManager, "ProcessRequest", ticket, XMLRequestPur);
			Variant apiResponseProd = Dispatch.call(MySessionManager, "ProcessRequest", ticket, XMLRequest);
			Dispatch.call(MySessionManager, "EndSession", ticket);
			Dispatch.call(MySessionManager, "CloseConnection");
			XmlMapper xmlMapper = new XmlMapper();
			QuickBooksResponse listPurchase = xmlMapper.readValue(apiResponse.toString(), QuickBooksResponse.class);
			QuickBooksResponseProduct listProd = xmlMapper.readValue(apiResponseProd.toString(), QuickBooksResponseProduct.class);
			List<QuickProductDTO> quick = new ArrayList<>();
			if(listProd.getQBXMLMsgsRs().getItemQueryRs().getPurchaseOrderRet()!=null){
				listProd.getQBXMLMsgsRs().getItemQueryRs().getPurchaseOrderRet().forEach(x-> quick.add(new QuickProductDTO(x.getFullName())));
				System.out.println(listProd);
				SendInfo se = new SendInfo();
				se.sendInfoProduct(quick);
			}
			List<PurchaseRequestDTO> purchasesRequest = new ArrayList<>();
			if(listPurchase.getQBXMLMsgsRs().getPurchaseOrderQueryRs().getPurchaseOrderRet()!=null){
				listPurchase.getQBXMLMsgsRs().getPurchaseOrderQueryRs().getPurchaseOrderRet().forEach(x->{
					List<OrderProductDTO> products = new ArrayList<>();
					try{
						x.getPurchaseOrderLineRetDTO().forEach(y-> products.add(new OrderProductDTO(y.getItemRef().getFullName(),y.getQuantity())));
						purchasesRequest.add(new PurchaseRequestDTO(x.getTxnID(),x.getVendorRef().getFullName(),x.getTimeCreated(),products));
					}catch (Exception e){
						System.out.println("Error con orden de compra: "+x.getTxnID());
					}
				});
				System.out.println(listProd);
				SendInfo se = new SendInfo();
				se.sendInfoPurchases(purchasesRequest);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
