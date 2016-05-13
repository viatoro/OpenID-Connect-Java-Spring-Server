<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head>
<tiles:insertAttribute name="header" />
</head>
<body>

<div id="wrap">
<tiles:insertAttribute name="topbar" />
	<div class="container-fluid main">
		<div class="row-fluid">
			<tiles:insertAttribute name="sidebar" />
			<div class="span10">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<div id="push"></div>
</div>
<tiles:insertAttribute name="footer" />

</body>
