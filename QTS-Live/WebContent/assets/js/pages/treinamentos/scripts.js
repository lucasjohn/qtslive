$( document ).ready(function() {
   
	
	//Inicializa os campos editáveis.
	$('#abas-tabelas-div table').each(function(){ 
		
		var id = "#"+this.id;
		
		id = id.replace('-table','');
		
		$(id+'local-select').select2();
		$(id+'periodo-select').select2();
		//$('#grupo-select').select2();
		//$('#atividades-grupo-select').select2();
		
	});

	
	$('.date-picker').datepicker({				
        orientation: "top auto",
        autoclose: true,
        format: "dd/mm/yyyy",
        language: "pt-BR"	
        	
    });
	
	
	
	
    
}); //Fim do ready



