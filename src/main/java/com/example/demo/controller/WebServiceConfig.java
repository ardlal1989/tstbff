package com.example.demo.controller;



import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap.SOAPOperationImpl;

@EnableWs
@Configuration
public class WebServiceConfig {

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(context);
    messageDispatcherServlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
  }

  @Bean(name = "AccountStatus")
  public Wsdl11Definition defaultWsdl11Definition(XsdSchema getCustomerAccountStatusSchema) throws WSDLException {
    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
   
	  /*WSDLFactory factory = WSDLFactory.newInstance();
	    Definition definition=null;
    QName inputQName = new QName("http://ws.shopdirect.com/xsd/AccountStatus", "getCustomerAccountStatusInput");
    QName outputQName = new QName("http://ws.shopdirect.com/xsd/AccountStatus", "getCustomerAccountStatusOutput");
    QName portTypeQName = new QName("http://ws.shopdirect.com/xsd/AccountStatus", "AccountStatusPT");
    Message inputMessage = definition.createMessage();
    inputMessage.setQName(inputQName);
    Input input = definition.createInput();
    input.setMessage(inputMessage);

    Message outpuMessage = definition.createMessage();
    outpuMessage.setQName(outputQName);
    Output output = definition.createOutput();
    output.setMessage(outpuMessage);

    Operation operation = definition.createOperation();
    operation.setName("getCustomerAccountStatus");
    operation.setInput(input);
    operation.setOutput(output);
    operation.setUndefined(false);
    
    PortType portType = definition.getPortType(portTypeQName);
    portType.addOperation(operation);*/
    //definition.addBinding(binding);
    SimpleWsdl11Definition wsdl=new SimpleWsdl11Definition();
    wsdl.setWsdl(new ClassPathResource("/wsdl/AccountStatus.wsdl")); //your wsdl location

    /*definition.setPortTypeName("AccountStatusPT");
    definition.setTargetNamespace("http://ws.shopdirect.com/AccountStatus");
    definition.setLocationUri("/ws");
    definition.setSchema(getCustomerAccountStatusSchema);
    definition.setServiceName("AccountStatus");
    definition.setCreateSoap11Binding(true);
    definition.setRequestSuffix("Status");
    definition.setResponseSuffix("Response");
    definition.setFaultSuffix("StatusFault");*/
 
    return wsdl;
  }
  
  @Bean
  public XsdSchema getCustomerAccountStatusSchema() {
    return new SimpleXsdSchema(new ClassPathResource("GetCustomerAccountStatus.xsd"));
  }
}
