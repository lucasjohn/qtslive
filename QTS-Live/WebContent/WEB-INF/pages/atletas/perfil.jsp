<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | ${atleta.nome }</title>
<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>
<body>
	<div class="panel panel-white">
		<div class="profile-cover">
		    <div class="row">
		        <div class="col-md-3 profile-image">
		            <div class="profile-image-container">
		            	<c:choose>
						  <c:when test="${not empty atleta.foto}">
						    <img src="obterFoto?id=${atleta.foto.id }" alt="" class="img-rounded">
						  </c:when>										  
						  <c:otherwise>
						    <img src="assets/images/usuario_sem_foto.png" alt="" class="img-rounded">
						  </c:otherwise>
						</c:choose>	                
		            </div>
		        </div>
		        <div class="col-md-12 profile-info">
		            <div class=" profile-info-value">
		                <h3>Idade</h3>
		                <p>${atleta.idade}</p>
		            </div>
		            <div class=" profile-info-value">
		                <h3>Categoria</h3>
		                <p>${atleta.categoria.nome}</p>
		            </div>
		            <div class=" profile-info-value">
		                <h3>Posição</h3>
		                <p>${atleta.siglasPosicoesString }</p>
		            </div>         
		            
		        </div>
		    </div>	   
		</div>
		<div style="margin-right: 15px; margin-top: 5px" align="right">
			<a href="#" data-toggle="modal" data-target="#modal-atleta"><i class="fa fa-cog"> Editar &nbsp;</i> </a> 
		</div>
		
		
		<!-- MODAL -->
		<div style="display: none;" class="modal fade" id="modal-atleta"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Dados Atleta</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<!-- FOTO -->
							<div class="col-sm-3">								
								<input type="hidden" id="id-nova-foto-input" value="${atleta.foto.id }" />
								<div id="foto-div" class="form-group">
									<label for="input-placeholder"></label>
									<div id="foto-atleta-editar-div" align="center">
										<c:choose>
										  <c:when test="${not empty atleta.foto}">
										    <img src="obterFoto?idAtleta=${atleta.foto.id }" alt="" style="width: 150px; height: 150px;">
										  </c:when>										  
										  <c:otherwise>
										    <img src="assets/images/usuario_sem_foto.png" alt="" style="">
										  </c:otherwise>
										</c:choose>
										<br/>
										<a id="alterar-foto-link" href="#"><i class="fa fa-refresh"> Alterar foto &nbsp;</i> </a>										
									</div>	
								</div>								 
								<div id="nova-foto-div" style="display: none;" align="center">
									<form action="fotoUpload" id="dropAtleta" class="dropzone">
										<div class="form-group">
											<!--<div id="preview-drop" class="dropzone-previews" style="width: 30px"></div> -->
											<div class="fallback">
												<!-- this is the fallback if JS isn't working -->
												<input name="file" type="file" class="form-control" />
											</div>
										</div>
									</form>
									<a id="alterar-foto-cancelar-link" href="#"><i class="fa fa-mail-reply"> Cancelar &nbsp;</i> </a>										
								</div>
							</div>
							<!--<form id="add-row-form" action="javascript:void(0);"> -->
							<div class="col-sm-9">
								<div class="row">
									<div class="col-sm-8">
										<div class="form-group">
											<label for="input-placeholder">Nome</label> <input
												type="text" class="form-control" id="new-nome"
												placeholder="Nome" name="atleta.nome" value="${atleta.nome }">
												<input id="id-atleta-input" type="hidden" value="${atleta.id }">
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="exampleInputEmail1">Apelido</label> <input
												type="text" class="form-control" id="new-apelido"
												placeholder="Apelido" name="atleta.apelido" value="${atleta.apelido }">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="control-label">Data de Nascimento</label> <input
												id="new-data-nasc" type="text"
												class="form-control date-picker" placeholder="DD/MM/AAAA"
												name="atleta.dataNascimentoString" value="${atleta.dataNascimentoString }">
										</div>
									</div>
									<div class="col-sm-5">
										<div class="form-group">
											<label for="input-placeholder">E-mail</label> <input
												type="email" class="form-control" id="new-email"
												placeholder="exemplo@email.com" name="atleta.email" value="${atleta.email }">
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<label for="exampleInputEmail1">Telefone</label> <input
												type="text" class="form-control" id="new-telefone"
												placeholder="Telefone" name="atleta.telefone" value="${atleta.telefone }">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-3">
										<div class="form-group">
											<label for="input-placeholder">Categoria</label> <select
												class="js-states m-b-sm select2-hidden-accessible form-control"
												tabindex="-1" style="display: none; width: 100%"
												aria-hidden="true" name="atleta.idCategoria"
												id="new-categoria">
												<c:forEach items="${listaCategoria}" var="cat" varStatus="status">
													<c:if test="${cat.id == atleta.categoria.id  }">
														<option selected="selected" value="${cat.id}">${cat.nome}</option>
													</c:if>
													<c:if test="${cat.id != atleta.categoria.id  }">
														<option value="${cat.id}">${cat.nome}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<label for="exampleInputEmail1">Dominânica</label> <select
												class="js-states m-b-sm select2-hidden-accessible form-control"
												tabindex="-1" style="display: none; width: 100%"
												aria-hidden="true" name="atleta.idDominancia"
												id="new-dominancia">
												<c:forEach items="${listaDominancia}" var="dom" varStatus="status">
													<c:if test="${dom.id == atleta.dominancia.id  }">
														<option selected="selected" value="${dom.id}">${dom.nome}</option>
													</c:if>
													<c:if test="${dom.id != atleta.dominancia.id  }">
														<option value="${dom.id}">${dom.nome}</option>
													</c:if>													
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label class="control-label">Posições</label> <select
												class="js-states m-b-sm select2-hidden-accessible form-control"
												multiple="multiple" tabindex="-1"
												style="display: none; width: 100%" aria-hidden="true"
												name="listaPosicoes" id="new-lista-posicoes">
												<c:forEach items="${listaPosicao}" var="pos" varStatus="status">													
													<c:if test="${pos.selecionado == true }">
														<option selected="selected" value="${pos.id}" title="${pos.nome}">${pos.sigla}</option>
													</c:if>
													<c:if test="${pos.selecionado == false }">
														<option value="${pos.id}" title="${pos.nome}">${pos.sigla}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<!-- 										<div class="row"> -->
								<!-- 											<div class="col-sm-5"> -->
								<!-- 												<div class="form-group"> -->
								<!-- 													<label for="input-placeholder">Clube</label>  -->
								<%-- 													<input disabled="" class="form-control" id="input-disabled" type="text" placeholder="${usuario.clube.nome}"/> --%>
								<input id="id-clube-input" type="hidden"
									value="${usuario.clube.id}" />
								<!-- 												</div> -->
								<!-- 											</div> -->
								<!-- 										</div>							 -->
							</div>
						</div>
					</div>
					<!-- FIM modal-body -->

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type="submit" id="add-row" class="btn btn-success">Salvar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- FIM MODAL -->



		<br/>
		<div class="row">
            <div class="col-md-6">
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h3 class="panel-title">Line Chart</h3>
                    </div>
                    <div class="panel-body">
                        <div>
                            <canvas id="chart1" height="260" width="520" style="width: 520px; height: 260px;"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bar Chart</h3>
                    </div>
                    <div class="panel-body">
                        <div>
                            <canvas id="chart2" height="260" width="520" style="width: 520px; height: 260px;"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h3 class="panel-title">Line Chart</h3>
                    </div>
                    <div class="panel-body">
                        <div>
                            <canvas id="chart1" height="260" width="520" style="width: 520px; height: 260px;"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h3 class="panel-title">Radar Chart</h3>
                    </div>
                    <div class="panel-body">
                        <div>
                            <canvas id="chart6" height="260" width="520" style="width: 520px; height: 260px;"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		
	</div>
	


<content tag="local_script">
	<script src="assets/plugins/jquery-mockjax-master/jquery.mockjax.js"></script>
	<script src="assets/plugins/datatables/js/jquery.datatables.min.js"></script>
	<script src="assets/plugins/datatables/js/dataTables.responsive.js"></script>
	<script src="assets/plugins/x-editable/bootstrap3-editable/js/bootstrap-editable.js"></script>
	<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>		
	<!-- 		<script src="assets/js/pages/table-data.js"></script> -->
	<script src="assets/plugins/select2/js/select2.min.js"></script>
	<script src="assets/js/pages/form-select2.js"></script>
	<script src="assets/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.pt-BR.js"></script>		
	<script src="assets/plugins/mask/jquery.mask.js"></script>
	<script src="assets/plugins/x-editable/bootstrap3-editable/js/bootstrap-editable.js"></script>	
	<script src="assets/plugins/dropzone/dropzone.min.js"></script>	
	<script src="assets/plugins/chartsjs/Chart.min.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript">

	
		$(document).ready(function() {
			
			toastr.options = {
					  "closeButton": true,
					  "debug": false,
					  "newestOnTop": false,
					  "progressBar": true,
					  "positionClass": "toast-top-center",
					  "preventDuplicates": false,
					  "onclick": null,
					  "showDuration": "300",
					  "hideDuration": "1000",
					  "timeOut": "5000",
					  "extendedTimeOut": "1000",
					  "showEasing": "swing",
					  "hideEasing": "linear",
					  "showMethod": "fadeIn",
					  "hideMethod": "fadeOut"
					}
			
			// "drop" is the camelized version of the HTML element's ID
			Dropzone.options.dropAtleta = {
			  paramName: "file", // The name that will be used to transfer the file
			  maxFilesize: 3, // MB
			  init: function () {
				    this.on("success", function(file, data) {
				        $("#id-nova-foto-input").val(data.idFoto);
				    });
				  }
			};
			
			
			$('#alterar-foto-link').click(function () {
				
				$('#foto-div').hide();
				$('#nova-foto-div').show();				
			
			});
			
			$('#alterar-foto-cancelar-link').click(function () {
				
				$('#nova-foto-div').hide();
				$('#foto-div').show();								
			
			});
			
			//Adicionar				
			$('#add-row').click(function () {
				
				//Se o formulário está preenchido ok.
				//if($("#add-row-form").isValid()) {
					
		        	
		            var	idFoto = $('#id-nova-foto-input').val(),
		            	idClube = $('#id-clube-input').val(),
		            	idAtleta = $('#id-atleta-input').val(),
		                nome = $('#new-nome').val(),
		                apelido = $('#new-apelido').val(),
		                dtnasc = $('#new-data-nasc').val(),
		                email = $('#new-email').val(),
		                telefone = $('#new-telefone').val(),
		                categoria = $('#new-categoria').val(),
		                dominancia = $('#new-dominancia').val(),
		                listaposicoes = $('#new-lista-posicoes').val();
		            
		           
						var params = "?atleta.foto.id="+idFoto+
									 "&atleta.id="+idAtleta+
									 "&atleta.clube.id="+idClube+
								     "&atleta.nome="+nome+
			            		     "&atleta.apelido="+apelido+
			            		     "&atleta.dataNascimentoString="+dtnasc+
			            		     "&atleta.email="+email+
			            		     "&atleta.telefone="+telefone+
			            		     "&atleta.categoria.id="+categoria+
			            		     "&atleta.dominancia.id="+dominancia+
			            		     "&idsPosicao="+listaposicoes;
						
		            
		            //Envia a requisição
		            $.ajax({
		                type: "GET",
		                url: 'alterarAtletaJson'+params,
		                dataType: 'json',				                
		                processData: false,
		                contentType: 'application/json',
		                success: function(data) {
		                	
		                	toastr["success"]("O atleta <b>"+data.atleta.nome+"</b> foi atualizado com sucesso!");
		                	   
		                }
		                
		            });
		            			            
		            
		            $('.modal').modal('hide');		            
		            
		            
		            return false;
				//}
			        
			});
			
							
		}); //fim ready
	</script>
</content>
</body>
</html>