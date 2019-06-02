<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Analytic</title>
    </head>
    <body>
        <h2>Analytic for ${googleId}</h2>
<%--         <c:set var = "googleAnalyticId" scope = "session" value="${provider.getGoogleAnalyticId()}"></c:set>
		<c:out value = "${googleAnalyticId}"/>
		<c:out value = "${test}"/>
 --%><!--  
		<c:set var = "googleAnalyticId" scope = "session" value="${googleAnalyticId}"></c:set>
		<c:out value = "${googleAnalyticId}"/>
		<c:set var = "googleTagManagementId" scope = "session" value="${googleTagManagementId}"></c:set>
		<c:out value = "${googleTagManagementId}"/>
-->		
<!-- 
		<c:set value="${analyticProvider.getGoogleAnalyticId()}"></c:set>
		<script type="text/javascript">
        	console.log("Value is :: " + value);
    	</script>
	 -->	    
    </body>
</html>