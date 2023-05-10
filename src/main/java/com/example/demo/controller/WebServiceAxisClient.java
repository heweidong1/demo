package com.example.demo.controller;

import java.net.SocketTimeoutException;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebServiceAxisClient
{
    private static Log logger = LogFactory.getLog(WebServiceAxisClient.class);
    
    /**
     * 调用Webservice接口通用客户端方法
     * 
     * @param url：Web服务所在的URL
     * @param function：Web服务提供的接口
     * @param obj：Web服务接口入参
     * @return
     * @throws BmoException
     * @throws SocketTimeoutException
     */
    public static Object callWebService(String url, String function, Object[] obj)
        throws Exception
    {
        try
        {
            logger.debug("开始调用Web Service");
            // 创建Service对象，Service对用用于创建Call对象
            Service service = new Service();
            // 创建Call对象，Call对象用于调用服务
            Call call = (Call)service.createCall();
            // 为Call对象设置WebService的url
            call.setTargetEndpointAddress(new java.net.URL(url));
            // 为Call对象设置调用的方法名
            call.setOperationName(function);
            // 调用WebService的方法，并获得返回值
            // call.setTimeout()
            Object result = (Object)call.invoke(obj);
            logger.debug("调用Web Service正常结束");
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 调用Webservice接口通用客户端方法
     * 
     * @param url：Web服务所在的URL
     * @param function：Web服务提供的接口
     * @param obj：Web服务接口入参
     * @return
     * @throws BmoException
     * @throws SocketTimeoutException
     */
    public static Object callWebServiceHeader(String url, String function, SOAPHeaderElement header, Object[] obj)
        throws Exception
    {
        try
        {
            logger.debug("开始调用Web Service");
            // 创建Service对象，Service对用用于创建Call对象
            Service service = new Service();
            // 创建Call对象，Call对象用于调用服务
            Call call = (Call)service.createCall();
            // 为Call对象设置WebService的url
            call.setTargetEndpointAddress(new java.net.URL(url));
            // 为Call对象设置调用的方法名
            call.setOperationName(function);
            
            if(null != header)
            {
                call.addHeader(header);
            }
            // 调用WebService的方法，并获得返回值
            // call.setTimeout()
            Object result = (Object)call.invoke(obj);
            logger.debug("调用Web Service正常结束");
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    public static Object callWebServiceByNameSpace_header(String url, String function, String nameSpace,
        List parameters, Object[] obj, int timeOut, SOAPHeaderElement header)
        throws Exception
    {
        try
        {
            logger.debug("开始调用callWebServiceByNameSpace");
            // 创建Service对象，Service对用用于创建Call对象
            Service service = new Service();
            // 创建Call对象，Call对象用于调用服务
            Call call = (Call)service.createCall();
            
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName(nameSpace, function));
            call.addHeader(header);
            // 循环增加参数
            if (parameters != null && parameters.size() > 0)
            {
                for (int i = 0; i < parameters.size(); i++)
                {
                    call.addParameter(
                        parameters.get(i).toString(),
                        org.apache.axis.Constants.XSD_STRING,
                        javax.xml.rpc.ParameterMode.IN);
                }
            }
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
            // 信用度查询设置1秒超时
            call.setTimeout(new Integer(timeOut));
            Object res = call.invoke(obj);
            logger.debug("调用callWebServiceByNameSpace正常结束");
            return res;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 调用Webservice接口通用客户端方法
     * 
     * @param url：Web服务所在的URL
     * @param function：Web服务提供的接口
     * @param obj：Web服务接口入参
     * @return
     * @throws BmoException
     * @throws SocketTimeoutException
     */
    public static Object callWebService(String url, String function, int waitTimes, int retryCount, Object[] obj)
        throws Exception
    {
        try
        {
            logger.debug("开始调用Web Service");
            // 创建Service对象，Service对用用于创建Call对象
            Service service = new Service();
            // 创建Call对象，Call对象用于调用服务
            Call call = (Call)service.createCall();
            // 为Call对象设置WebService的url
            call.setTargetEndpointAddress(new java.net.URL(url));
            // 为Call对象设置调用的方法名
            call.setOperationName(function);
            // 设置超时时间
            call.setTimeout(waitTimes * 1000);
            // 设置重连次数
            // 调用WebService的方法，并获得返回值
            // call.setTimeout()
            Object result = (Object)call.invoke(obj);
            logger.debug("调用Web Service正常结束");
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * @Description: 通过指定命名空间的方式调用web服务
     * @param url：服务地址
     * @param function：方法名称
     * @param nameSpace：命名空间
     * @param parameters：参数对应键
     * @param obj：参数值
     * @return res
     * @throws BmoException
     * @throws SocketTimeoutException:
     * @return Object
     * @throws
     * @date 2016-3-21
     */
    public static Object callWebServiceByNameSpace(String url, String function, String nameSpace, List parameters,
        Object[] obj, int timeOut)
        throws Exception
    {
        try
        {
            logger.debug("开始调用callWebServiceByNameSpace");
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName(nameSpace, function));
            // 循环增加参数
            if (parameters != null && parameters.size() > 0)
            {
                for (int i = 0; i < parameters.size(); i++)
                {
                    call.addParameter(
                        parameters.get(i).toString(),
                        org.apache.axis.Constants.XSD_STRING,
                        javax.xml.rpc.ParameterMode.IN);
                }
            }
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
            // 信用度查询设置1秒超时
            call.setTimeout(new Integer(timeOut));
            Object res = call.invoke(obj);
            logger.debug("调用callWebServiceByNameSpace正常结束");
            return res;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * @Description: 通过指定命名空间的方式调用web服务
     * @param url：服务地址
     * @param function：方法名称
     * @param nameSpace：命名空间
     * @param parameters：参数对应键
     * @param obj：参数值
     * @param paramName：参数名称
     * @return res
     * @throws BmoException
     * @throws SocketTimeoutException:
     * @return Object
     * @throws
     * @date 2016-9-21
     */
    public static Object callWebServiceByNameSpace(String url, String function, String nameSpace, List parameters,
        Object[] obj, int timeOut, String paramName)
        throws Exception
    {
        try
        {
            logger.debug("开始调用callWebServiceByNameSpace");
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName(nameSpace, function));
            // 循环增加参数
            if (parameters != null && parameters.size() > 0)
            {
                for (int i = 0; i < parameters.size(); i++)
                {
                    QName Qname = new QName(paramName, parameters.get(i).toString());
                    call.addParameter(Qname, org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
                }
            }
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
            // 信用度查询设置1秒超时
            call.setTimeout(new Integer(timeOut));
            Object res = call.invoke(obj);
            logger.debug("调用callWebServiceByNameSpace正常结束");
            return res;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
}