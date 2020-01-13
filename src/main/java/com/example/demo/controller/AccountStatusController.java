package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.shopdirect.ws.xsd.accountstatus.GetCustomerAccountStatusResponse;
import com.shopdirect.ws.xsd.accountstatus.GetCustomerAccountStatus;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Endpoint
@RestController
public class AccountStatusController 
{
	@PayloadRoot(namespace = "http://ws.shopdirect.com/xsd/AccountStatus", localPart = "getCustomerAccountStatus")
	@ResponsePayload
	public GetCustomerAccountStatusResponse callAccountStatusRestService(@RequestPayload GetCustomerAccountStatus request)
	{
		ObjectMapper Obj = new ObjectMapper();
		Obj.setSerializationInclusion(Include.NON_NULL);
		/*String jsonInpForRest=null;*/  
				//converting java to json
		/*com.example.demo.entity.request.GetCustomerAccountStatus getCustomerAccountStatus=new com.example.demo.entity.request.GetCustomerAccountStatus();
		com.example.demo.entity.request.CustomerDetail customerDetail=new com.example.demo.entity.request.CustomerDetail();
		com.example.demo.entity.request.HeaderInformation headerInformation=new com.example.demo.entity.request.HeaderInformation();
		List<com.example.demo.entity.request.AccountStatusType> accountStatusTypeList=new ArrayList<com.example.demo.entity.request.AccountStatusType>();
		com.example.demo.entity.request.AccountStatusType accountStatusType=new com.example.demo.entity.request.AccountStatusType();
		headerInformation.setCallingApplicationName(request.getHeaderInformation().getCallingApplicationName());
		headerInformation.setVersionNumber(request.getHeaderInformation().getVersionNumber());
		if(!(request.getCustomerDetail().getAccountStatusType()==null))
		{
		for (int i = 0; i < request.getCustomerDetail().getAccountStatusType().getComLsdgWsAccountStatusAccountStatusObjectsAccountStatusType().size(); i++) {
			accountStatusType.setAccountStatusType(request.getCustomerDetail().getAccountStatusType().getComLsdgWsAccountStatusAccountStatusObjectsAccountStatusType().get(i).getAccountStatusType());
			accountStatusType.setAccountStatusInd(request.getCustomerDetail().getAccountStatusType().getComLsdgWsAccountStatusAccountStatusObjectsAccountStatusType().get(i).isAccountStatusInd());
			accountStatusTypeList.add(accountStatusType);
			accountStatusType=new com.example.demo.entity.request.AccountStatusType();
		}
		}
		customerDetail.setAccountNumber(request.getCustomerDetail().getAccountNumber());
		customerDetail.setChordiantId(request.getCustomerDetail().getChordiantId());
		if (accountStatusTypeList.size()>0)
		{
		customerDetail.setAccountStatusType(accountStatusTypeList);
		}
		getCustomerAccountStatus.setHeaderInformation(headerInformation);
		getCustomerAccountStatus.setCustomerDetail(customerDetail);*/
		
		/*try { 
			 		
            // get CustomerDetail object as a json string 
			jsonInpForRest = Obj.writeValueAsString(request); 
  
            // Displaying JSON String 
            System.out.println(jsonInpForRest); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } */
		
		
		//Call the Account Status RestService
		String REST_SERVICE_URI = "https://accstatuslift-shop-project.shop-direct-group-15742-f72ef11f3ab089a8c677044eb28292cd-0001.eu-de.containers.appdomain.cloud/accstatuslift/webapi/accountstatus/";
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Call Rest Service");
		
       // String jsonOutRest= restTemplate.getForObject(REST_SERVICE_URI, String.class,jsonInpForRest);
		String jsonOutRest=restTemplate.postForObject(REST_SERVICE_URI,request,String.class);
		System.out.println(jsonOutRest);
		
        //System.out.println("JSON Out"+jsonOutRest);
		
        //Convert JSON to Java and Return XML Response
        //String XMLJSONConv_URI= "http://xmljsonconv-containercrush-project4.inmbzp8022.in.dst.ibm.com/jsonToXML?jsonInp={jsonOutRest}";
        //String xmlOut=restTemplate.getForObject(XMLJSONConv_URI, String.class,jsonOutRest);
        //System.out.println("XMl Output"+xmlOut);
        //ResponseProcessing
		
		
			
        GetCustomerAccountStatusResponse gcas=null;
        try {
			gcas = Obj.readValue(jsonOutRest, GetCustomerAccountStatusResponse.class);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*ComLsdgWsAccountStatusAccountStatusObjectsGetCustomerAccountStatusResponse gc=new ComLsdgWsAccountStatusAccountStatusObjectsGetCustomerAccountStatusResponse();
        CustomerAccountStatus cs=new CustomerAccountStatus();
        CustStatusDetails custStatDet=new CustStatusDetails();
        ComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails custStat=new ComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails();
       //List<ComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails> custstatList=new ArrayList<ComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails>();
        AccountStatusRecommendations accStatRecDet=new AccountStatusRecommendations();
        ComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations accStatRec=new ComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations();
        //ok List<ComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations> accStatRecList=new ArrayList<ComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations>();
        
        if(!(gcas.getCustomerAccountStatus()==null))
        {
        if((gcas.getCustomerAccountStatus().getCustStatusDetails()!=null)&&(!(gcas.getCustomerAccountStatus().getCustStatusDetails().isEmpty())))
        {
        	
        	for (int i=0;i<gcas.getCustomerAccountStatus().getCustStatusDetails().size();i++)
        	{
        		custStat.setAccountStatusType(gcas.getCustomerAccountStatus().getCustStatusDetails().get(i).getAccountStatusType());
        		custStat.setAccountStatusDescription(gcas.getCustomerAccountStatus().getCustStatusDetails().get(i).getAccountStatusDescription());
        		custStat.setAccountStatusInd(gcas.getCustomerAccountStatus().getCustStatusDetails().get(i).isAccountStatusInd());
        		//custstatList.add(custStat);
        		custStatDet.getComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails().add(custStat);
        		custStat=new ComLsdgWsAccountStatusAccountStatusObjectsCustStatusDetails();
        		
        	}
        	
        	
        	
        	cs.setCustStatusDetails(custStatDet);
        }
        if(((gcas.getCustomerAccountStatus().getAccountStatusRecommendations()!=null))&&(!(gcas.getCustomerAccountStatus().getAccountStatusRecommendations().isEmpty())))
        {
        	System.out.println("test check");
        	for(int i=0;i<gcas.getCustomerAccountStatus().getAccountStatusRecommendations().size();i++)
        	{
        		accStatRec.setAccountStatusType(gcas.getCustomerAccountStatus().getAccountStatusRecommendations().get(i).getAccountStatusType());
        		accStatRec.setAccountStatusRecommendation(gcas.getCustomerAccountStatus().getAccountStatusRecommendations().get(i).getAccountStatusRecommendation());
        		//accStatRecList.add(accStatRec);
        		//
        		accStatRecDet.getComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations().add(accStatRec);
        		accStatRec=new ComLsdgWsAccountStatusAccountStatusObjectsAccountStatusRecommendations();
        	}
        	
        	
            cs.setAccountStatusRecommendations(accStatRecDet);
        }
        
        cs.setAccountNumber(gcas.getCustomerAccountStatus().getAccountNumber());
        gc.setCustomerAccountStatus(cs);
        }
		
		gc.setReturnCode(gcas.getReturnCode());
		gc.setReturnMessage(gcas.getReturnMessage());*/
		
	return gcas;
	}
	
	
	
}
