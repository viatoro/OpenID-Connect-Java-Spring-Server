<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

       <div class="span10">
           <div class="content span12">
			<div id="breadcrumbs"></div>
			<div id="loadingbox" class="sheet hide fade" data-sheet-parent="#breadcrumbs">
				<div class="sheet-body">
		                <p><spring:message code="manage.loading"/>:</p>
		                <p><span id="loading"></span></p>
                </div>
            </div>
               <div id="content">
               	<div class="well">
                	<div><h3><spring:message code="manage.loading"/>...</h3></div>
               	    <div class="progress progress-striped active">
						<div class="bar" style="width: 100%;"></div>
					</div>
				</div>
               </div>
           </div>
       </div>



	<script type="text/javascript" src="resources/js/client.js"></script>
	<script type="text/javascript" src="resources/js/grant.js"></script>
	<script type="text/javascript" src="resources/js/scope.js"></script>
	<script type="text/javascript" src="resources/js/whitelist.js"></script>
	<script type="text/javascript" src="resources/js/dynreg.js"></script>
	<script type="text/javascript" src="resources/js/rsreg.js"></script>
	<script type="text/javascript" src="resources/js/token.js"></script>
	<script type="text/javascript" src="resources/js/blacklist.js"></script>
	<script type="text/javascript" src="resources/js/admin.js"></script>
