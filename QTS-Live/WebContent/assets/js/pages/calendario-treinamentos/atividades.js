/*********************************************************************/
/*****************                                     ***************/
/****************  JavaScript para a aba de atividades  **************/
/*****************                                     ***************/
/*********************************************************************/



$( document ).ready(function() {
    
	
	//Constroi a tabela.
	var t = $('#atividades-grupo-table').DataTable({
		
		"responsive": true,
		"paging":   false,
        "ordering": true,
        "order": [],
        "info":     false,	
        "bFilter":  false,
        "dom": '<"toolbar">frtip',
        "iDisplayLength": 100,
		"language": {
            "url": "assets/plugins/datatables/Portuguese-Brasil.json"
        }/*,
        "columnDefs": [                      
                       {
                           "targets": [ 2 ],
                           "visible": false
                       }
                     ]*/
	});
	
	$('#atividades-grupo-table tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            t.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    
	$('#add-atividade-button').click(function () {
	    	
		var idGrupo = $('#grupo-select option:selected').val(),
		    descGrupo = $('#grupo-select option:selected').text(),	
		    idLocal = $('#local-select option:selected').val(),
		    descLocal = $('#local-select option:selected').text(),
			idAtividade = $('#atividades-select').val(),		
			tipoAtividade = $('#atividades-select option:selected').attr('tipo'),
		    descAtividade = $('#atividades-select option:selected').text(),
		    obs = $("#obs-textarea").val();
		
		//Adiciona a linha
      	var rowIndex = $('#atividades-grupo-table').dataTable().fnAddData([
		               				                descGrupo,
		               				                descLocal,
		               				                descAtividade,
		               				                obs,		               				                
		               				                '<input class="checkbox" type="checkbox">',
		               				                '<input class="checkbox" type="checkbox">',
		               				                '<input class="checkbox" type="checkbox">',
		               				                '<input class="checkbox" type="checkbox">',
		               				                '<a id="remove-atividade-grupo-link" onclick="removerLinhaAtividadeGrupo('+idAtividade+');"><i class="fa fa-close"></i></a>'
		               				              ]);
      	
	    //Adiciona o id na linha
	    var row = $('#atividades-grupo-table').dataTable().fnGetNodes(rowIndex);
	    $(row).attr('id', 'atividade'+idAtividade);
	    
	    $(row).attr('idGrupo', idGrupo);
	    $(row).attr('nomeGrupo', descGrupo);
	    $(row).attr('idLocal', idLocal);
	    $(row).attr('nomeLocal', descLocal);
	    $(row).attr('tipo', tipoAtividade);
	    $(row).attr('idAtividade', idAtividade);
	    $(row).attr('nomeAtividade', descAtividade);	    
	    $(row).attr('observacoes', obs);
	    $(row).attr('title', obs);
	      
	    //Faz a animação de linha inserida
	    $(row).effect("highlight", {color: "#7A6FBE"}, 3500);
	    
	    //Limpa os campos duração e observações	    
	    $("#obs-textarea").val("");
		
	});
	
    
    
}); //Fim do ready


function removerLinhaAtividadeGrupo(id) {
	
	var t = $("#atividades-grupo-table").DataTable();
    t.row( $('#atividade'+id) ).remove().draw();
	
	return false;
}

