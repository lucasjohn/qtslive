<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | <s:text name="global.titulodominancias" /></title>
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
			<h4 class="panel-title"><s:text name="global.titulodominancias" /></h4>
		</div>
		<div class="panel-body">
			<button id="buttonNovaPosicao" type="button" class="btn btn-primary btn-addon m-b-sm" data-toggle="modal" data-target="#modalDominancia"> <s:text name="global.novadominancia" /> </button>
			<form id="add-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="modalDominancia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalnovadominancia" /></h4>
	                        </div>
	                        <div class="modal-body">	                                
                                <div class="form-group">
                                    <input id="novo-nome-input" class="form-control" placeholder='<s:text name="global.nomedominancia" />' required="" type="text">
                                    <input id="novo-id-clube-input" type="hidden" value="${usuario.clube.id}">	                                    
                                </div>
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelarnovadominancia" /></button>
	                            <button type="submit" id="add-row" class="btn btn-success"><s:text name="global.adicionarnovadominancia" /></button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>
            <form id="update-row-form" action="javascript:void(0);">
	            <div style="display: none;" class="modal fade" id="modalEditarDominancia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
	                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalalterardominancia" /></h4>
	                        </div>
	                        <div class="modal-body">
                        		<input id="id-input" type="hidden">	                                
                                <div class="form-group">
                                    <input id="nome-input" class="form-control" placeholder='<s:text name="global.nomedominancia" />' required="" type="text">	  
                                    <input type="hidden" id="id-clube-input" />                                  
                                </div>
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelaralterardominancia" /></button>
	                            <button type="submit" id="update-row" class="btn btn-success"><s:text name="global.adicionaralterardominancia" /></button>	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>	
            <div style="display: none;" class="modal fade" id="modalDeleteDominancia" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel"><s:text name="global.titulomodalexcluirdominancia" /></h4>
                        </div>
                        <div class="modal-body">
                                <div id="divMsgAlertaExcluir"></div>
                                <input id="msg-exclusao-input" type="hidden" value='<s:text name="global.textouxcluirdominancia" />'>
                                <input id="inputIdDominanciaExcluir" type="hidden">
                                <input id="id-clube-excluir-input" type="hidden">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="global.cancelarexcluirdominancia" /></button>
                            <button type="submit" id="delete-row" class="btn btn-danger"><s:text name="global.excluirdominancia" /></button>	                                                       
                        </div>
                    </div>
                </div>
            </div>					
			<div class="table-responsive">
				<div class="dataTables_wrapper" id="example-editable_wrapper">					
					<table id="tabelaDominancia" class="display compact dataTable">
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
							<c:forEach items="${listaDominancia}" var="dom" varStatus="status"> 
								<tr id="${dom.id}">									
									<td>${dom.nome}</td>
									<td>
										<div class="btn-group m-b-sm" style="height: 6px">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><s:text name="global.opcoesdominancia" /> <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a data-toggle="modal" data-target="#modalEditarDominancia" href="#" onclick="iniciarEdicaoDominancia('${dom.id}','${dom.idClube}','${dom.nome}')"><s:text name="global.opcaoeditardominancia" /></a></li>
                                                <li><a data-toggle="modal" data-target="#modalDeleteDominancia" href="#" onclick="iniciarDeleteDominancia('${dom.id}','${dom.idClube}','${dom.nome}')"><s:text name="global.opcaoexcluirdominancia" /></a></li>                                                
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
				var t = $('#tabelaDominancia').DataTable({
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
				
				$('#tabelaDominancia tbody').on( 'click', 'tr', function () {
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
			            
			            var params = "?dominancia.nome="+nome+"&dominancia.idClube="+idClube;
			            
			            //Envia a requisição
			            $.ajax({
			                type: "POST",
			                url: 'criarDominanciaJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	var id = data.dominancia.id;			                	
				                var nome = data.dominancia.nome;	
				                
				                //Adiciona a linha
			                	var rowIndex = $('#tabelaDominancia').dataTable().fnAddData([
												               				                nome,		               
												               				                gerarBotaoEditar(id, idClube, nome)
												               				              ]);
			                	
				                //Adiciona o id na linha
			                    var row = $('#tabelaDominancia').dataTable().fnGetNodes(rowIndex);
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
			            
			            var params = "?dominancia.nome="+nome+"&dominancia.idClube="+idClube+"&dominancia.id="+id;
			            
			            $.ajax({
			                type: "POST",
			                url: 'editarDominanciaJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                	var tr = $('#'+id).closest("tr");
				            	$(tr).find('td:eq(0)').html(nome);
				            	$(tr).find('td:eq(1)').html(gerarBotaoEditar(id, idClube, nome));
				            	 
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
				        
			            var id = $('#inputIdDominanciaExcluir').val(),
		                    idClube = $('#id-clube-excluir-input').val();			                
			            
			            var params = "?dominancia.id="+id+"&dominancia.idClube="+idClube;
			            
			            $.ajax({
			                type: "POST",
			                url: 'excluirDominanciaJson'+params,			                
			                dataType: 'json',
			                contentType: 'application/json',
			                success: function(data) {
			                	
			                }
			                
			            });
			            			            
			            
			            $('.modal').modal('hide');	
			            
			            $('#'+id).hide(1500, function() {
			            	var t = $("#tabelaDominancia").DataTable();
				            t.row( $('#'+id) ).remove().draw();
			            });
			            
			            //Limpar campos
			            $('#inputIdDominanciaExcluir').val('');
			            
			            return false;
										
				});
				
				
						    

			}); //fim ready
			
			function iniciarEdicaoDominancia(id, idClube, nome) {
				
				$('#id-input').val(id);				
	            $('#nome-input').val(nome);
	            $('#id-clube-input').val(idClube);
				return false;
		    }
			
			function iniciarDeleteDominancia(id, idClube, nome) {	
				
				//$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">Excluir a dominância "<b>'+nome+'</b>"?</div>');
				var msg = $('#msg-exclusao-input').val().replace("{0}", '<b>'+nome+'</b>');				
				$('#divMsgAlertaExcluir').html('<div class="alert alert-warning" role="alert">'+msg+'</div>');
				$('#inputIdDominanciaExcluir').val(id);
				$('#id-clube-excluir-input').val(idClube);
				return false;
				
		    }
			
			function gerarBotaoEditar(id, idClube, nome) {
				return '<div class="btn-group m-b-sm" style="height: 6px">'+
			                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Opções <span class="caret"></span></button>'+
			                '<ul class="dropdown-menu" role="menu">'+
			                    '<li><a data-toggle="modal" data-target="#modalEditarDominancia" href="#" onclick="iniciarEdicaoDominancia('+
			                    		"'"+id+"','"+idClube+"','"+nome+"')"+
			                    		'">Editar</a></li>'+
			                    '<li><a data-toggle="modal" data-target="#modalDeleteDominancia" href="#" onclick="iniciarDeleteDominancia('+
			                    "'"+id+"','"+idClube+"','"+nome+"')"+
	                    		'">Excluir</a></li>'+                                                
			                '</ul>'+
			            '</div>';
			}
			
			
			
			
		</script>
	</content>
</body>
</html>