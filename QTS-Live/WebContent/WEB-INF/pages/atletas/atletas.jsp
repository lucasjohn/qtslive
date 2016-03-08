<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Atletas</title>
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
			<h4 class="panel-title">Atletas</h4>
		</div>
		<div class="panel-body">
			<button id="buttonNovaPosicao" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalAtleta"> Novo(a) atleta </button>			
            <div style="display: none;" class="modal fade" id="modalAtleta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">Adicionar Atleta</h4>
                        </div>
						<div class="modal-body">	
							<div class="row">
								<!-- FOTO -->
								<div class="col-sm-3">
									<form action="fotoUpload" id="dropAtleta" class="dropzone">
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
										<div class="col-sm-8">
											<div class="form-group">
												<label for="input-placeholder">Nome</label> <input
													type="text" class="form-control" id="new-nome"
													placeholder="Nome" name="atleta.nome">
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<label for="exampleInputEmail1">Apelido</label> <input
													type="text" class="form-control" id="new-apelido"
													placeholder="Apelido" name="atleta.apelido">
											</div>
										</div>
									</div>
	
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group">
												<label class="control-label">Data de Nascimento</label> <input
													id="new-data-nasc" type="text" class="form-control date-picker"
													placeholder="DD/MM/AAAA" name="atleta.dataNascimentoString">
											</div>
										</div>
										<div class="col-sm-5">
											<div class="form-group">
												<label for="input-placeholder">E-mail</label> <input
													type="email" class="form-control" id="new-email"
													placeholder="exemplo@email.com" name="atleta.email">
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="exampleInputEmail1">Telefone</label> <input
													type="text" class="form-control" id="new-telefone"
													placeholder="Telefone" name="atleta.telefone">
											</div>
										</div>
									</div>
	
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="input-placeholder">Categoria</label> <select
													class="js-states m-b-sm select2-hidden-accessible form-control"
													tabindex="-1" style="display: none; width: 100%"
													aria-hidden="true" name="atleta.idCategoria" id="new-categoria">
													<c:forEach items="${listaCategoria}" var="cat" varStatus="status"> 
														<option value="${cat.id}">${cat.nome}</option>
													</c:forEach>												
												</select>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="exampleInputEmail1">Dominânica</label> <select
													class="js-states m-b-sm select2-hidden-accessible form-control"
													tabindex="-1" style="display: none; width: 100%"
													aria-hidden="true" name="atleta.idDominancia" id="new-dominancia">
													<c:forEach items="${listaDominancia}" var="dom" varStatus="status"> 
														<option value="${dom.id}">${dom.nome}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Posições</label> 
												<select
													class="js-states m-b-sm select2-hidden-accessible form-control"
													multiple="multiple" tabindex="-1"
													style="display: none; width: 100%" aria-hidden="true"
													name="listaPosicoes" id="new-lista-posicoes">												
													<c:forEach items="${listaPosicao}" var="pos" varStatus="status"> 
														<option value="${pos.id}" title="${pos.nome}">${pos.sigla}</option>
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
												<input id="id-clube-input" type="hidden" value="${usuario.clube.id}"/>
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div>							 -->
								</div>
							</div>
						</div> <!-- FIM modal-body -->
						
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button type="submit" id="add-row" class="btn btn-success">Adicionar</button>	                            
                        </div>
                    </div>
                </div>
            </div>     

           
            <div style="display: none;" class="modal fade" id="modalDeleteAtleta" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">Excluir Atleta</h4>
                        </div>
                        <div class="modal-body">
                                <div id="divMsgAlertaExcluir"></div>
                                <input id="inputIdExcluir" type="hidden">
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
								<th width="30%">Nome</th>
								<th width="10%">Categoria</th>
								<th width="10%">Idade</th>
								<th width="10%">Dominância</th>
								<th width="25%">Posições</th>
								<th width="15%">Opções</th>						
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Nome</th>
								<th>Categoria</th>
								<th>Idade</th>
								<th>Dominância</th>
								<th>Posições</th>
								<th>Opções</th>																
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${listaAtleta}" var="a" varStatus="status"> 
								<tr id="${a.id}">
									<td><a title="Ver perfil" href="atleta?idAtleta=${a.id}&idClube=${usuario.clube.id}">${a.nome}</a></td>									
									<td>${a.categoria.nome}</td>
									<td>${a.idade}</td>
									<td>${a.dominancia.nome}</td>
									<td>${a.siglasPosicoesString}</td>
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                            	<li><a href="#" onclick="iniciarPerfilAtleta('${a.id}')">Ver profile</a></li>
                                                <li><a data-toggle="modal" data-target="#modalDeleteAtleta" href="#" onclick="iniciarDelete('${a.id}','${a.nome}')">Deletar</a></li>
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

				//Constroi a tabela.
				var t = $('#tabelaRegistros').DataTable({
					"responsive": true,
					"language": {
		                "url": "assets/plugins/datatables/Portuguese-Brasil.json"
		            }
				});
				
				$('.date-picker').datepicker({
			        orientation: "top auto",
			        autoclose: true,
			        format: "dd/mm/yyyy",
		            language: "pt-BR",
		            startView: 2
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
				
				//Adicionar				
				$('#add-row').click(function () {
					
					//Se o formulário está preenchido ok.
					//if($("#add-row-form").isValid()) {
						
			        	
			            var	idFoto = $('#id-nova-foto-input').val(),
			            	idClube = $('#id-clube-input').val(),
			                nome = $('#new-nome').val(),
			                apelido = $('#new-apelido').val(),
			                dtnasc = $('#new-data-nasc').val(),
			                email = $('#new-email').val(),
			                telefone = $('#new-telefone').val(),
			                categoria = $('#new-categoria').val(),
			                dominancia = $('#new-dominancia').val(),
			                listaposicoes = $('#new-lista-posicoes').val();
			            
			           
 						var params = "?atleta.foto.id="+idFoto+
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
			                url: 'criarAtletaJson'+params,
			                dataType: 'json',				                
			                processData: false,
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                	    var id = data.atleta.id,			                	    
			                	    nome = data.atleta.nome,
					                idade = data.atleta.idade,
					                nomecategoria = data.atleta.categoria.nome,
					                nomedominancia = data.atleta.dominancia.nome,
					                siglasPosicoes = data.atleta.siglasPosicoesString;
				                
				                //Adiciona a linha
			                	var rowIndex = $('#tabelaRegistros').dataTable().fnAddData([
													                						nome,
												               				                nomecategoria,
												               				             	nomedominancia,
												               				             	idade,
												               				                siglasPosicoes,
												               				                gerarBotaoEditar(id, nome)
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
			            $('#nova-sigla-input').val('');
			            $('#novo-nome-input').val('');
			            
			            return false;
					//}
				        
				});
				
				
				
				//Excluir
				$('#delete-row').click(function () {					
				        
			            var id = $('#inputIdExcluir').val(),
			                idClube = $('#id-clube-input').val();
			            
			            var params = "?idAtleta="+id+"&idClube="+idClube;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirAtletaJson'+params,			                
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
			            $('#inputIdExcluir').val('');
			            
			            return false;
										
				});
				
				$("#drop").dropzone({ 
					uploadMultiple: false,
					maxFiles: 1,
					addRemoveLinks: true,
					previewsContainer: "#botaoFoto", 				
					success: function(file, response){
		                alert(response.idFoto);
		            }

				});
				
				
				

			}); //fim ready
						
			function iniciarDelete(id, nome) {	
				
				$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">Excluir o(a) atleta "<b>'+nome+'</b>"?</div>');
				
				var id = $('#inputIdExcluir').val(id);
				return false;
				
		    }
			
			
			function gerarLinkPerfilAtleta(id, nome) {
				
				var idClube = $('#id-clube-input').val();
				
				return '<a title="Ver perfil" href="atleta?idAtleta='+id+'&idClube='+idClube+'">'+nome+'</a>';
		    }
			
			function gerarBotaoEditar(id, nome) {
				return '<div class="btn-group m-b-sm" style="height: 6px">'+
			                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span></button>'+
			                '<ul class="dropdown-menu" role="menu">'+
			                    '<li><a href="#" onclick="iniciarPerfilAtleta('+id+')">Ver profile</a></li>'+
			                    '<li><a data-toggle="modal" data-target="#modalDeleteAtleta" href="#" onclick="iniciarDelete('+
	                    		"'"+id+"','"+nome+"')"+
	                    		'">Excluir</a></li>'+
			                '</ul>'+
			            '</div>';
			}		
			
			
		</script>
	</content>
</body>
</html>