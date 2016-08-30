<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import ="redbus.model.pojo.Bus"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus List</title>
</head>
<body>
<%
List<Bus> ls = (List)session.getAttribute("searchBusList");
Iterator<Bus> itr = ls.iterator();
while(itr.hasNext()){
	out.println(itr.next());	
}
%>
</body>
</html>