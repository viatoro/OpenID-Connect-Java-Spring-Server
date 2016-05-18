<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    <base href="${config.issuer}">

    <meta charset="utf-8">
    <title>${config.topbarTitle} - ${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

<!--     <title>Agency - Start Bootstrap Theme</title> -->

    <!-- Bootstrap Core CSS -->
    <link href="${requestScope.cssBase}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="${requestScope.cssThemes}/theme.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
<!--     <link href="resources/themes/agency/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        $.i18n.init({
            fallbackLng: "en",
            lng: "${config.locale}",
            resGetPath: "resources/js/locale/__lng__/__ns__.json",
            ns: {
            	namespaces: ${config.languageNamespacesString},
            	defaultNs: '${config.defaultLanguageNamespace}'
            },
            fallbackNS: ${config.languageNamespacesString}
        });
        moment.locale("${config.locale}");
    	// safely set the title of the application
    	function setPageTitle(title) {
    		document.title = "${config.topbarTitle} - " + title;
    	}
    	
		// get the info of the current user, if available (null otherwise)
    	function getUserInfo() {
    		return ${userInfoJson};
    	}
		
		// get the authorities of the current user, if available (null otherwise)
		function getUserAuthorities() {
			return ${userAuthorities};
		}
		
		// is the current user an admin?
		// NOTE: this is just for  
		function isAdmin() {
			var auth = getUserAuthorities();
			if (auth && _.contains(auth, "COM999999")) {
				return true;
			} else {
				return false;
			}
		}
		
		var heartMode = ${config.heartMode};
		
    </script>    


<!-- Start body -->