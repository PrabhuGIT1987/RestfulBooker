package restfullbookerTestCases;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayLoads {


	public Root getBookingIDRequestPayload() {
		
		
		Root payload=new Root();
		
		payload.setFirstname("TestFN5");
		payload.setLastname("TestLN5");
		payload.setTotalprice(1005);
		payload.setDepositpaid(true);
		payload.setAdditionalneeds("BreakFasNewt");
		
		BookingDates bookingdates=new BookingDates();
		bookingdates.setCheckin("2024-06-26");
		bookingdates.setCheckout("2024-07-01");
		
		payload.setBookingdates(bookingdates);
		
		ObjectMapper objMap=new ObjectMapper();
		
		try {
			String createBookingIDPayload=objMap.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
			
			System.out.println(createBookingIDPayload);
			

			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return payload;
	}
	
	
	
	
}
