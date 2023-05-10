package com.example.demo.controller;

import org.apache.axis.message.SOAPHeaderElement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.SOAPElement;

/**
 * @author hwd
 * @version 1.0
 * @since 2022/1/26
 */
@RestController
public class TestController {



    @GetMapping("sendMessage/{phone}")
    public String sendMessage(String phone){
        return "部署成功";
//        try
//        {
//        	InputStream myResource = ZabbixSmsScript.class.getResourceAsStream("/my.properties");
//        	InputStream ips = ZabbixSmsScript.class.getResourceAsStream("/my.properties");
//        	Properties properties = new Properties();
//        	properties.load(ips);
//        	System.out.println(properties.getProperty("url"));


//            String url = "https://10.224.8.49:11088/ServiceOpenFrame/gate"; // 替换能开地址,如https://10.224.8.49:11088/ServiceOpenFrame/gate
//            //https://10.224.8.49:11088/ServiceOpenFrame/gate/wsdl/inspur.sms_other/1?wsdl
//            String app_key_str="4446b4dc-cf7b-4c3f-91cb-6423c7bb177b";
//            String app_secret_str="acep9zKkIWKGnOj1S2Tv";
//            String app_method_str="inspur.sms_other" ;
//            String app_version_str="1";
//            String url = properties.getProperty("url");
//            String app_key_str=properties.getProperty("app_key_str");
//            String app_secret_str=properties.getProperty("app_secret_str");
//            String app_method_str=properties.getProperty("app_method_str");
//            String app_version_str=properties.getProperty("app_version_str");

//            SOAPHeaderElement cpHeader = new SOAPHeaderElement("", "header");
//            cpHeader.setPrefix("");
//            cpHeader.setMustUnderstand(false);
//
//            // 能力使用者创建的应用的APP_KEY
//            SOAPElement ele = cpHeader.addChildElement("app_key");
//            ele.addTextNode("eb0f7f33-e326-482f-a2da-e0166d354ffe"); // app_key
//
//            // 能力使用者创建的应用的密钥
//            ele = cpHeader.addChildElement("app_secret");
//            ele.addTextNode("tYV49nPXCLIygeyXKTdX");  //app_secret
//
//            // 要调用的API的路由标签
//            ele = cpHeader.addChildElement("method");
//            ele.addTextNode("inspur.sms_other");  // method
//
//            // 要调用API的版本号
//            ele = cpHeader.addChildElement("v");
//            ele.addTextNode("1");  //版本
//
//            // 短信主体
//            StringBuffer msgStringBuffer = new StringBuffer();
//            // 短信
//            // <sms username='rms password='Rms,528><head system='system' service='service'  priority='2' seqno='12345'/><mobile>18210198436</mobile><message>测试短信发送</message></sms>
//            msgStringBuffer
//                    .append("<sms username='")
//                    .append("soc")  // 短信服务账户
//                    .append("' password='")
//                    .append("Soc.798")  // 短信服务密码
//                    .append("'>");
//            msgStringBuffer.append("<head system='system' service='service'  priority='2' seqno='12345'/>");
//            msgStringBuffer.append("<mobile>").append(phone).append("</mobile>");
//            msgStringBuffer.append("<message>").append("测试短信发送").append("</message>");
//            msgStringBuffer.append("</sms>");
//            System.out.println(msgStringBuffer.toString());
//            String[] reportParam = {msgStringBuffer.toString()};
//            String execRtnStr =
//                    (String)WebServiceAxisClient.callWebServiceHeader(
//                            "https://10.224.8.49:11088/ServiceOpenFrame/gate",
//                            "sendSMS",
//                            cpHeader,
//                            reportParam);
//            System.out.println("==============execRtnStr结果：" + execRtnStr);
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }

}
