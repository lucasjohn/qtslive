$( document ).ready(function() {
	
	$("#treino-panel-div").hide();
    
	// CALENDÁRIO ===================================
	
	var date = new Date();
    var day = date.getDate();
    var month = date.getMonth();
    var year = date.getFullYear();

    // page is now ready, initialize the calendar...

    $('#calendar').fullCalendar({
    	lang: 'pt-br',
    	header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar
		eventLimit: true, // allow "more" link when too many events
		eventRender: function(event, element, view) {                   
            var ntoday = new Date().getTime();
            var eventStart = moment( event.start ).valueOf();
            if (eventStart < ntoday) {
            	element.addClass("past-event");
            }
        },
        events: function(start, end, timezone, callback) {        	
            $.ajax({
                url: 'listarTreinosSimplificadosJson',
                dataType: 'json',
                data: {                    
                    start: start.format(),
                    end: end.format()
                },
                success: function(dados) {
                   
                	var events = [];
                	
                	var listaTreino = dados.listaTreino;
                    
                    $.each(listaTreino, function(index, treino) {
                    	
                    	events.push({
                            title: treino.localTreino.nome,
                            allDay: true,
                            start: treino.data.year + "-" + (treino.data.monthValue<10?"0"+treino.data.monthValue:treino.data.monthValue) + "-" + (treino.data.dayOfMonth<10?"0"+treino.data.dayOfMonth:treino.data.dayOfMonth),
                            dataString: treino.dataString,
                            idClube: treino.idClube,
                            idCategoria: treino.categoria.id,
                            nomeCategoria: treino.categoria.nome,
                            idPeriodo: treino.periodo.id,
                            nomePeriodo: treino.periodo.nome,
                            codigoTreino: treino.codigoTreino,
                            idLocal: treino.localTreino.id,
                            nomeLocal: treino.localTreino.nome,
                            pseEsperado: treino.pseEsperado
                        });
                    	
                    });
                    
                    callback(events);
                },
                error: function (jqXHR, textStatus, errorThrown) {
    		        if (jqXHR.status == 500) {
    		        	toastr["error"]("Erro: " + jqXHR.responseText);
    		        } else {
    		        	toastr["error"]("Erro: n�o foi poss�vel recuperar os treinos do banco de dados.");
    		        }
    		    }
                
            });
        },		
		dayClick: function(date, jsEvent, view) {

			//$('#nova-atividade-modal').modal('show');
			$('#nova-atividade-wizard-modal').modal('show');
			
			
			//var moment = $('#calendar').fullCalendar('getDate');
		    $('#data-input').val(date.format('DD/MM/YYYY'));
		    $('#data-hidden-input').val(date);

	    },
	    eventClick: function(calEvent, jsEvent, view) {
	    	
	    	$("#treino-panel-div").show();
	        
	    	var html = '<table><tbody>' +
	    	           '<tr><td >Categoria: </td><td align="left">&nbsp; '+calEvent.nomeCategoria+'</td></tr>' +
					   '<tr><td >Data: </td><td align="left">&nbsp; '+calEvent.dataString+'</td></tr>' +
					   '<tr><td >Período: </td><td align="left">&nbsp; '+calEvent.nomePeriodo+'</td></tr>' +
					   '<tr><td >Local: </td><td align="left">&nbsp; '+calEvent.nomeLocal+'</td></tr>' +
					   //'<tr><td >PSE Esperado: </td><td align="left"> &nbsp'+calEvent.pseEsperado+'</td></tr>' +
					   '</tbody></table>';	    	
	    	
	    	$("#treino-div").fadeTo('fast', 0.3).fadeTo('slow', 1.0);
	    	
	    	$("#id-clube-input-hidden").val(calEvent.idClube);
	    	$("#id-categoria-input-hidden").val(calEvent.idCategoria);
	    	$("#data-input-hidden").val(calEvent.dataString);
	    	$("#id-periodo-hidden").val(calEvent.idPeriodo);
	    	$("#codigo-treino-input-hidden").val(calEvent.codigoTreino);
	    	$("#id-evento-input-hidden").val(calEvent._id);
	    	
	    	$("#treino-div").html(html);
	    	
	    	//$("#treino-div").effect("highlight", {}, 3000);

	    }/*,
	    eventMouseover: function (event, jsEvent, view) {            
	        $(this).css('border-color', 'yellow');
	    }*/
	});
    
    
    $('#add-evento-button').click(function () {
    	
    	var ajax = true;
    	
    	submeter(ajax);
    	
    });
    
    
});



function obterAtividades() {
	
	var atividades = "";
	
	var primeira = true;
	
	$('#atividades-grupo-table > tbody  > tr')
		.each(function() {
			
				var idGrupo = $(this).attr('idGrupo'),
					nomeGrupo = $(this).attr('nomeGrupo'),
					tipoAtividade = $(this).attr('tipo'),
					idAtividade = $(this).attr('idAtividade'),
					nomeAtividade = $(this).attr('nomeAtividade'),
					duracao = $(this).attr('duracao'),
					observacoes =$(this).attr('observacoes');
				
				if(!primeira) {
					atividades += "@";
				} else {
					primeira = false;
				}
				
				atividades += "idGrupo="+idGrupo;
				atividades += "|nomeGrupo="+nomeGrupo;
				atividades += "|tipoAtividade="+tipoAtividade;
				atividades += "|idAtividade="+idAtividade;
				atividades += "|nomeAtividade="+nomeAtividade;
				atividades += "|duracao="+duracao;
				atividades += "|observacoes="+observacoes;
			
			  });
	
	
	return atividades;
}

function obterGrupos() {
	
	var lista = "";
	
	var primeira = true;
	
	$.each(grupos, function(idGrupo, atletas) {		
		
		if(!primeira) {
			lista += "@";
		} else {
			primeira = false;
		}
	    
		lista += idGrupo + ":";
		
		var primeira2 = true;
		
		$.each(atletas, function(i, idAtleta) {
			
			if(!primeira2) {
				lista += ",";
			} else {
				primeira2 = false;
			}
			
			lista += idAtleta;
			
		});
		
	});
	
	return lista;
}


function submeter(ajax) {
	
	var idLocal = $('#local-wizard-select option:selected').val(),
    nomeLocal = $('#local-wizard-select option:selected').text(),
    dataString = $('#data-wizard-input').val(),
    idPeriodo = $('#periodo-wizard-select option:selected').val(),
    nomePeriodo = $('#periodo-wizard-select option:selected').text(),
    //duracao = $('#duracao-wizard-input').val(),
    pseEsperado = $('#pse-esperado-wizard-input').val(),
    idClube = $('#id-clube-input').val();

	var listaAtividade = obterAtividades();
	var listaGrupo = obterGrupos();
	
	var params = "?treino.localTreino.id="+idLocal+
	             "&treino.localTreino.nome="+nomeLocal+
	             "&treino.localTreino.idClube="+idClube+
	             "&treino.dataString="+dataString+
	             "&treino.periodo.id="+idPeriodo+
	             "&treino.periodo.nome="+nomePeriodo+
	             "&treino.periodo.idClube="+idClube+
	             "&treino.idClube="+idClube+
	             //"&treinamento.duracao="+duracao+
	             "&treino.pseEsperado="+pseEsperado+
	             "&listaAtividade="+listaAtividade+
	             "&listaGrupo="+listaGrupo;
	
	if(ajax) {
		
		//add disabled
		$('#add-evento-button').attr('disabled', 'disabled');
		
		$.ajax({
		    type: "POST",
		    url: 'criarTreinoJson'+params,			                
		    dataType: 'json',
		    contentType: 'application/json',
		    success: function(data) {
		    	
		    	var treino = data.treino;
		    	
		    	//Adiciona no calend�rio		    	
		    	/*var newEvent = new Object();
		    	newEvent.title = treino.localTreino.nome;
		    	newEvent.allDay = true;
		    	newEvent.start = treino.data.year + "-" + treino.data.monthValue + "-" + treino.data.dayOfMonth;
		    	newEvent.dataString = treino.dataString;
		    	newEvent.idClube = treino.idClube;
		    	newEvent.idCategoria = treino.categoria.id;
		    	newEvent.nomeCategoria = $("#nome-categoria-input").val();
		    	newEvent.idPeriodo = treino.periodo.id;
		    	newEvent.nomePeriodo = treino.periodo.nome;
		    	newEvent.codigoTreino = treino.codigoTreino;
		    	newEvent.idLocal = treino.localTreino.id;
		    	newEvent.nomeLocal = treino.localTreino.nome;
		    	newEvent.pseEsperado = treino.pseEsperado;*/
		    	
		    	var newEvent = {
		    			title: treino.localTreino.nome,
				    	allDay: true,
				    	start: treino.data.year + "-" + (treino.data.monthValue<10?"0"+treino.data.monthValue:treino.data.monthValue) + "-" + (treino.data.dayOfMonth<10?"0"+treino.data.dayOfMonth:treino.data.dayOfMonth),
				    	dataString: treino.dataString,
				    	idClube: treino.idClube,
				    	idCategoria: treino.categoria.id,
				    	nomeCategoria: $("#nome-categoria-input").val(),
				    	idPeriodo: treino.periodo.id,
				    	nomePeriodo: treino.periodo.nome,
				    	codigoTreino: treino.codigoTreino,
				    	idLocal: treino.localTreino.id,
				    	nomeLocal: treino.localTreino.nome,
				    	pseEsperado: treino.pseEsperado
	            };

		    	
		    	
		    	$('.modal').modal('hide');
		    	$('#calendar').fullCalendar( 'renderEvent', newEvent, true);
		    	
		    	toastr["success"]("Treino no(a) " + nomeLocal + " adicionado com sucesso no dia <b>" + dataString + "</b>.");
		    	
		    },
		    error: function (jqXHR, textStatus, errorThrown) {
		        if (jqXHR.status == 500) {
		        	toastr["error"]("Erro: " + jqXHR.responseText);
		        } else {
		        	toastr["error"]("Erro desconhecido.");
		        }
		    }
		    
		});
		

		//remove it
		$('#add-evento-button').removeAttr("disabled");
		
	} else {
		toastr["error"]("Não implementado ainda.");
	}
	
	
	
}