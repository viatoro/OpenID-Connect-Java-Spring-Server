<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<security:authorize access="hasRole('COM000000')">
	<div class="span2 visible-desktop">
	    <div class="well sidebar-nav">
	        <ul class="nav nav-list">
	        	<jsp:include page="/pages/template/std/components/actionmenu.jsp"/>
	        </ul>
	    </div><!--/.well -->
	</div><!--/span-->
</security:authorize>
<security:authorize access="!hasRole('COM000000')">
	<div class="span1">
		<!-- placeholder for non-logged-in users -->
	</div><!--/span-->
</security:authorize>
