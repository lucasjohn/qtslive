<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | ${usuarioPerfil.nome }</title>
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
		            <div id="foto-perfil-div" class="profile-image-container">
		            	<c:choose>
						  <c:when test="${not empty usuarioPerfil.foto}">
						    <img src="obterFoto?id=${usuarioPerfil.foto.id }" alt="">
						  </c:when>										  
						  <c:otherwise>
						    <img src="assets/images/usuario_sem_foto.png" alt="">
						  </c:otherwise>
						</c:choose>	                
		            </div>
		        </div>
		        <div class="col-md-12 profile-info">
		            <div class=" profile-info-value">
		                <h3>Nome</h3>
		                <p id="nome-perfil-p">${usuarioPerfil.nome}</p>
		            </div>
		            <div class=" profile-info-value">
		                <h3>Perfil</h3>
		                <p id="nome-perfil-perfil-p">${usuarioPerfil.perfil.nome}</p>
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
						<h4 class="modal-title" id="myModalLabel">Dados Usuário</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<!-- FOTO -->
							<div class="col-sm-3">
								<input type="hidden" id="id-nova-foto-input"
									value="${usuarioPerfil.foto.id }" />
								<div id="foto-div" class="form-group">
									<label for="input-placeholder"></label>
									<div id="foto-atleta-editar-div" align="center">
										<c:choose>
											<c:when test="${not empty usuarioPerfil.foto}">
												<img src="obterFoto?id=${usuarioPerfil.foto.id }" alt=""
													style="width: 150px; height: 150px;">
											</c:when>
											<c:otherwise>
												<img src="assets/images/usuario_sem_foto.png" alt=""
													style="">
											</c:otherwise>
										</c:choose>
										<br /> <a id="alterar-foto-link" href="#"><i
											class="fa fa-refresh"> Alterar foto &nbsp;</i> </a>
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
									<a id="alterar-foto-cancelar-link" href="#"><i
										class="fa fa-mail-reply"> Cancelar &nbsp;</i> </a>
								</div>
							</div>
							<!-- 										<form id="add-row-form" action="javascript:void(0);">									 -->
							<div class="col-sm-9">
								<div class="row">
									<div class="col-sm-5">
										<div class="form-group">
											<label for="input-placeholder">Nome</label> <input
												type="text" class="form-control" id="novo-nome-input"
												placeholder="Nome" name="usuarioPerfil.nome" value="${usuarioPerfil.nome}">
												<input type="hidden" id="id-usuario-input" value="${usuarioPerfil.id}">
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="input-placeholder">Perfil</label> <select
												id="novo-perfil-select"
												class="js-states m-b-sm select2-hidden-accessible form-control"
												tabindex="-1" style="display: none; width: 100%"
												aria-hidden="true" name="usuarioPerfil.perfil.id">
												<c:forEach items="${listaPerfil}" var="p" varStatus="status">													
													<c:if test="${p.id == usuarioPerfil.perfil.id }">
														<option selected="selected" value="${p.id}">${p.nome}</option>
													</c:if>
													<c:if test="${p.id != usuarioPerfil.perfil.id }">
														<option value="${p.id}">${p.nome}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div id="lista-categorias-div" class="col-sm-3">
										<div class="form-group">
											<label for="input-placeholder">Categoria</label> <select id="novo-categoria-select"
												class="js-states m-b-sm select2-hidden-accessible form-control"
												tabindex="-1" style="display: none; width: 100%"
												aria-hidden="true" name="usuario.categoria.id">												
												<c:forEach items="${listaCategoria}" var="p" varStatus="status">
													<c:if test="${p.id == usuarioPerfil.categoria.id }">
														<option selected="selected" value="${p.id}">${p.nome}</option>														
													</c:if>
													<c:if test="${p.id != usuarioPerfil.categoria.id }">
														<option value="${p.id}">${p.nome}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>	
								</div>
								<div class="row">
									<div class="col-sm-5">
										<div class="form-group">
											<label for="exampleInputEmail1">E-mail</label> <input
												type="email" class="form-control" id="novo-email-input"
												placeholder="exemplo@email.com" name="usuarioPerfil.email" value="${usuarioPerfil.email}">
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="exampleInputPassword1">Senha</label> <input
												id="nova-senha-input" type="password" class="form-control"
												name="usuarioPerfil.senha" placeholder="Senha" value="${usuarioPerfil.senha}">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5">
										<div class="form-group">
											<label for="input-placeholder">Clube</label> <input
												disabled="" class="form-control" id="input-disabled"
												type="text" placeholder="${usuarioPerfil.clube.nome}" /> <input
												id="id-clube-input" type="hidden"
												value="${usuarioPerfil.clube.id}" />
										</div>
									</div>
									
								</div>
							</div>
							<!-- 										</form> -->
						</div>
						<!-- FIM modal-body -->

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
							<button type="submit" id="add-row" class="btn btn-success">Salvar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- FIM MODAL -->

		<br/>
		<br/>
		
        <div class="row"> <!-- LINHA -->
        
        	 <div class="col-md-6"> <!-- COLUNA (col-md-6) -->
                <div class="panel panel-white">
                    <div class="panel-heading">
                        <h3 class="panel-title">Permissões</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
							<div class="dataTables_wrapper" id="example-editable_wrapper">				
								<table id="tabela-permissoes" class="display compact dataTable">
									<thead>
										<tr>								
											<th style="width: 30%">Módulo</th>
											<th style="width: 45%">Funcionalidade</th>													
											<th style="width: 25%">Opções</th>						
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Módulo</th>
											<th>Funcionalidade</th>													
											<th>Opções</th>																
										</tr>
									</tfoot>
									<tbody>	
										<tr>
											<th>Atleta</th>
											<th>Leitura</th>													
											<th>Opções</th>												
										</tr>							
										<tr>
											<th>Listas</th>
											<th>Leitura</th>													
											<th>Opções</th>												
										</tr>
										<tr>
											<th>Listas</th>
											<th>Gravação</th>													
											<th>Opções</th>												
										</tr>
									</tbody>
								</table>				
							</div>
						</div>
                    </div>
                </div>
            </div><!-- FIM COLUNA (col-md-6) -->
        
            <div class="col-md-6"> <!-- COLUNA (col-md-6) -->
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
            </div> <!-- FIM COLUNA (col-md-6) -->
            
           
            
        </div><!-- LINHA -->
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
	<script src="assets/js/graficosUsuario.js"></script>
	<script src="assets/plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript">

		$(document).ready(function() {
			
			$('.date-picker').datepicker({
		        orientation: "top auto",
		        autoclose: true,
		        format: "dd/mm/yyyy",
	            language: "pt-BR",
	            startView: 2
		    });
			
			$('#tabela-permissoes').DataTable({
				"responsive": true,
				"language": {
	                "url": "assets/plugins/datatables/Portuguese-Brasil.json"
	            }
			});
			
			
			$('#tabela-permissoes tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		        }
		        else {
		            t.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		        }
		    } );
			
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
			
			$('#novo-perfil-select').change(function () {
				
				var perfil = $('#novo-perfil-select option:selected').text().toLowerCase();
				
				if( (perfil.indexOf("preparador") >= 0) || (perfil.indexOf("físico") >= 0) || (perfil.indexOf("fisico") >= 0)) {
					$('#lista-categorias-div').show();
				} else {
					$('#lista-categorias-div').hide();
					$('#novo-categoria-select').val(null);
				}
				
			});
			
			
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
	                	id = $('#id-usuario-input').val(),
		                nome = $('#novo-nome-input').val(),
		                dataNasc = $('#nova-data-nascimento-input').val(),
		                email = $('#novo-email-input').val(),
		                senha = $('#nova-senha-input').val(),
		                idClube = $('#id-clube-input').val(),
		                idPerfil = $('#novo-perfil-select').val(),
		            	idCategoria = $('#novo-categoria-select').val();
			                
		            var params = "?usuarioPerfil.foto.id="+idFoto+
		            			 "&usuarioPerfil.id="+id+
		            		     "&usuarioPerfil.nome="+nome+
		            		     "&usuarioPerfil.dataNascimentoString="+dataNasc+
		            		     "&usuarioPerfil.email="+email+
		            		     "&usuarioPerfil.senha="+senha+
		            		     "&usuarioPerfil.clube.id="+idClube+
		            		     "&usuarioPerfil.perfil.id="+idPerfil+
		            		     "&usuarioPerfil.categoria.id="+idCategoria;
						
		            
		            //Envia a requisição
		            $.ajax({
		                type: "GET",
		                url: 'alterarUsuarioJson'+params,
		                dataType: 'json',				                
		                processData: false,
		                contentType: 'application/json',
		                success: function(data) {
		                	
		                	toastr["success"]("O usuário <b>"+data.usuarioPerfil.nome+"</b> foi atualizado com sucesso!");
		                	
		                	$('#foto-perfil-div').html('<img src="obterFoto?id='+data.usuarioPerfil.foto.id+'" alt="">')
		                	$('#nome-perfil-p').html(data.usuarioPerfil.nome);
		                	/*$('#nome-perfil-perfil-p').html(data.usuarioPerfil.perfil.nome);*/
		                	
		                	   
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