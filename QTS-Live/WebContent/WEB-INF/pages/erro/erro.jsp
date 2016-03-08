<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Erro</title>

 <script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

</head>

<body class="page-error  pace-done">	
	<div class="page-inner" style="min-height: nullpx !important">
		<div id="main-wrapper">
			<div class="row">
				<div class="col-md-4 center">
					<h1 class="text-xxl text-primary text-center">500</h1>
					<div class="details" align="center">
						<h3>Ops! Alguma coisa não deu certo.</h3>
						<p>
							Não foi possível processar a sua requisição. Retorne para a <a
								href="<s:url action='home'/>">Home</a> ou faça uma busca. 
							<a data-toggle="modal" data-target="#log-modal" href="#">Mais informações <span aria-hidden="true" class="icon-info"></span></a>
						</p>
					</div>
					<form class="input-group">
						<input type="text" class="form-control" placeholder="Pesquisar">
						<span class="input-group-btn">
							<button class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</form>					
				</div>
			</div>
			<!-- Row -->
		</div>
		<!-- Main Wrapper -->
	</div>	
	<!-- Page Content -->
	
	<!-- MODAL LOG -->
	<div style="display: none;" class="modal fade" id="log-modal" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                <h4 class="modal-title" id="myModalLabel"><i class="fa fa-bug"></i> Log </h4>
	            </div>
	            <div class="modal-body">	            	
					<b>Exception</b><br/> ${exception} <br/>
					<b>Stack trace</b><br/> ${exceptionStack}<br/>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>	                	                                                       
	            </div>
	        </div>
	    </div>
	</div>
      	<!-- MODAL LOG FIM -->

	
	<content tag="local_script"> 
	<script src="assets/plugins/offcanvasmenueffects/js/classie.js"></script>
	
	<script type="text/javascript">	

		$(document).ready(function() {
		
			
							
		}); //fim ready
		
	</script> </content>
</body>
</html>