<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS-Live | Novo Treino</title>

<link href="assets/plugins/datatables/css/jquery.datatables.min.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/datatables/css/dataTables.responsive.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/select2/css/select2.css" rel="stylesheet">
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/bootstrap-colorpicker/css/colorpicker.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/multiselect/css/multi-select.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/x-editable/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/x-editable/inputs-ext/typeaheadjs/lib/typeahead.js-bootstrap.css" rel="stylesheet" type="text/css">
<link href="assets/plugins/x-editable/inputs-ext/address/address.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.verticalLine {
    	border-right: 1px solid #ddd;
	}
</style>

</head>
<body>
	
		<div class="panel panel-white">	        
	        <div class="panel-body">
	        	
	        	<select class="js-states m-b-sm select2-hidden-accessible form-control" tabindex="-1" style="display: none; width: 100%" aria-hidden="true" id="dor-select">
					<option value="0"> -- Selecione -- </option>
					<c:forEach items="${listaLocalDor}" var="a" varStatus="status"> 
						<option value="${a.id}">${a.nome}</option>
					</c:forEach>
				</select>
				
				<select class="js-states m-b-sm select2-hidden-accessible form-control" tabindex="-1" style="display: none; width: 100%" aria-hidden="true" name="grupo" id="grupo-hidden-select">	
				    <c:forEach items="${listaGrupo}" var="g" varStatus="status"> 
						<option value="${g.id}">${g.nome}</option>
				   	</c:forEach>																					
				</select>
				
				<select style="display: none;" id="local-hidden-select">
					<c:forEach items="${listaLocalTreino}" var="l" varStatus="status">
						<option value="${l.id}">${l.nome}</option>
					</c:forEach>												
				</select>
	            
	            <select style="display: none;" id="periodo-hidden-select">
					<c:forEach items="${listaPeriodo}" var="p" varStatus="status">
						<option value="${p.id}">${p.nome}</option>
					</c:forEach>												
				</select>
	            				
				<!-- ABAS -->
				<div role="tabpanel">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                    	<c:forEach items="${listaTreino}" var="treino" varStatus="i">
                    		<c:if test="${idPeriodo == treino.periodo.id}">
                    			<li role="presentation" class="active">
                    				<a href="<c:url value="#aba${treino.periodo.id * 10 + i.index}"/>" role="tab" data-toggle="tab" aria-expanded="true">${treino.periodo.nome}</a>
                    			</li>
                    		</c:if>
                    		<c:if test="${idPeriodo != treino.periodo.id}">
                    			<li role="presentation" class=""      >
                    				<a href="<c:url value="#aba${treino.periodo.id * 10 + i.index}"/>" role="tab" data-toggle="tab" aria-expanded="true">${treino.periodo.nome}</a>
                    			</li>
                    		</c:if>
						</c:forEach>
                        
                    </ul>
                    <!-- Tab panes -->
                    <div id="abas-tabelas-div" class="tab-content">    
                                        	
                    	<c:forEach items="${listaTreino}" var="treino" varStatus="i">
                    	                    		
                    		<!-- ABA -->
                    		<c:if test="${idPeriodo == treino.periodo.id}">
                    			<div role="tabpanel" class="tab-pane fade active in" id="aba${treino.periodo.id * 10 + i.index}">
                    		</c:if>
                    		<c:if test="${idPeriodo != treino.periodo.id}">
                    			<div role="tabpanel" class="tab-pane fade " id="aba${treino.periodo.id * 10 + i.index}">
                    		</c:if>   
                    			
                    			<!-- HEADER -->
					            <div id="cabecalho-div" class="row">
									
									<!-- LOCAL -->
									<div class="col-sm-2">
										<div class="form-group">											
											Local: <a href="#" id="x-local-link" data-type="select2" data-pk="1" data-value="BS" data-title="Alterar local" class="editable editable-click x-local-link">${treino.localTreino.nome}</a>											
										</div>
									</div>
									
									<!-- DATA -->
									<div class="col-sm-2">
										<div class="form-group">
											Data: <a href="#" id="x-data-link" data-type="combodate" data-value="${treino.dataString }" data-format="DD-MM-YYYY" data-viewformat="DD/MM/YYYY" data-template="DD / MM / YYYY" data-pk="1" data-title="Alterar data" class="editable editable-click x-data-link" style="display: inline;">${treino.dataString }</a>
										</div>						
									</div>
									
									<!-- PERÍODO -->
									<div class="col-sm-2">
										<div class="form-group">
											Período: <a href="#" id="x-periodo-link" data-type="select2" data-pk="1" data-value="BS" data-title="Alterar período" class="editable editable-click x-periodo-link">${treino.periodo.nome}</a>
										</div>
									</div>
									
									<!-- PSE ESPERADO -->
									<div class="col-sm-2">									
										<div class="form-group">
											PSE esperado: <a href="#" id="x-pse-link" class="editable editable-click editable-open x-pse-link" style="display: inline;" aria-describedby="popover414135">${treino.pseEsperado}</a>
										</div>
									</div>
									
									
								</div>
								<!-- <hr id="cabecalho-hr">  --> 
								
								<!-- FIM HEADER -->                               		
	                        
	                            <!-- TABELA -->							
								<div class="table-responsive">
									<div class="dataTables_wrapper" id="example-editable_wrapper">					
										<table id="${treino.periodo.id * 10 + i.index}-table" class="display compact dataTable">
											<thead>
												<tr>								
													<th style="width: 80px;">Atleta</th>
													<th style="width: 30px;">Grupo</th>
													<th style="width: 250px;">Atividades</th>
													<th style="width: 15px;">GPS (Km)</th>
													<th style="width: 10px;">Especial</th>
													<th style="width: 10px;">FAD</th>
													<th style="width: 10px;">DMT</th>
													<th style="width: 10px;">PSE</th>		
													<th style="width: 30px;">Local da Dor</th>														
												</tr>
											</thead>
											<tfoot>
												<tr>
													<th>Atleta</th>
													<th>Grupo</th>
													<th>Atividades</th>
													<th>GPS (Km)</th>
													<th>Especial</th>
													<th>FAD</th>
													<th>DMT</th>
													<th>PSE</th>
													<th>Local da Dor</th>																
												</tr>
											</tfoot>
											<tbody>
												<c:forEach items="${treino.listaGrupoAtletas}" var="grupo" varStatus="status">
													<c:forEach items="${grupo.listaAtletaAtividades}" var="atleta" varStatus="status">
														<tr id="${atleta.atleta.id}">
															<td>${atleta.atleta.nome} <c:if test="${not empty atleta.atleta.apelido}">(${atleta.atleta.apelido})</c:if></td>
															<td>
																<a href="#" id="x-grupo-link" data-type="select2" data-pk="1" data-value="BS" data-title="Alterar grupo" class="editable editable-click x-grupo-link">${atleta.grupo.nome}</a>
															</td>
															<td>Aceleração [25], CORE [20]</td>
															<td style="text-align: center;">
																8
															</td>
															<td></td>
															<td style="text-align: center;">
																<a href="#" id="username" class="editable editable-click editable-open x-fad-link" style="display: inline;" aria-describedby="popover414135"></a>
															</td>
															<td style="text-align: center;">
																<a href="#" id="username" class="editable editable-click editable-open x-dmt-link" style="display: inline;" aria-describedby="popover414135"></a>
															</td>
															<td style="text-align: center;">
																<a href="#" id="username" class="editable editable-click editable-open x-pse-link" style="display: inline;" aria-describedby="popover414135"></a>
															</td>
															<td style="text-align: center;">
																<a href="#" id="x-dor-link" data-type="select2" class="editable editable-click x-dor-link"></a>
															</td>
														</tr>
													</c:forEach>
											   	</c:forEach>			
											</tbody>
										</table>				
									</div>
								</div>								
								<!-- FIM TABELA -->
	                               
	                        </div>
	                        <!-- FIM ABA -->
						</c:forEach>
                    	
                                                
                    </div>
                </div>
				<!-- FIM ABAS -->
				
				
				
				
				
				
				
	        </div>
	    </div>
		
		    
   


<content tag="local_script">				
	
	<script src="assets/plugins/jquery-mockjax-master/jquery.mockjax.js"></script>
	<script src="assets/plugins/datatables/js/jquery.datatables.min.js"></script>
	<script src="assets/plugins/datatables/js/dataTables.responsive.js"></script>
	<script src="assets/plugins/moment/moment.js"></script>
	<script src="assets/plugins/x-editable/bootstrap3-editable/js/bootstrap-editable.js"></script>
	<script src="assets/plugins/x-editable/inputs-ext/typeaheadjs/lib/typeahead.js"></script>
	<script src="assets/plugins/x-editable/inputs-ext/typeaheadjs/typeaheadjs.js"></script>
	<script src="assets/plugins/x-editable/inputs-ext/address/address.js"></script>
	<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>		
<!-- 		<script src="assets/js/pages/table-data.js"></script> -->
<!-- 	<script src="assets/plugins/select2/js/select2.min.js"></script> -->
	<script src="assets/plugins/select2/js/select2.full.min.js"></script>
<!-- 	<script src="assets/js/pages/form-select2.js"></script> -->
	<script src="assets/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.pt-BR.js"></script>		
	<script src="assets/plugins/mask/jquery.mask.js"></script>
	<script src="assets/plugins/multiselect/js/jquery.multi-select.js"></script>
	<script src="assets/plugins/quicksearch/jquery.quicksearch.js"></script>
	
	<!-- Scripts -->
	<script src="assets/js/pages/treinamentos/data-tables.js"></script>
	<script src="assets/js/pages/treinamentos/editable-table.js"></script>	
	<script src="assets/js/pages/treinamentos/scripts.js"></script>
	
	<script type="text/javascript">
	
		
		
		$(document).ready(function() {
			   
		    
		   
		    $('#add-atividade-grupo-button').click(function () {
		    	
		    	var idAtividade = $('#atividades-grupo-select').val(),
		    	    descAtividade = $('#atividades-grupo-select option:selected').text(),
		    	    duracao = $('#duracao-atividade-input').val();
		    	
		    	//Adiciona a linha
            	var rowIndex = $('#atividades-grupo-table').dataTable().fnAddData([
								               				                descAtividade,		               
								               				                duracao + ' min',
								               				                '<a id="remove-atividade-grupo-link" onclick="removerLinhaAtividadeGrupo('+idAtividade+');"><i class="fa fa-close"></i></a>'
								               				              ]);
            	
                //Adiciona o id na linha
                var row = $('#atividades-grupo-table').dataTable().fnGetNodes(rowIndex);
                $(row).attr('id', 'atividade'+idAtividade);
                
                //Faz a animação de linha inserida
            	//$(row).effect("highlight", {color: "#7A6FBE"}, 3500);
		    	
		    });
		    
		    			

		}); //Fim do onload
		
		
		
		function removerLinhaAtividadeGrupo(id) {
			
			var t = $("#atividades-grupo-table").DataTable();
            t.row( $('#atividade'+id) ).remove().draw();
			
			return false;
		}

		
	</script>			

</content>
</body>
</html>