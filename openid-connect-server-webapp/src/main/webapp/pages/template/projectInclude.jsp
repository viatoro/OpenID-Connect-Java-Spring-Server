<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%!
	String appBase    	= null;
	String imageBase  	= null;
	String jsBase 	= null;
	String cssBase  	= null;
	
	String agiImageBase = null;
	String agiJSBase = null;
	String agiCssBase = null;
	String themesBase = null;
%><%
	appBase    	= request.getContextPath();
	if(appBase.equals("/")){
		appBase = "";
	}
// 	themesBase = "Metronic";
	themesBase = "agency";
	request.setAttribute("themesBase", themesBase );
	request.setAttribute("appBase", appBase );
	request.setAttribute("resourceBase", appBase + "/resources" );
	request.setAttribute("imageBase", appBase + "/resources/common/images");
	request.setAttribute("jsBase", appBase + "/resources/common/js");
	request.setAttribute("cssBase", appBase + "/resources/common/css");
	request.setAttribute("iconBase", appBase + "/resources/common/icon");
	
	request.setAttribute("imageThemes", appBase + "/resources/themes/"+themesBase+"/images");
	request.setAttribute("jsThemes", appBase + "/resources/themes/"+themesBase+"/js");
	request.setAttribute("cssThemes", appBase + "/resources/themes/"+themesBase+"/css");
	request.setAttribute("iconThemes", appBase + "/resources/themes/"+themesBase+"/icon");
%>
