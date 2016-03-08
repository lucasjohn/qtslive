$( document ).ready(function() {
	
	$('#atletas-wizard-my-select').multiSelect({
		selectableHeader : "<input type='text' class='search-input form-control' autocomplete='off' placeholder='Procurar'>",
		selectionHeader : "<input type='text' class='search-input form-control' autocomplete='off' placeholder='Procurar'>",
		afterInit : function(ms) {
			var that = this, 
			           $selectableSearch = that.$selectableUl.prev(), 
			           $selectionSearch = that.$selectionUl.prev(), selectableSearchString = '#'+ that.$container.attr('id')+ ' .ms-elem-selectable:not(.ms-selected)', selectionSearchString = '#'+ that.$container.attr('id')+ ' .ms-elem-selection.ms-selected';

			that.qs1 = $selectableSearch.quicksearch(selectableSearchString).on('keydown', function(e) {
								if (e.which === 40) {
									that.$selectableUl
											.focus();
									return false;
								}
							});

			that.qs2 = $selectionSearch.quicksearch(selectionSearchString).on('keydown',function(e) {
								if (e.which == 40) {
									that.$selectionUl
											.focus();
									return false;
								}
							});
		},
		afterSelect : function() {
			this.qs1.cache();
			this.qs2.cache();
		},
		afterDeselect : function() {
			this.qs1.cache();
			this.qs2.cache();
		}
	});
    
	//Inicializa os grupos
	$("#grupo-wizard-select option").each(function() {
		
		//A chave é o id do grupo
		grupos[$(this).val()] = new Object();
		
	});
	
	$('#atletas-wizard-my-select').on('change', function (e) {
		
		if(alterarGrupo == true) {
			
			var idsAtletas = [];
			
			$("#atletas-wizard-my-select :selected").each(function() {
				
				idsAtletas.push($(this).val());
				
			});
			
			var idGrupo = $('#grupo-wizard-select').val();
			
			grupos[idGrupo] = idsAtletas;
			
			atualizarOutrosGrupos(idGrupo, idsAtletas);
			
		} else {
			
			alterarGrupo = true;			
		}
		
		
		
	});
	
	
	$('#grupo-wizard-select').on('change', function (e) {
		
		var idGrupo = $(this).val();
		
		var idsAtletas = grupos[idGrupo];
		
		habilitarTodos();
		
		if(idsAtletas.length > 0) {
			
			deselectAllMultiSelect();
			
			//Marca os atletas do grupo como 'selecionados'.
			$.each( idsAtletas, function( index, value ) {
				
				$('#atletas-wizard-my-select option[value='+value+']').attr('selected','selected');
				
			})			
			
		} else {  
			
			deselectAllMultiSelect();
			
		}
		
		desabilitaAtletasOutrosGrupos(idGrupo);
		
		refreshMultiSelect();
		
	});

	
    
    
}); //Fim do ready


function refreshMultiSelect() {
	alterarGrupo = false;
	$('#atletas-wizard-my-select').multiSelect('refresh');
	alterarGrupo = true;
}

function deselectAllMultiSelect() {
	alterarGrupo = false;
	$('#atletas-wizard-my-select').multiSelect('deselect_all');
	alterarGrupo = true;
}

/**
 * 
 * Atualiza os outros grupos. Caso os outros grupos já tenham o atleta aicionado, a função retira do outro grupo.
 * 
 * @param idGrupo - código do grupo que o atleta foi adicionado.
 * @param idsAtletas - lista de atletas do grupo que teve o atleta adicionado.
 * 
 */
function atualizarOutrosGrupos(idGrupo, idsAtletas) {
	
	//Para cada grupo
	$.each( grupos, function( id, atletas ) {
		
		if(id != idGrupo) {
			
			//Para cada atleta do grupo
			$.each( atletas, function( index, value ) {
				
				//Para cada atleta do outro grupo
				$.each( idsAtletas, function( i, v ) {
					
					//Retira do outro grupo
					if(value == v) {
						atletas.splice( $.inArray(i, atletas), 1 );
					}
					
				})
				
			})
			
		}
		
	})
	
}


/**
 * 
 * Marca como desabilitado os atletas de outros grupos.
 * 
 * @param idGrupo - id do grupo
 * 
 */
function desabilitaAtletasOutrosGrupos(idGrupo) {
	
	//Para cada grupo
	$.each( grupos, function( id, atletas ) {
		
		if(id != idGrupo) {
			
			//Para cada atleta do grupo
			$.each( atletas, function( index, idAtleta ) {
								
				$("#atletas-wizard-my-select option[value=" + idAtleta + "]").attr("disabled", "disabled");
				
			})
			
		}
		
	})
	
}


/**
 * 
 * Marca como desabilitado os atletas de outros grupos.
 * 
 */
function habilitarTodos() {
	
	//Para cada elemento da lista de atletas
	$("#atletas-wizard-my-select option").each(function() {
		
		//Habilita
		$(this).removeAttr("disabled");
		
	});
	
}


var alterarGrupo = true;

var grupos = new Object();
//map[myKey1] = myObj1;
