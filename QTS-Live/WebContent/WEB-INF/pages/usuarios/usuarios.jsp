<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Usuários</title>
<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div class="panel panel-white">
		
		<div class="panel-heading clearfix">
			<h4 class="panel-title">Usuários</h4>
		</div>
		<div class="panel-body">
			<button id="buttonNovaPosicao" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalNovoRegistro"> Novo Usuário </button>
	            <div style="display: none;" class="modal fade" id="modalNovoRegistro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog modal-lg">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Adicionar Usuário</h4>
	                        </div>
	                        <div class="modal-body">  			
								<div class="row">
									<!-- FOTO -->
									<div class="col-sm-3">
										<form action="fotoUpload" id="drop" class="dropzone">
											<div class="form-group">													
<!-- 											        <div id="preview-drop" class="dropzone-previews" style="width: 30px"></div> -->
										        <div class="fallback"> <!-- this is the fallback if JS isn't working -->
										        	<input name="file" type="file" class="form-control" />											        
								       		    </div>									       		    
											</div>
										</form>
										<input type="hidden" id="id-nova-foto-input" />
									</div>	
<!-- 										<form id="add-row-form" action="javascript:void(0);">									 -->
									<div class="col-sm-9">
										<div class="row">
											<div class="col-sm-5">
												<div class="form-group">
													<label for="input-placeholder">Nome</label> <input
														type="text" class="form-control" id="novo-nome-input"
														placeholder="Nome" name="usuario.nome">
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label class="control-label">Data de Nascimento</label> <input
														id="nova-data-nascimento-input" type="text" class="form-control date-picker"
														placeholder="DD/MM/AAAA"
														name="usuario.dataNascimentoString">
												</div>
											</div>
										</div>
										<div class="row">											
											<div class="col-sm-5">
												<div class="form-group">
													<label for="exampleInputEmail1">E-mail</label> <input
														type="email" class="form-control" id="novo-email-input"
														placeholder="exemplo@email.com" name="usuario.email">
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label for="exampleInputPassword1">Senha</label> <input
														id="nova-senha-input" type="password" class="form-control"
														name="usuario.senha" placeholder="Senha">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-5">
												<div class="form-group">
													<label for="input-placeholder">Clube</label> 
													<input disabled="" class="form-control" id="input-disabled" type="text" placeholder="${usuario.clube.nome}"/>
													<input id="id-clube-input" type="hidden" value="${usuario.clube.id}"/>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label for="input-placeholder">Perfil</label> <select id="novo-perfil-select"
														class="js-states m-b-sm select2-hidden-accessible form-control"
														tabindex="-1" style="display: none; width: 100%"
														aria-hidden="true" name="usuario.perfil.id">
														<c:forEach items="${listaPerfil}" var="p" varStatus="status">
															<option value="${p.id}">${p.nome}</option>
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
														<option value="0"> -- Selecione -- </option>
														<c:forEach items="${listaCategoria}" var="p" varStatus="status">															
															<option value="${p.id}">${p.nome}</option> 
														</c:forEach>
													</select>
												</div>
											</div>	
																						
										</div>											
									</div>
<!-- 										</form> -->
								</div>
												
		                        	                        
		                    </div>
		                    <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	                            <button type="submit" id="add-row" class="btn btn-success">Adicionar</button>	                            
	                        </div>	
	                	</div>
	            	</div>
	            </div>
<!--             <form id="update-row-form" action="javascript:void(0);"> -->
	            <div style="display: none;" class="modal fade" id="modalEditarRegistro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog modal-lg">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Alterar Usuário</h4>
	                        </div>
	                        <div class="modal-body">
                        		<input id="id-input" type="hidden">	                                
                                <div class="form-group">
                                    <input id="nome-input" class="form-control" placeholder="Nome" required="" type="text">	                                    
                                </div>
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	                            <button type="submit" id="update-row" class="btn btn-success">Salvar</button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
<!--             </form>	 -->
            <div style="display: none;" class="modal fade" id="modalDeleteRegistro" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">Excluir Usuário</h4>
                        </div>
                        <div class="modal-body">
                                <div id="divMsgAlertaExcluir"></div>
                                <input id="id-perfil-excluir-input" type="hidden" />
                                <input id="id-clube-excluir-input" type="hidden" value="${usuario.clube.id}"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button type="submit" id="delete-row" class="btn btn-danger">Excluir</button>	                                                       
                        </div>
                    </div>
                </div>
            </div>	
           			
			<div class="table-responsive">
				<div class="dataTables_wrapper" id="example-editable_wrapper">				
					<table id="tabelaRegistros" class="display compact dataTable">
						<thead>
							<tr>								
								<th>Nome</th>
								<th>Perfil</th>								
								<th style="width: 25%">Opções</th>						
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Nome</th>
								<th>Perfil</th>								
								<th>Opções</th>																
							</tr>
						</tfoot>
						<tbody>							
							<c:forEach items="${lista}" var="l" varStatus="status"> 
								<tr id="${l.id}">									
									<td><a title="Ver perfil" href="usuario?idUsuario=${l.id}">${l.nome}</a></td>
									<td>${l.perfil.nome}</td>									
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="usuario?idUsuario=${l.id}">Editar</a></li>
                                                <li><a data-toggle="modal" data-target="#modalDeleteRegistro" href="#" onclick="iniciarDeleteRegistro('${l.id}', '${l.nome}', '${l.perfil.nome}')">Deletar</a></li>                                                
                                            </ul>
                                        </div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>				
				</div>
			</div>
			
		</div>
		
		
	</div>
	<div class="cd-overlay"></div>
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

		<script>
		
			$(document).ready(function() {
				
				$('#lista-categorias-div').hide();
					
				$('.date-picker').datepicker({
			        orientation: "top auto",
			        autoclose: true,
			        format: "dd/mm/yyyy",
		            language: "pt-BR",
		            startView: 2
			    });
				
				// "drop" is the camelized version of the HTML element's ID
				Dropzone.options.drop = {
				  paramName: "file", // The name that will be used to transfer the file
				  maxFilesize: 3, // MB
				  init: function () {
					    this.on("success", function(file, data) {
					        $("#id-nova-foto-input").val(data.idFoto);
					    });
					  }
				};

				//Constroi a tabela.
				var t = $('#tabelaRegistros').DataTable({
					"responsive": true,
					"language": {
		                "url": "assets/plugins/datatables/Portuguese-Brasil.json"
		            }
				});
				
				
				
				$('#tabelaRegistros tbody').on( 'click', 'tr', function () {
			        if ( $(this).hasClass('selected') ) {
			            $(this).removeClass('selected');
			        }
			        else {
			            t.$('tr.selected').removeClass('selected');
			            $(this).addClass('selected');
			        }
			    } );
				
				$('#novo-perfil-select').change(function () {
					
					var perfil = $('#novo-perfil-select option:selected').text().toLowerCase();
					
					if( (perfil.indexOf("preparador") >= 0) || (perfil.indexOf("físico") >= 0) || (perfil.indexOf("fisico") >= 0)) {
						$('#lista-categorias-div').show();
					} else {
						$('#lista-categorias-div').hide();
						$('#novo-categoria-select').val(null);
					}
					
				});
				
				//Adicionar				
				$('#add-row').click(function () {
					
					//Se o formulário está preenchido ok.
					//if($("#add-row-form").isValid()) {
			        
			            var	idFoto = $('#id-nova-foto-input').val(),
			                nome = $('#novo-nome-input').val(),
			                dataNasc = $('#nova-data-nascimento-input').val(),
			                email = $('#novo-email-input').val(),
			                senha = $('#nova-senha-input').val(),
			                idClube = $('#id-clube-input').val(),
			                idPerfil = $('#novo-perfil-select').val(),
			            	idCategoria = $('#novo-categoria-select').val();
			            
			            if(null==idCategoria) {
			            	idCategoria = 0;
			            }
			                
			            var params = "?usuario.foto.id="+idFoto+
			            		     "&usuario.nome="+nome+
			            		     "&usuario.dataNascimentoString="+dataNasc+
			            		     "&usuario.email="+email+
			            		     "&usuario.senha="+senha+
			            		     "&usuario.clube.id="+idClube+
			            		     "&usuario.perfil.id="+idPerfil+
			            			 "&usuario.categoria.id="+idCategoria;
			            
			            //Envia a requisição
			            $.ajax({
			                type: "POST",
			                url: 'criarUsuarioJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	var id = data.usuario.id;			                	
				                var nome = data.usuario.nome;
 				                var perfil = data.usuario.perfil.nome;
				                
				                //Adiciona a linha
			                	var rowIndex = $('#tabelaRegistros').dataTable().fnAddData([
												               				                gerarLinkPerfilUsuario(id, nome),
												               				                perfil,												               				                
												               				                gerarBotaoEditar(id)
												               				              ]);
			                	
				                //Adiciona o id na linha
			                    var row = $('#tabelaRegistros').dataTable().fnGetNodes(rowIndex);
			                    $(row).attr('id', id);
			                    
			                    //Faz a animação de linha inserida
			                	$(row).effect("highlight", {color: "#7A6FBE"}, 3500);
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');
			            
			            //Limpar campos			            
			            $('#id-nova-foto-input').val('');
			            $('#novo-nome-input').val('');
			            $('#nova-data-nascimento-input').val('');
			            $('#novo-email-input').val('');
			            $('#nova-senha-input').val('');			            
			            $('#novo-perfil-select').val('');
			            
			            return false;
					//}
				        
				});
				
				//Editar
				$('#update-row').click(function () {					
					
					if($("#update-row-form").isValid()) {
				        
			            var nome = $('#nome-input').val(),
			                id =  $('#id-input').val();
			            
			            var params = "?id="+id+"&nome="+nome;
			            alert("passou");
			            
			            $.ajax({
			                type: "POST",
			                url: 'editarCategoriaJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                	var tr = $('#'+id).closest("tr");
				            	$(tr).find('td:eq(0)').html(nome);
				            	$(tr).find('td:eq(1)').html(gerarBotaoEditar(id, sigla, nome));
				            	 
				            	$(tr).effect("highlight", {color: "#7A6FBE"}, 3500);
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');
			            
			            //Limpar campos
			            $('#id-input').val('');			           
			            $('#nome-input').val('');
			            
			            return false;
					}
					
				});
				
				//Excluir
				$('#delete-row').click(function () {					
				        
			            var id = $('#id-perfil-excluir-input').val(),
			                idClube = $('#id-clube-excluir-input').val();
			            
			            var params = "?id="+id+"&idClube="+idClube;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirUsuarioJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');	
			            
			            $('#'+id).hide(1500, function() {
			            	var t = $("#tabelaRegistros").DataTable();
				            t.row( $('#'+id) ).remove().draw();
			            });
			            
			            //Limpar campos
			            $('#id-perfil-excluir-input').val('');
			            
			            return false;
										
				});
				
				
						    

			}); //fim ready
			
			function iniciarEdicaoRegistro(id, nome) {
				
				$('#id-input').val(id);				
	            $('#nome-input').val(nome);	            
				return false;
		    }
			
			function iniciarDeleteRegistro(id, nome, perfil) {	
				
				$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">Excluir a usuário "<b>'+nome+'</b> ('+perfil+')"?</div>');				
				var id = $('#id-perfil-excluir-input').val(id);
				return false;
				
		    }
			
			function iniciarVisualizarPermissoes(id) {	
				
				$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">Excluir a categoria "<b>'+nome+'</b>"?</div>');				
				var id = $('#id-perfil-excluir-input').val(id);
				return false;
				
		    }
			
			
			function gerarBotaoEditar(id, nome, perfil) {
				return '<div class="btn-group m-b-sm" style="height: 6px">'+
			                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span></button>'+
			                '<ul class="dropdown-menu" role="menu">'+
			                    '<li><a href="usuario?idUsuario='+id+'">Editar</a></li>'+
			                    '<li><a data-toggle="modal" data-target="#modalDeleteRegistro" href="#" onclick="iniciarDeleteRegistro('+
			                    "'"+id+"','"+nome+",'"+perfil+")"+
	                    		'">Excluir</a></li>'+                                                
			                '</ul>'+
			            '</div>';
			}			
			
			
			function gerarLinkPerfilUsuario(id, nome) {
				
				return '<a title="Ver perfil" href="usuario?idUsuario='+id+'">'+nome+'</a>';
		    }
			
			
			
			
		</script>
	</content>
</body>
</html>