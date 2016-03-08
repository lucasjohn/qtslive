<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | <s:text name="global.titulocategorias"/></title>
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
			<h4 class="panel-title"><s:text name="global.titulocategorias" /></h4>
		</div>
		<div class="panel-body">
			<button id="buttonNovaPosicao" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalNovoRegistro"> <s:text name="global.novacategoria" /> </button>
			<form id="add-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="modalNovoRegistro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalnovacategoria" /></h4>
	                        </div>
	                        <div class="modal-body">	                                
                                <div class="form-group">
                                    <input id="novo-nome-input" class="form-control" placeholder='<s:text name="global.placeholdernovacategoria" />' required="" type="text">	 
                                    <input id="novo-id-clube-input" type="hidden" value="${usuario.clube.id}">                                   
                                </div>
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelarnovacategoria" /></button>
	                            <button type="submit" id="add-row" class="btn btn-success"><s:text name="global.adicionarnovacategoria" /></button>	                            
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
	                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalalterarcategoria" /></h4>
	                        </div>
	                        <div class="modal-body">
                        		<input id="id-input" type="hidden">	                                
                                <div class="form-group">
                                    <input id="nome-input" class="form-control" placeholder="Nome" required="" type="text">	
                                    <input type="hidden" id="id-clube-input" />                                    
                                </div>
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelaralterarcategoria"  /></button>
	                            <button type="submit" id="update-row" class="btn btn-success"><s:text name="global.adicionaralterarcategoria" /></button>	                            
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
                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalexcluircategoria"  /></h4>
                        </div>
                        <div class="modal-body">
                                <div id="msg-alerta-excluir-div"></div>
                                <input id="msg-exclusao-input" type="hidden" value='<s:text name="global.textouxcluircategoria" />'>
                                <input id="id-excluir-input" type="hidden">
                                <input id="id-clube-excluir-input" type="hidden">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelarexcluircategoria"  /></button>
                            <button type="submit" id="delete-row" class="btn btn-danger"><s:text name="global.excluircategoria"  /></button>	                                                       
                        </div>
                    </div>
                </div>
            </div>					
			<div class="table-responsive">
				<div class="dataTables_wrapper" id="example-editable_wrapper">					
					<table id="tabelaRegistros" class="display compact dataTable">
						<thead>
							<tr>								
								<th><s:text name="global.nomecategoria" /></th>
								<th style="width: 25%"><s:text name="global.opcoescategoria" /></th>						
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th><s:text name="global.nomecategoria" /></th>
								<th><s:text name="global.opcoescategoria" /></th>																
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${lista}" var="l" varStatus="status"> 
								<tr id="${l.id}">									
									<td>${l.nome}</td>
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><s:text name="global.opcoescategoria" /> <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a data-toggle="modal" data-target="#editar-registro-modal" href="#" onclick="iniciarEdicaoRegistro('${l.id}','${l.idClube}','${l.nome}')"><s:text name="global.opcaoeditarcategoria" /></a></li>
                                                <li><a data-toggle="modal" data-target="#delete-registro-modal" href="#" onclick="iniciarDeleteRegistro('${l.id}','${l.idClube}','${l.nome}')"><s:text name="global.opcaoexcluircategoria" /></a></li>                                                
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
	
	<input id="idioma-input" type="hidden" value="${idioma}">
	
	<input id="sEmptyTable-input" type="hidden" value='<s:text name="global.sEmptyTable" />'>
	<input id="sInfo-input" type="hidden" value='<s:text name="global.sInfo" />'>
	<input id="sInfoEmpty-input" type="hidden" value='<s:text name="global.sInfoEmpty" />'>
	<input id="sInfoFiltered-input" type="hidden" value='<s:text name="global.sInfoFiltered" />'>
	<input id="sInfoThousands-input" type="hidden" value='<s:text name="global.sInfoThousands" />'>
	<input id="sLengthMenu-input" type="hidden" value='<s:text name="global.sLengthMenu" />'>
	<input id="sLoadingRecords-input" type="hidden" value='<s:text name="global.sLoadingRecords" />'>
	<input id="sProcessing-input" type="hidden" value='<s:text name="global.sProcessing" />'>
	<input id="sZeroRecords-input" type="hidden" value='<s:text name="global.sZeroRecords" />'>
	<input id="sSearch-input" type="hidden" value='<s:text name="global.sSearch" />'>
	<input id="sNext-input" type="hidden" value='<s:text name="global.sNext" />'>
	<input id="sPrevious-input" type="hidden" value='<s:text name="global.sPrevious" />'>
	<input id="sFirst-input" type="hidden" value='<s:text name="global.sFirst" />'>
	<input id="sLast-input" type="hidden" value='<s:text name="global.sLast" />'>
	<input id="sSortAscending-input" type="hidden" value='<s:text name="global.sSortAscending" />'>
	<input id="sSortDescending-input" type="hidden" value='<s:text name="global.sSortDescending" />'>
	
	
	
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
				

				var sEmptyTable = $("#sEmptyTable-input").val(); 
				var sInfo = $("#sInfo-input").val();                           
				var sInfoEmpty = $("#sInfoEmpty-input").val();                           
				var sInfoFiltered = $("#sInfoFiltered-input").val();                      
				var sInfoThousands = $("#sInfoThousands-input").val();                                                   
				var sLengthMenu = $("#sLengthMenu-input").val();                        
				var sLoadingRecords = $("#sLoadingRecords-input").val();                           
				var sProcessing = $("#sProcessing-input").val();                       
				var sZeroRecords = $("#sZeroRecords-input").val();                           
				var sSearch = $("#sSearch-input").val();                          
				var sNext = $("#sNext-input").val();                               
				var sPrevious = $("#sPrevious-input").val();                                 
				var sFirst = $("#sFirst-input").val();                             
				var sLast = $("#sLast-input").val();                                
				var sSortAscending = $("#sSortAscending-input").val();                                 
				var sSortDescending = $("#sSortDescending-input").val();  

				//Constroi a tabela.
				var t = $('#tabelaRegistros').DataTable({
					"responsive": true,
					"language": {
				        processing:     sProcessing,
				        search:         sSearch,
				        lengthMenu:     sLengthMenu,
				        info:           sInfo,
				        infoEmpty:      sInfoEmpty,
				        infoFiltered:   sInfoFiltered,
				        infoPostFix:    "",
				        loadingRecords: sLoadingRecords,
				        zeroRecords:    sZeroRecords,
				        emptyTable:     sEmptyTable,
				        paginate: {
				            first:      sFirst,
				            previous:   sPrevious,
				            next:       sNext,
				            last:       sLast
				        },
				        aria: {
				            sortAscending:  sSortAscending,
				            sortDescending: sSortDescending
				        }
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
				
				//Adicionar				
				$('#add-row').click(function () {
					
					//Se o formulário está preenchido ok.
					if($("#add-row-form").isValid()) {
			        
			            var	nome = $('#novo-nome-input').val(),
			                idClube = $('#novo-id-clube-input').val();
			            
			            
			            var params = "?categoria.nome="+nome+"&categoria.idClube="+idClube;
			            
			            //Envia a requisição
			            $.ajax({
			                type: "POST",
			                url: 'criarCategoriaJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	var id = data.categoria.id;			                	
			                	var idClube = data.categoria.idClube;
				                var nome = data.categoria.nome;	
				                
				                //Adiciona a linha
			                	var rowIndex = $('#tabelaRegistros').dataTable().fnAddData([
												               				                nome,		               
												               				                gerarBotaoEditar(id, idClube, nome)
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
			            $('#novo-nome-input').val('');
			            
			            return false;
					}
				        
				});
				
				//Editar
				$('#update-row').click(function () {					
					
					if($("#update-row-form").isValid()) {
				        
			            var nome = $('#nome-input').val(),
			                id =  $('#id-input').val(),
			                idClube =  $('#id-clube-input').val();
			            
			            var params = "?categoria.nome="+nome+"&categoria.idClube="+idClube+"&categoria.id="+id;
			            
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
				        
			            var id = $('#id-excluir-input').val(),
			                idClube = $('#id-clube-excluir-input').val();
			            
			            var params = "?categoria.idClube="+idClube+"&categoria.id="+id;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirCategoriaJson'+params,			                
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
				
				//$('#msg-alerta-excluir-div').html('<div class="alert alert-warning" role="alert">Excluir a categoria "<b>'+nome+'</b>"?</div>');				
				var msg = $('#msg-exclusao-input').val().replace("{0}", '<b>'+nome+'</b>');				
				$('#msg-alerta-excluir-div').html('<div class="alert alert-warning" role="alert">'+msg+'</div>');
				
				
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