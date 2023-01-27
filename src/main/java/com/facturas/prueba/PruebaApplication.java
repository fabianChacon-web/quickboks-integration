package com.facturas.prueba;

import com.facturas.prueba.dto.PurchaseOrderDTO;
import com.facturas.prueba.dto.QuickBooksResponse;
import com.facturas.prueba.dto.product.QuickBooksResponseProduct;
import com.facturas.prueba.dto.product.QuickProductDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(PruebaApplication.class, args);
		Variant QBPermissionMode = new Variant(1);
		Variant QBaccessMode = new Variant(2);
		String fileLocation = "";  //not needed unless opening QB file which is currently not opened
		/*String XMLRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<?qbxml version=\"13.0\"?>\n" +
				"<QBXML>\n" +
				"  <QBXMLMsgsRq onError=\"stopOnError\">\n" +
				"    <PurchaseOrderQueryRq>\n" +
				"    <TxnDateRangeFilter> <!-- optional -->\n" +
				"                <FromTxnDate>2022-12-15</FromTxnDate> <!-- optional -->\n" +
				"                <ToTxnDate>2022-12-31</ToTxnDate> <!-- optional -->\n" +
				//"                <DateMacro>ENUMTYPE</DateMacro> <!-- optional -->\n" +
				"           </TxnDateRangeFilter>"+
				"           <IncludeLineItems >true</IncludeLineItems>\n" +
				"           <IncludeLinkedTxns >true</IncludeLinkedTxns>\n" +
				"    </PurchaseOrderQueryRq>\n" +
				"  </QBXMLMsgsRq>\n" +
				"</QBXML>";*/
		String XMLRequest ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<?qbxml version=\"13.0\"?>\n" +
				"<QBXML>\n" +
				"        <QBXMLMsgsRq onError=\"stopOnError\">\n" +
				"                <ItemQueryRq  >\n" +
				"                </ItemQueryRq >\n" +
				"        </QBXMLMsgsRq>\n" +
				"</QBXML>";
		String appID = "";//not needed unless you want to set AppID
		String applicationName = "QB Sync Test";
		try{
			Dispatch MySessionManager = new Dispatch("QBXMLRP2.RequestProcessor");
			Dispatch.call(MySessionManager, "OpenConnection2", appID, applicationName, QBPermissionMode);
			Variant ticket = Dispatch.call(MySessionManager, "BeginSession",fileLocation, QBaccessMode);
			Variant apiResponse = Dispatch.call(MySessionManager, "ProcessRequest", ticket, XMLRequest);
			System.out.println(apiResponse.toString());
			Dispatch.call(MySessionManager, "EndSession", ticket);
			Dispatch.call(MySessionManager, "CloseConnection");
			XmlMapper xmlMapper = new XmlMapper();
			//QuickBooksResponse listPurchase = xmlMapper.readValue(apiResponse.toString(), QuickBooksResponse.class);
			QuickBooksResponseProduct listPurchase = xmlMapper.readValue(apiResponse.toString(), QuickBooksResponseProduct.class);
			List<QuickProductDTO> quick = new ArrayList<>();
			listPurchase.getQBXMLMsgsRs().getItemQueryRs().getPurchaseOrderRet().forEach(x-> quick.add(new QuickProductDTO(x.getFullName())));
			System.out.println(listPurchase);
			SendInfo se = new SendInfo();
			se.sendInfo(quick);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
