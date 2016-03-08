$( document ).ready(function() {
   
    $('#local-select').select2();
	$('#periodo-select').select2();
	$('#grupo-select').select2();
	$('#atividades-select').select2();
			
	$('#excluir-treino-button').click(function () {
		
		var html = '<blockquote>'+$("#treino-div").html() + '</blockquote>' + '<div class="alert alert-warning" role="alert">Excluir o treino?</div>';
		$('#msg-alerta-excluir-div').html(html);
		
		$('#excluir-treino-modal').modal('show');
		return false;
	});
	
	$('#confirm-excluir-treino-button').click(function () {
		
		//add disabled
		$('#confirm-excluir-treino-button').attr('disabled', 'disabled');
		
		var idClube = $("#id-clube-input-hidden").val(),
    	    idCategoria = $("#id-categoria-input-hidden").val(),
    	    data = $("#data-input-hidden").val(),
    	    //idPeriodo = $("#id-periodo-hidden").val(),
    	    codigoTreino = $("#codigo-treino-input-hidden").val();
		
		var params = "?header.idClube=" + idClube + 
		             "&header.categoria.id=" + idCategoria + 
		             "&header.dataString=" + data + 
		             "&header.codigoTreino=" + codigoTreino;
		
		
		
		$.ajax({
			url: 'excluirTreinoJson' + params,
			dataType: 'json',
			/*data: {
			},*/
			success: function(dados) {
				$('#excluir-treino-modal').modal('hide');
				$("#treino-panel-div").hide();
				$('#calendar').fullCalendar('removeEvents', $("#id-evento-input-hidden").val());
				toastr["success"]("Treino excluído com sucesso.");
				
			},
			error: function (jqXHR, textStatus, errorThrown) {
			    if (jqXHR.status == 500) {
			    	toastr["error"]("Erro: " + jqXHR.responseText);
				} else {
					toastr["error"]("Erro: não foi poss�vel excluir o treino do banco de dados.");
				}
			    $('#excluir-treino-modal').modal('hide');
			}        
         
        });
		
		//remove it
		$('#confirm-excluir-treino-button').removeAttr("disabled");
		
		return false;
	});
    
}); //Fim do ready



