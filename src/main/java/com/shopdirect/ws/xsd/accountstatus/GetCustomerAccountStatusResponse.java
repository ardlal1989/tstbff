//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.09 at 04:14:08 PM IST 
//


package com.shopdirect.ws.xsd.accountstatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReturnMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerAccountStatus" type="{http://ws.shopdirect.com/xsd/AccountStatus}CustomerAccountStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnCode",
    "returnMessage",
    "customerAccountStatus"
})
@XmlRootElement(name = "getCustomerAccountStatusResponse")
public class GetCustomerAccountStatusResponse {

    @XmlElement(name = "ReturnCode")
    protected int returnCode;
    @XmlElement(name = "ReturnMessage")
    protected String returnMessage;
    @XmlElement(name = "CustomerAccountStatus")
    protected CustomerAccountStatus customerAccountStatus;

    /**
     * Gets the value of the returnCode property.
     * 
     */
    @JsonProperty("ReturnCode")
    public int getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     */
    public void setReturnCode(int value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the returnMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @JsonProperty("ReturnMessage")
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * Sets the value of the returnMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnMessage(String value) {
        this.returnMessage = value;
    }

    /**
     * Gets the value of the customerAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountStatus }
     *     
     */
    @JsonProperty("CustomerAccountStatus")
    public CustomerAccountStatus getCustomerAccountStatus() {
        return customerAccountStatus;
    }

    /**
     * Sets the value of the customerAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountStatus }
     *     
     */
    public void setCustomerAccountStatus(CustomerAccountStatus value) {
        this.customerAccountStatus = value;
    }

}