<?xml version="1.0" encoding="iso-8859-1" ?>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"><head>
        
        <!-- Title -->
        <title><decorator:title default="QTS-Live"/></title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="description" content="Admin Dashboard Template">
        <meta name="keywords" content="admin,dashboard">
        <meta name="author" content="LambdaThemes">
        
        <!-- Styles -->
		<!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css"> -->
		<link href="assets/css/font-google-open-sans-400-300-600.css" rel="stylesheet" type="text/css">        
        <link href="assets/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet">
        <link href="assets/plugins/uniform/css/uniform.default.min.css" rel="stylesheet">
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css">	
        <link href="assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css" rel="stylesheet" type="text/css">	
        <link href="assets/plugins/waves/waves.min.css" rel="stylesheet" type="text/css">	
        <link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css">
        <link href="assets/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css">	
        <link href="assets/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css">
<!--         <link href="assets/plugins/weather-icons-master/css/weather-icons.min.css" rel="stylesheet" type="text/css">	 -->
<!--         <link href="assets/plugins/metrojs/MetroJs.min.css" rel="stylesheet" type="text/css">	 -->
<!--         <link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css">	 -->
        	
        <!-- Theme Styles -->
        <link href="assets/css/modern.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/themes/white.css" class="theme-color" rel="stylesheet" type="text/css">
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css">
        
        <script src="assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
<%--         <script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script> --%>
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]--> 		       
        <decorator:head />         
        
    </head>
    <body class="page-header-fixed  pace-done"><div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="-webkit-transform: translate3d(100%, 0px, 0px); transform: translate3d(100%, 0px, 0px);">
  <div class="pace-progress-inner"></div>
</div>
<div class="pace-activity"></div></div>
        <div class="overlay"></div>        
        <form class="search-form" action="#" method="GET">
            <div class="input-group">
                <input type="text" name="search" class="form-control search-input" placeholder='<s:text name="global.pesquisar"/>'>
                <span class="input-group-btn">
                    <button class="btn btn-default close-search waves-effect waves-button waves-classic" type="button"><i class="fa fa-times"></i></button>
                </span>
            </div><!-- Input Group -->
        </form><!-- Search Form -->
        <main class="page-content content-wrap">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="sidebar-pusher">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                    <div class="logo-box">
                        <a href="index.html" class="logo-text"><span>QTS-Live</span></a>
                    </div><!-- Logo Box -->
                    <div class="search-button">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                    </div>
                    <div class="topmenu-outer">
                        <div class="top-menu">
                            <ul class="nav navbar-nav navbar-left">
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic sidebar-toggle"><i class="fa fa-bars"></i></a>
                                </li>
                                <li>
                                    <a href="#cd-nav" class="waves-effect waves-button waves-classic cd-nav-trigger"><i class="fa fa-diamond"></i></a>
                                </li>
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic toggle-fullscreen"><i class="fa fa-expand"></i></a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li>	
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                                </li>                                
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown"><i class="fa fa-bell"></i><span class="badge badge-success pull-right">3</span></a>
                                    <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                        <li><p class="drop-title">3 lembretes para ver.</p></li>
                                        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 100%;"><li class="dropdown-menu-list slimscroll tasks" style="overflow: hidden; width: auto; height: 100%;">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-success"><i class="icon-user"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">1min ago</span>
                                                        <p class="task-details">New user registered.</p>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-danger"><i class="icon-energy"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">24min ago</span>
                                                        <p class="task-details">Database error.</p>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-info"><i class="icon-heart"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">1h ago</span>
                                                        <p class="task-details">Reached 24k likes</p>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li><div class="slimScrollBar" style="width: 7px; position: absolute; top: 0px; opacity: 0.3; display: none; border-radius: 0px; z-index: 99; right: 0px; height: 138px; background: rgb(204, 204, 204);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; opacity: 0.2; z-index: 90; right: 0px; background: rgb(51, 51, 51);"></div></div>
                                        <li class="drop-all"><a href="#" class="text-center">All Tasks</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <span class="user-name">${usuario.nome}<i class="fa fa-angle-down"></i></span>
                                        <c:choose>
										  <c:when test="${not empty usuario.foto}">
										    <img class="img-circle avatar" src="fotoUsuario" width="40" height="40" alt="">
										  </c:when>										  
										  <c:otherwise>
										    <img class="img-circle avatar" src="assets/images/usuario_sem_foto.png" width="40" height="40" alt="">
										  </c:otherwise>
										</c:choose>
                                    </a>
                                    <input type="hidden" id="idClube" value="${usuario.clube.id}" />
                                    <input type="hidden" id="nomeClube" value="${usuario.clube.nome}" />
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="usuario?idUsuario=${usuario.id}"><i class="fa fa-user"></i><s:text name="global.meusdados"/></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a id="config-link" href="#"><i class="fa fa-cog"></i><s:text name="global.config"/></a></li>
                                        <li role="presentation"><a href="<s:url action="logout"/>"><i class="fa fa-sign-out m-r-xs"></i><s:text name="global.logout"/></a></li>
                                    </ul>
                                </li>                               
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
            <div class="page-sidebar sidebar">
                <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 100%;"><div class="page-sidebar-inner slimscroll" style="overflow: hidden; width: auto; height: 100%;">
<!--                     <div class="sidebar-header"> -->
<!--                         <div class="sidebar-profile"> -->
<!--                             <a href="javascript:void(0);" id="profile-menu-link"> -->
<!--                                 <div class="sidebar-profile-image"> -->
<!--                                     <img src="assets/images/avatar1.png" class="img-circle img-responsive" alt=""> -->
<!--                                 </div> -->
<!--                                 <div class="sidebar-profile-details"> -->
<%--                                     <span>David Green<br><small>Art Director</small></span> --%>
<!--                                 </div> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->
                    <ul class="menu accordion-menu">
                        <li><a href="<s:url action="home"/>" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>Home</p></a></li>                        
<%--                         <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-plus-sign"></span><p>Departamento Médico</p><span class="arrow"></span></a> --%>
<!--                             <ul class="sub-menu" style="display: none;"> -->
<!--                                 <li><a href="ui-alerts.html">Tratamento</a></li> -->
<!--                                 <li><a href="ui-buttons.html">Avaliação Médica</a></li>                                 -->
<!--                             </ul> -->
<!--                         </li> -->
<%--                         <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-tasks"></span><p>Fisiologia</p><span class="arrow"></span></a> --%>
<!--                             <ul class="sub-menu" style="display: none;"> -->
<!--                                 <li><a href="ui-alerts.html">Avaliação Física</a></li> -->
<!--                                 <li><a href="ui-buttons.html">Treinamento Transição</a></li>                                 -->
<!--                             </ul> -->
<!--                         </li> -->
                        <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-calendar"></span><p><s:text name="global.controle"/></p><span class="arrow"></span></a>
                            <ul class="sub-menu" style="display: none;">
                                <li><a href="<s:url action="treinos"/>"><s:text name="global.treinamento"/></a></li>
<!--                                 <li><a href="ui-buttons.html">Jogo</a></li>                                 -->
                            </ul>
                        </li>
                        <!-- #atletas-form --> 
                        <li><a id="atletas-link" href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p><s:text name="global.atletas"/></p></a></li>
                                               
                        
                        
                        
                       
                    </ul>
                </div><div class="slimScrollBar" style="width: 7px; position: absolute; top: 0px; opacity: 0.3; display: none; border-radius: 0px; z-index: 99; right: 0px; height: 672px; background: rgb(204, 204, 204);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; opacity: 0.2; z-index: 90; right: 0px; background: rgb(51, 51, 51);"></div></div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            <form id="config-form" action="config" method="POST">
				<input type="hidden" name="idClube" value="${usuario.clube.id}" />
			</form>			
            <div class="page-inner" style="min-height:1501px !important">                
                <div id="main-wrapper">
                
                	<decorator:body />                    
                   
                </div><!-- Main Wrapper -->
                <div class="page-footer">
                    <p class="no-s">2015 © QTS-Live.</p>
                </div>
            </div><!-- Page Inner -->
        </main><!-- Page Content -->
        <nav class="cd-nav-container" id="cd-nav">
            <header>
                <h3>Navigation</h3>
                <a href="#0" class="cd-close-nav">Close</a>
            </header>
            <ul class="cd-nav list-unstyled">
                <li class="cd-selected" data-menu="index">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-home"></i>
                        </span>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li data-menu="profile">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-user"></i>
                        </span>
                        <p>Profile</p>
                    </a>
                </li>
                <li data-menu="inbox">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-envelope"></i>
                        </span>
                        <p>Mailbox</p>
                    </a>
                </li>
                <li data-menu="#">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-tasks"></i>
                        </span>
                        <p>Tasks</p>
                    </a>
                </li>
                <li data-menu="#">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-cog"></i>
                        </span>
                        <p>Settings</p>
                    </a>
                </li>
                <li data-menu="calendar">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-calendar"></i>
                        </span>
                        <p>Calendar</p>
                    </a>
                </li>
            </ul>
        </nav>
        <div class="cd-overlay"></div>
	
		<form id="atletas-form" action="atletas" method="POST">
			<input type="hidden" name="idClube" value="${usuario.clube.id}" />
		</form>
        <!-- Javascripts -->
        <script src="assets/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="assets/plugins/pace-master/pace.min.js"></script>
        <script src="assets/plugins/jquery-blockui/jquery.blockui.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/plugins/switchery/switchery.min.js"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="assets/plugins/waves/waves.min.js"></script>
        <script src="assets/plugins/3d-bold-navigation/js/main.js"></script>
        
        <script src="assets/js/modern.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				
				//Link para o painel de configurações
				$("#config-link").click(function(e) {
					//e.preventDefault();
					$("#config-form").submit();
				});
				
				//Link para atletas
				$("#atletas-link").click(function(e) {
					//e.preventDefault();
					$("#atletas-form").submit();
				});
				
				
			});
		</script>

	<decorator:getProperty property="page.local_script">
		</decorator:getProperty>
		
    
<div id="flotTip" style="display: none; position: absolute;"></div></body></html>