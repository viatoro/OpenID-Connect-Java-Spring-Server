<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="/pages/template/projectInclude.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head>
    <!-- jQuery -->
<script src="${requestScope.jsBase}/jquery.js"></script>
<script src="${requestScope.jsBase}/moment-with-locales.js"></script>
<script type="text/javascript" charset="UTF-8" src="${requestScope.jsBase}/i18next.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/underscore.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/backbone.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/purl.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/bootstrapx-clickover.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/bootstrap-sheet.js"></script>
<script type="text/javascript" src="${requestScope.jsBase}/bootpag.js"></script>

<%--     <script src="${requestScope.jsBase}/bootstrap.min.js"></script> --%>

<tiles:insertAttribute name="head" />
</head>

<body id="page-top" class="index">
<tiles:insertAttribute name="topbar" />
<tiles:insertAttribute name="header" />
    
<section id="services">
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</section>

<tiles:insertAttribute name="footer" />

<script src="${requestScope.jsBase}/bootstrap.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="${requestScope.jsBase}/retina.js"></script>

    <!-- Plugin JavaScript -->
<!--     <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> -->
    <script src="${requestScope.jsBase}/classie.js"></script>
    <script src="${requestScope.jsBase}/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
<%--     <script src="${requestScope.jsBase}/jqBootstrapValidation.js"></script> --%>
<%--     <script src="${requestScope.jsBase}/contact_me.js"></script> --%>

<!--     Custom Theme JavaScript -->
<%--     <script src="${requestScope.jsThemes}/agency.js"></script> --%>

</body>

</html>
