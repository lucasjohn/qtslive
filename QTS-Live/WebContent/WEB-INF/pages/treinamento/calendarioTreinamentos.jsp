<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS-Live | Treinamento</title>

<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/multiselect/css/multi-select.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet">


<style type="text/css">
	
	
	
</style>


</head>
<body>
	<input id="id-clube-input" type="hidden" name="idClube" value="${usuario.clube.id}">
	<input id="nome-categoria-input" type="hidden" name="idClube" value="${usuario.categoria.nome}">
	<div class="panel-body">
		<div class="row">
		
			<!-- COLUNA ESQUERA -->
         	<div class="col-md-8"> 
			
				<!-- CALENDÁRIO -->	
	            <div class="panel panel-white ui-sortable-handle">
	                <div class="panel-heading">
	                    <h3 class="panel-title">Calendário</h3>
	                    <div class="panel-control">
	                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-collapse" data-original-title="Expand/Collapse"><i class="icon-arrow-down"></i></a>
	                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-reload" data-original-title="Reload"><i class="icon-reload"></i></a>
				   <!--<a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-remove" data-original-title="Remove"><i class="icon-close"></i></a> -->
	                    </div>
	                </div>
	                <div class="panel-body">
	                    <div id="calendar"></div>
	                </div>
	            </div>
	            <!-- FIM CALENDÁRIO -->
               
            </div> 
			<!-- FIM COLUNA ESQUERA -->		
			
	 		<!-- COLUNA DIREITA -->
			<div class="col-md-4">
					
				<div class="panel panel-white" id="treino-panel-div">
                    <div class="panel-heading clearfix">
                        <h4 class="panel-title"><i class="fa fa-file-text-o"></i>&nbsp; Treino</h4>
                        <div class="panel-control">
                            <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-collapse" data-original-title="Expand/Collapse"><i class="icon-arrow-down"></i></a>
                            <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-reload" data-original-title="Reload"><i class="icon-reload"></i></a>
                            <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="" class="panel-remove" data-original-title="Remove"><i class="icon-close"></i></a>
                        </div>
                    </div>
                    <div class="panel-body">
                        <blockquote>
                       	   <div id="treino-div">
                       	   </div>                           
                        </blockquote>                       
                       
	               		<form id="editar-treino-form" action="treino" method="POST">
	               			<input id="id-clube-input-hidden" type="hidden" name="header.idClube" />
	               			<input id="id-categoria-input-hidden" type="hidden" name="header.categoria.id" />
	               			<input id="data-input-hidden" type="hidden" name="header.dataString" />
	               			<input id="id-periodo-hidden" type="hidden" name="header.periodo.id" /> 
	               			<input id="codigo-treino-input-hidden" type="hidden" name="header.codigoTreino" />
	               			<input id="id-evento-input-hidden" type="hidden" />		
	               			<div style="float: right;">
	               				<button style="padding-right: 10px;" title="Edita o treino." type="submit" class="btn btn-info"><i class="fa fa-edit"></i> Editar</button> 
	               				<button title="Exclui o treino da base de dados." type="button" class="btn btn-danger" id="excluir-treino-button"><i class="fa fa-trash"></i> Excluir</button>
	               			</div>
	               		</form>
	               		
                    </div>
                </div>
	                
			</div>
			
           <!-- FIM COLUNA DIREITA -->
           
		</div>  
		
		
		<!-- MODAL EXCLUIR TREINO -->
		<div style="display: none;" class="modal fade" id="excluir-treino-modal" tabindex="-1" role="dialog alert" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
		                <h4 class="modal-title" id="myModalLabel"><i class="fa fa-trash"></i> Excluir Treino</h4>
		            </div>
		            <div class="modal-body">
		                    <div id="msg-alerta-excluir-div"></div>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
		                <button type="submit" id="confirm-excluir-treino-button" class="btn btn-danger">Excluir</button>	                                                       
		            </div>
		        </div>
		    </div>
		</div>
       	<!-- MODAL EXCLUIR TREINO FIM -->
       	
       	   	
       	<!-- MODAL PLANEJAMENTO ATIVIDADES -->

		<div style="display: none; height: 650px;" class="modal fade" id="nova-atividade-wizard-modal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Planejamento de atividades</h4>
					</div>
					<div class="modal-body">

						<!-- HEADER -->
						<div class="row">
							
							<div class="col-sm-3"></div>
							
							<!-- DATA -->
							<div class="col-sm-3">
								<div class="form-group">
									<label for="data-input" class="control-label">Data</label>
									<input id="data-input" type="text"
										class="form-control date-picker" placeholder="DD/MM/AAAA"
										name="data"> <input id="data-hidden-input"
										type="hidden">
								</div>
							</div>

							<!-- PERÍODO -->
							<div class="col-sm-3">
								<div class="form-group">
									<label for="periodo-select">Período</label> <select
										class="js-states m-b-sm select2-hidden-accessible form-control"
										style="display: none; width: 100%" tabindex="-1"
										aria-hidden="true" name="periodo" id="periodo-select">
										<c:forEach items="${listaPeriodo}" var="p" varStatus="status">
											<option value="${p.id}">${p.nome}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="col-sm-3"></div>

						</div>
						<!-- FIM HEADER -->
						
						<!-- INPUT ATIVIDADES -->
						<div class="row well">

							<!-- GRUPO -->
							<div class="col-sm-3">
								<div class="form-group">
									<label for="grupo-select">Grupo</label> <select
										class="js-states m-b-sm select2-hidden-accessible form-control"
										tabindex="-1" style="display: none; width: 100%"
										aria-hidden="true" name="grupo" id="grupo-select">
										<c:forEach items="${listaGrupo}" var="g" varStatus="status">
											<option value="${g.id}">${g.nome}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<!-- LOCAL -->
							<div class="col-sm-4">
								<div class="form-group">
									<label for="local-select">Local</label>
									<div id="local-div">
										<select
											class="js-states m-b-sm select2-hidden-accessible form-control"
											style="display: none; width: 100%" aria-hidden="true"
											name="local" id="local-select">
											<c:forEach items="${listaLocalTreino}" var="l"
												varStatus="status">
												<option value="${l.id}">${l.nome}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>

							<!-- ATIVIDADE -->
							<div class="col-sm-5">
								<div class="form-group">
									<label for="atividades-select">Atividade</label> 
									<select class="js-states m-b-sm select2-hidden-accessible form-control" tabindex="-1" style="display: none; width: 100%" aria-hidden="true" name="atividade"
										id="atividades-select">
										<optgroup label="Treino Físico">
											<c:forEach items="${listaTipoTreinamentoFisico}" var="f"
												varStatus="status">
												<option tipo="1" value="${f.id}">${f.nome}</option>
											</c:forEach>
										</optgroup>
										<optgroup label="Treino Tático">
											<c:forEach items="${listaTipoTreinamentoTatico}" var="f"
												varStatus="status">
												<option tipo="2" value="${f.id}">${f.nome}</option>
											</c:forEach>
										</optgroup>
										<optgroup label="Treino Técnico">
											<c:forEach items="${listaTipoTreinamentoTecnico}" var="f"
												varStatus="status">
												<option tipo="3" value="${f.id}">${f.nome}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
							</div>
							
							<!-- OBSERVAÇÕES -->
							<div class="col-sm-10">
								<div class="form-group">
									<label for="data-input" class="control-label">Observações</label>
									<textarea id="obs-textarea" type="text"
										class="form-control" placeholder=""
										name="obs"></textarea> 
								</div>
							</div>
							
							<!-- BOTÃO ADICIONAR -->
							<div class="col-sm-2">
								<div class="form-group">
									<label for="local-wizard-select">&nbsp;</label>
									<div>
										<button id="add-atividade-button" class="btn btn-default"><span class="glyphicon glyphicon-save"></span> Adicionar</button>
									</div>
								</div>
							</div>
							
							

						</div>
						<!-- FIM INPUT ATIVIDADES -->
						
						<!-- TABELA ATIVIDADES -->
						<div class="row">
							<div class="col-sm-12">
								<div class="table-responsive">
									<div class="dataTables_wrapper" id="example-editable_wrapper">					
										<table id="atividades-grupo-table" class="display compact dataTable">
											<thead>
												<tr>								
													<th style="width: 9%">Grupo</th>
													<th style="width: 12%">Local</th>
													<th style="width: 22%">Atividade</th>
													<th style="width: 18%">Observações</th>
													<th style="width: 9%" align="center">Tempo</th>
													<th style="width: 9%" align="center">GPS</th>
													<th style="width: 9%" align="center">PSE </th>
													<th style="width: 9%" align="center">Freq. Card.</th>	
													<th style="width: 3%" align="center"> </th>							
												</tr>
											</thead>											
											<!--<tfoot>
												<tr>
													<th style="width: 10%">Grupo</th>
													<th style="width: 14%">Local</th>
													<th style="width: 25%">Atividade</th>
													<th style="width: 21%">Observações</th>
													<th style="width: 9%">Tempo</th>
													<th style="width: 9%">PSE</th>
													<th style="width: 9%">Freq. Card.</th>	
													<th style="width: 3%"> </th>																
												</tr>
											</tfoot> -->
											<tbody>
												
											</tbody>
										</table>				
									</div>
								</div>
							</div>
						</div>
						<!-- FIM TABELA ATIVIDADES -->



					</div>
                    <div class="modal-footer">
                    	<button title="Adiciona o evento no calendário." type="button" id="add-evento-button" class="btn btn-success"><i class="fa fa-save"></i> Salvar </button>
                    	<button title="Cria e edita o treino." type="submit" id="edita-evento-button" class="btn btn-success"><i class="fa fa-edit"></i> Salvar e editar </button>
                        <button title="Cancela." type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-close"></i> Fechar</button>
                    </div>
				</div>
			</div>
		</div>

		<!-- FIM MODAL PLANEJAMENTO ATIVIDADES -->
		      
    </div>


<content tag="local_script">				
	
	<!-- PLUGINS -->
	<script src="assets/plugins/datatables/js/jquery.datatables.min.js"></script>
	<script src="assets/plugins/datatables/js/dataTables.responsive.js"></script>
	<script src="assets/plugins/fullcalendar/lib/moment.min.js"></script>
    <script src="assets/plugins/fullcalendar/fullcalendar.min.js"></script>
    <script src="assets/plugins/fullcalendar/lang-all.js"></script>   
    <script src="assets/plugins/select2/js/select2.full.min.js"></script>
    <script src="assets/plugins/multiselect/js/jquery.multi-select.js"></script>
	<script src="assets/plugins/quicksearch/jquery.quicksearch.js"></script>
	<script src="assets/plugins/twitter-bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
	<script src="assets/plugins/jquery-validation/jquery.validate.js"></script>
	<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/plugins/toastr/toastr.min.js"></script>
	
	<!-- SCRIPTS DA PÁGINA -->
	<script src="assets/js/pages/calendario-treinamentos/scripts.js"></script>
	<script src="assets/js/pages/calendario-treinamentos/wizard.js"></script>
	<script src="assets/js/pages/calendario-treinamentos/calendario.js"></script>
	<script src="assets/js/pages/calendario-treinamentos/grupos.js"></script>
	<script src="assets/js/pages/calendario-treinamentos/atividades.js"></script>
	
	<script type="text/javascript">
		
		$(document).ready(function() {
	
		}); //Fim do ready

	</script>			

</content>
</body>
</html>