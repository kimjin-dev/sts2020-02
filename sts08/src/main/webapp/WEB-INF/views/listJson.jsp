<%
	Map map=new HashMap();
	map.put("root", request.getAttribute("list"));
	//java -> json변환 toString
	//com.google.gson.Gson gson = new com.google.gson.Gson();
	//out.print(gson.toJson(map));
%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>