<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Provider</title>
    </head>
    <body>
        <h2>Provider called</h2>
		<c:set var = "analyticProvider" scope = "session" value="${analyticProvider}"></c:set>
		<c:out value = "${analyticProvider}"/>
		<br>
		<c:set var = "googleAnalyticId" scope = "session" value="${googleAnalyticId}"></c:set>
		<c:out value = "${googleAnalyticId}"/>
		<br>
		<c:set var = "googleTagManagementId" scope = "session" value="${googleTagManagementId}"></c:set>
		<c:out value = "${googleTagManagementId}"/>
		<br>
		<c:set var = "pardotTrackingActiveId" scope = "session" value="${pardotTrackingActiveId}"></c:set>
		<c:out value = "${pardotTrackingActiveId}"/>
		<br>
		<c:set var = "pardotTrackingCodeId" scope = "session" value="${pardotTrackingCodeId}"></c:set>
		<c:out value = "${pardotTrackingCodeId}"/>
    </body>
</html>