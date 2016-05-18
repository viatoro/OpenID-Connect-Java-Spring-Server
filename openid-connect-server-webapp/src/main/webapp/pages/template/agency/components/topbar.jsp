<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:choose>
	<c:when test="${ not empty userInfo.preferredUsername }">
		<c:set var="shortName" value="${ userInfo.preferredUsername }" />
	</c:when>
	<c:otherwise>
		<c:set var="shortName" value="${ userInfo.sub }" />
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${ not empty userInfo.name }">
		<c:set var="longName" value="${ userInfo.name }" />
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${ not empty userInfo.givenName || not empty userInfo.familyName }">
				<c:set var="longName" value="${ userInfo.givenName } ${ userInfo.familyName }" />
			</c:when>
			<c:otherwise>
				<c:set var="longName" value="${ shortName }" />
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Jobs Matcher</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<security:authorize access="hasRole('COM000000')">
					<security:authorize access="hasRole('COM999999')">
						
						<li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="sidebar.administrative.title" /> <span class="caret"></span></a>
				          <ul class="dropdown-menu">
							<li><a href="manage/#admin/clients" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.administrative.manage_clients" /></a></li>
							<li><a href="manage/#admin/whitelists" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.administrative.whitelisted_clients" /></a></li>
							<li><a href="manage/#admin/blacklist" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.administrative.blacklisted_clients" /></a></li>
							<li><a href="manage/#admin/scope" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.administrative.system_scopes" /></a></li>
				          </ul>
						</li>
					</security:authorize>
					
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="sidebar.personal.title" /> <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="manage/#user/approved" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.personal.approved_sites" /></a></li>
						<li><a href="manage/#user/tokens" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.personal.active_tokens" /></a></li>
						<li><a href="manage/#user/profile" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.personal.profile_information" /></a></li>
			          </ul>
					</li>
					
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="sidebar.developer.title" /> <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="manage/#dev/dynreg" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.developer.client_registration" /></a></li>
			            <li><a href="manage/#dev/resource" data-toggle="collapse" data-target=".nav-collapse"><spring:message code="sidebar.developer.resource_registration" /></a></li>
			          </ul>
					</li>
					
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${ longName } <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="manage/#user/profile">${ longName }</a></li>
			            <li><a class="logoutLink"><i class="icon-remove"></i> <spring:message code="topbar.logout" /></a></li>
			          </ul>
					</li>
					
					</security:authorize>
					<security:authorize access="!hasRole('COM000000')">
						<li><a href="login" data-toggle="collapse" data-target=".nav-collapse"><i class="icon-lock"></i> <spring:message code="topbar.login" /></a></li>
					</security:authorize>
					<form action="${ config.issuer }${ config.issuer.endsWith('/') ? '' : '/' }logout" method="POST" class="hidden" id="logoutForm">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</ul>
			
		</div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

<script type="text/javascript">
	$(document).ready(function() {
		$('.logoutLink').on('click', function(e) {
			e.preventDefault();
			$('#logoutForm').submit();
		});
	});
</script>