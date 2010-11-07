<%-- 
    Document   : index
    Created on : 22 oct. 2010, 12:55:19
    Author     : baillif
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="main.TP2Main"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String c = new TP2Main().go(sdf.parse("1900-01-01"));

        %>

        <%=c%>
    </body>
</html>
