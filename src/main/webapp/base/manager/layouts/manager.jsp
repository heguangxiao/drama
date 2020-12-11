<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><tiles:getAsString name="title" /></title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/bootstrap-responsive.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/jquery.gritter.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/colorpicker.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/datepicker.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/uniform.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/select2.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/fullcalendar.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/maruti-style.css' />" />
        <link rel="stylesheet" href="<c:url value='/css/maruti-media.css' />" class="skin-color" />
    </head>

    <body>
        <tiles:insertAttribute name="header" />  
        
        <tiles:insertAttribute name="menu" />   
        
        <tiles:insertAttribute name="body" />  
        
        <tiles:insertAttribute name="footer" />     
    </body>
</html>