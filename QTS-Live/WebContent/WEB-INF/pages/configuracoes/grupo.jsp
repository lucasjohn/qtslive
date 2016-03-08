<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Grupo</title>
<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.min.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/x-editable/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css">
<script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
<link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>
<body>
	
	<div class="panel panel-white">
		
		<div class="panel-heading clearfix">
			<h4 class="panel-title">Grupo</h4>
		</div>
		<div class="panel-body">
			<button id="novo-registro-button" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalNovoRegistro"> Novo Grupo </button>
			<form id="add-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="modalNovoRegistro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Adicionar Grupo</h4>
	                        </div>
	                        <div class="modal-body">	
<!-- 	                        	<div class="row"> -->
<!-- 	                        		<div class="col-sm-5"> -->
										<div class="form-group">
		                                    <input id="novo-nome-input" class="form-control" placeholder="Nome" required="" type="text">	 
		                                    <input id="novo-id-clube-input" type="hidden" value="${usuario.clube.id}">                                   
		                                </div>
<!-- 									</div> -->
<!-- 	                        	</div> -->
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	                            <button type="submit" id="add-row" class="btn btn-success">Adicionar</button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>
            <form id="update-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="editar-registro-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Alterar Grupo</h4>
	                        </div>
	                        <div class="modal-body">
<!--                         		<div class="row"> -->
<!-- 	                        		<div class="col-sm-5"> -->
										<div class="form-group">
		                                    <input id="nome-input" class="form-control" placeholder="Nome" required="" type="text">	 
		                                    <input id="id-clube-input" type="hidden" value="${usuario.clube.id}">
		                                    <input id="id-input" type="hidden" >                                   
		                                </div>
<!-- 									</div> -->
<!-- 	                        	</div> -->
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	                            <button type="submit" id="update-row" class="btn btn-success">Salvar</button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>	
            <div style="display: none;" class="modal fade" id="delete-registro-modal" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">Excluir Grupo</h4>
                        </div>
                        <div class="modal-body">
                                <div id="msg-alerta-excluir-div"></div>
                                <input id="id-excluir-input" type="hidden">
                                <input id="id-clube-excluir-input" type="hidden">
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
					<table id="registros-table" class="display compact dataTable">
						<thead>
							<tr>								
								<th>Nome</th>
								<th style="width: 25%">Opções</th>						
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Nome</th>
								<th>Opções</th>																
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${lista}" var="l" varStatus="status"> 
								<tr id="${l.id}">									
									<td>${l.nome}</td>
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a data-toggle="modal" data-target="#editar-registro-modal" href="#" onclick="iniciarEdicaoRegistro('${l.id}','${l.idClube}','${l.nome}')">Editar</a></li>
                                                <li><a data-toggle="modal" data-target="#delete-registro-modal" href="#" onclick="iniciarDeleteRegistro('${l.id}','${l.idClube}','${l.nome}')">Deletar</a></li>                                                
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
		<script src="assets/js/pages/table-data.js"></script>
		<script src="assets/plugins/select2/js/select2.min.js"></script>
		<script src="assets/js/pages/form-select2.js"></script>
		<script src="assets/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.pt-BR.js"></script>		
		<script src="assets/plugins/mask/jquery.mask.js"></script>
		<script src="assets/plugins/x-editable/bootstrap3-editable/js/bootstrap-editable.js"></script>	
		<script src="assets/plugins/toastr/toastr.min.js"></script>	

		<script>
		
			$(document).ready(function() {

				//Constroi a tabela.
				var t = $('#registros-table').DataTable({
					"responsive": true,
					"language": {
		                "url": "assets/plugins/datatables/Portuguese-Brasil.json"
		            }
				});
				
				$('#registros-table tbody').on( 'click', 'tr', function () {
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
					if($("#add-row-form").isValid()) {
			        
			            var	nome = $('#novo-nome-input').val(),
			                idClube = $('#novo-id-clube-input').val();
			            
			            var params = "?grupo.nome="+nome+"&grupo.idClube="+idClube;
			            
			            //Envia a requisição
			            $.ajax({
			                type: "POST",
			                url: 'criarGrupoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	var id = data.grupo.id;			                	
			                	var idClube = data.grupo.idClube;
				                var nome = data.grupo.nome;	
				                
				                //Adiciona a linha
			                	var rowIndex = $('#registros-table').dataTable().fnAddData([
												               				                nome,		               
												               				                gerarBotaoEditar(id, idClube, nome)
												               				              ]);
			                	
				                //Adiciona o id na linha
			                    var row = $('#registros-table').dataTable().fnGetNodes(rowIndex);
			                    $(row).attr('id', id);
			                    
			                    //Faz a animação de linha inserida
			                	$(row).effect("highlight", {color: "#7A6FBE"}, 3500);
			                    
			                	toastr["success"]("O Grupo "+nome+" foi criado com sucesso.");
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');
			            
			            //Limpar campos			            
			            $('#novo-nome-input').val('');
			            
			            return false;
					}
				        
				});
				
				//Editar
				$('#update-row').click(function () {					
					
					if($("#update-row-form").isValid()) {
				        
			            var nome = $('#nome-input').val(),
			                id =  $('#id-input').val(),
			                idClube =  $('#id-clube-input').val(),
			                descricao =  $('#descricao-textarea').val();
			            
			            var params = "?grupo.nome="+nome+"&grupo.idClube="+idClube+"&grupo.id="+id;
			            
			            $.ajax({
			                type: "POST",
			                url: 'editarGrupoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                	var tr = $('#'+id).closest("tr");
				            	$(tr).find('td:eq(0)').html(nome);
				            	$(tr).find('td:eq(1)').html(gerarBotaoEditar(id, idClube, nome, descricao));
				            	 
				            	$(tr).effect("highlight", {color: "#7A6FBE"}, 3500);
				            	
				            	toastr["success"]("O Grupo "+nome+" foi atualizado com sucesso.");
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
				        
			            var id = $('#id-excluir-input').val(),
			                idClube = $('#id-clube-excluir-input').val();
			            
			            var params = "?grupo.idClube="+idClube+"&grupo.id="+id;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirGrupoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	toastr["success"]("O Grupo foi excuído com sucesso.");
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');	
			            
			            $('#'+id).hide(1500, function() {
			            	var t = $("#registros-table").DataTable();
				            t.row( $('#'+id) ).remove().draw();
			            });
			            
			            //Limpar campos
			            $('#id-excluir-input').val('');
			            
			            return false;
										
				});
				
				
						    

			}); //fim ready
			
			function iniciarEdicaoRegistro(id, idClube, nome) {
				
				$('#id-input').val(id);				
	            $('#nome-input').val(nome);	            
	            $('#id-clube-input').val(idClube);
				return false;
		    }
			
			function iniciarDeleteRegistro(id, idClube, nome) {	
				
				$('#msg-alerta-excluir-div').html('<div class="alert alert-warning" role="alert">Excluir o Grupo "<b>'+nome+'</b>"?</div>');
				
				$('#id-excluir-input').val(id);
				$('#id-clube-excluir-input').val(idClube);
				return false;
				
		    }
			
			function gerarBotaoEditar(id, idClube, nome) {
				return '<div class="btn-group m-b-sm" style="height: 6px">'+
			                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span></button>'+
			                '<ul class="dropdown-menu" role="menu">'+
			                    '<li><a data-toggle="modal" data-target="#editar-registro-modal" href="#" onclick="iniciarEdicaoRegistro('+
			                    		"'"+id+"','"+idClube+"','"+nome+"')"+
			                    		'">Editar</a></li>'+
			                    '<li><a data-toggle="modal" data-target="#delete-registro-modal" href="#" onclick="iniciarDeleteRegistro('+
			                    "'"+id+"','"+idClube+"','"+nome+"')"+
	                    		'">Excluir</a></li>'+                                                
			                '</ul>'+
			            '</div>';
			}
			
			
			
			
		</script>
	</content>
</body>
</html>