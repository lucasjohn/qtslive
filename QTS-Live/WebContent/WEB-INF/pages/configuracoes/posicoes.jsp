<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Posições</title>
<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.min.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/x-editable/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css">
<script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
</head>
<body>
	
	<div class="panel panel-white">
		
		<div class="panel-heading clearfix">
			<h4 class="panel-title">Posições</h4>
		</div>
		<div class="panel-body">
			<button id="buttonNovaPosicao" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalPosicao"> Nova Posição </button>
			<form id="add-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="modalPosicao" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Adicionar Posição</h4>
	                        </div>
	                        <div class="modal-body">
	                                <div class="form-group">
	                                    <input id="nova-sigla-input" class="form-control limite-sigla" placeholder="Sigla" required="" type="text">
	                                </div>
	                                <div class="form-group">
	                                    <input id="novo-nome-input" class="form-control" placeholder="Nome" required="" type="text">	                                    
	                                </div>
	                                <input id="novo-id-clube-input" type="hidden" value="${usuario.clube.id}">	
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
	            <div style="display: none;" class="modal fade" id="modalEditarPosicao" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel">Alterar Posição</h4>
	                        </div>
	                        <div class="modal-body">
	                        		<input id="id-input" type="hidden">
	                                <div class="form-group">
	                                    <input id="sigla-input" class="form-control limite-sigla" placeholder="Sigla" required="" type="text">
	                                </div>
	                                <div class="form-group">
	                                    <input id="nome-input" class="form-control" placeholder="Nome" required="" type="text">	                                    
	                                </div>
	                                <input type="hidden" id="id-clube-input" /> 
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	                            <button type="submit" id="update-row" class="btn btn-success">Salvar</button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>	
            <div style="display: none;" class="modal fade" id="modalDeletePosicao" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">Excluir Posição</h4>
                        </div>
                        <div class="modal-body">
                                <div id="divMsgAlertaExcluir"></div>
                                <input id="inputIdPosicaoExcluir" type="hidden">
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
					<table id="tabelaPosicoes" class="display compact dataTable">
						<thead>
							<tr>
								<th style="width: 10%">Sigla</th>
								<th>Nome</th>
								<th>Opções</th>						
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Sigla</th>
								<th>Nome</th>
								<th>Opções</th>																
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${listaPosicoes}" var="pos" varStatus="status"> 
								<tr id="${pos.id}">
									<td>${pos.sigla}</td>
									<td>${pos.nome}</td>
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a data-toggle="modal" data-target="#modalEditarPosicao" href="#" onclick="iniciarEdicaoPosicao('${pos.id}','${pos.idClube}','${pos.sigla}','${pos.nome}')">Editar</a></li>
                                                <li><a data-toggle="modal" data-target="#modalDeletePosicao" href="#" onclick="iniciarDeletePosicao('${pos.id}','${pos.idClube}','${pos.sigla}','${pos.nome}')">Deletar</a></li>                                                
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

		<script>
		
			$(document).ready(function() {
				
				$('.limite-sigla').mask('AAA');

				//Constroi a tabela.
				var t = $('#tabelaPosicoes').DataTable({
					"responsive": true,
					"language": {
		                "url": "assets/plugins/datatables/Portuguese-Brasil.json"
		            }
				});
				
				$('#tabelaPosicoes tbody').on( 'click', 'tr', function () {
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
			        
			            var	sigla = $('#nova-sigla-input').val(),
			                nome = $('#novo-nome-input').val(),
		                	idClube = $('#novo-id-clube-input').val();
			            
			            var params = "?posicao.sigla="+sigla+"&posicao.nome="+nome+"&posicao.idClube="+idClube;
			            
			            //Envia a requisição
			            $.ajax({
			                type: "POST",
			                url: 'criarPosicaoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	var id = data.posicao.id;
			                	var sigla = data.posicao.sigla;
				                var nome = data.posicao.nome;	
				                
				                //Adiciona a linha
			                	var rowIndex = $('#tabelaPosicoes').dataTable().fnAddData([
													                						sigla,
												               				                nome,		               
												               				                gerarBotaoEditar(id, idClube, sigla, nome)
												               				              ]);
			                	
				                //Adiciona o id na linha
			                    var row = $('#tabelaPosicoes').dataTable().fnGetNodes(rowIndex);
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
					}
				        
				});
				
				//Editar
				$('#update-row').click(function () {					
					
					if($("#update-row-form").isValid()) {
				        
			            var sigla = $('#sigla-input').val(),
			                nome = $('#nome-input').val(),
			                id =  $('#id-input').val(),
			                idClube =  $('#id-clube-input').val();
			            
			            var params = "?posicao.id="+id+"&posicao.sigla="+sigla+"&posicao.nome="+nome+"&posicao.idClube="+idClube;
			            
			            $.ajax({
			                type: "POST",
			                url: 'editarPosicaoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                	var tr = $('#'+id).closest("tr");			            
				            	$(tr).find('td:eq(0)').html(sigla);
				            	$(tr).find('td:eq(1)').html(nome);
				            	$(tr).find('td:eq(2)').html(gerarBotaoEditar(id, sigla, nome));
				            	 
				            	$(tr).effect("highlight", {color: "#7A6FBE"}, 3500);
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');
			            
			            //Limpar campos
			            $('#id-input').val('');
			            $('#sigla-input').val('');
			            $('#nome-input').val('');
			            
			            return false;
					}
					
				});
				
				//Excluir
				$('#delete-row').click(function () {					
				        
			            var id = $('#inputIdPosicaoExcluir').val(),
	                    	idClube = $('#id-clube-excluir-input').val();		                
			            
			            var params = "?posicao.id="+id+"&posicao.idClube="+idClube;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirPosicaoJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');	
			            
			            $('#'+id).hide(1500, function() {
			            	var t = $("#tabelaPosicoes").DataTable();
				            t.row( $('#'+id) ).remove().draw();
			            });
			            
			            //Limpar campos
			            $('#inputIdPosicaoExcluir').val('');
			            $('#id-clube-excluir-input').val('');
			            
			            return false;
										
				});
				
				
						    

			}); //fim ready
			
			function iniciarEdicaoPosicao(id, idClube, sigla, nome) {	
				
				$('#id-input').val(id);
				$('#sigla-input').val(sigla);
	            $('#nome-input').val(nome);
	            $('#id-clube-input').val(idClube);
				return false;
				
		    }
			
			function iniciarDeletePosicao(id, idClube, sigla, nome) {	
				
				$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">Excluir a posição "<b>'+sigla+' - '+nome+'</b>"?</div>');
				$('#inputIdPosicaoExcluir').val(id);
				$('#id-clube-excluir-input').val(idClube);
				return false;
				
		    }
			
			function gerarBotaoEditar(id, idClube, sigla, nome) {
				return '<div class="btn-group m-b-sm" style="height: 6px">'+
			                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span></button>'+
			                '<ul class="dropdown-menu" role="menu">'+
			                    '<li><a data-toggle="modal" data-target="#modalEditarPosicao" href="#" onclick="iniciarEdicaoPosicao('+
			                    		"'"+id+"','"+idClube+"','"+sigla+"','"+nome+"')"+
			                    		'">Editar</a></li>'+
			                    '<li><a data-toggle="modal" data-target="#modalDeletePosicao" href="#" onclick="iniciarDeletePosicao('+
	                    		"'"+id+"','"+idClube+"','"+sigla+"','"+nome+"')"+
	                    		'">Excluir</a></li>'+                                                
			                '</ul>'+
			            '</div>';
			}
			
			
			
			
		</script>
	</content>
</body>
</html>