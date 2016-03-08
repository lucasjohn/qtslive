$( document ).ready(function() {
   
	//Inicializa os campos editáveis.
	$('#abas-tabelas-div').each(function(){ 
		
		// HEADER
		
		//LOCAL TREINO
		$("#"+this.id+" .x-local-link").editable({
	    	
	    	container: 'body',
	        source: function () {
				
				var locais = [];
			
				$("#local-hidden-select option").each(function()	{
				    // Add $(this).val() to your list
				    locais.push({id: $(this).val(), text: $(this).text()});
				});
				
				return locais;
				
			},
	        select2: {
	            width: 200,
	            placeholder: ' -- Selecione -- ',
	            allowClear: true
	        } 
	    });
		
		//DATA
		$("#"+this.id+" .x-data-link").editable();
		
		//PERIODO
		$("#"+this.id+" .x-periodo-link").editable({
			
	    	container: 'body',
	        source: function () {
				
				var periodos = [];
			
				$("#periodo-hidden-select option").each(function()	{
				    // Add $(this).val() to your list
					periodos.push({id: $(this).val(), text: $(this).text()});
				});
				
				return periodos;
				
			},
	        select2: {
	            width: 200,
	            placeholder: ' -- Selecione -- ',
	            allowClear: true
	        } 
	    });
		
		//PSE
		$("#"+this.id+" .x-pse-link").editable({
	    	container: 'body',   
	    	emptytext: '<i class="fa fa-edit"></i>',
		    type: 'text',
		    pk: 1,
		    name: 'pse',
		    title: 'Alterar PSE'
	    });
		
		
		// FIM HEADER
		
	});
	
	
	$('#abas-tabelas-div table').each(function(){ 
				
				
		$("#"+this.id+" .x-grupo-link").editable({
	    	
	    	container: 'body',
	        source: function () {
				
				var grupos = [];
			
				$("#grupo-hidden-select option").each(function()	{
				    // Add $(this).val() to your list
				    grupos.push({id: $(this).val(), text: $(this).text()});
				});
				
				return grupos;
				
			},
	        select2: {
	            width: 200,
	            placeholder: ' -- Selecione -- ',
	            allowClear: true
	        } 
	    });
	    
	    
	    $("#"+this.id+" .x-fad-link").editable({
	    	container: 'body',   
	    	emptytext: '<i class="fa fa-edit"></i>',
		    type: 'text',
		    pk: 1,
		    name: 'fad',
		    title: 'FAD'
	    });
	    
	    $("#"+this.id+" .x-dmt-link").editable({
	    	container: 'body',   
	    	emptytext: '<i class="fa fa-edit"></i>',
	           type: 'text',
	           pk: 1,
	           name: 'dmt',
	           title: 'DMT'
	    });
	    
	    $("#"+this.id+" .x-pse-link").editable({
	    	container: 'body',  
	    	emptytext: '<i class="fa fa-edit"></i>',
	           type: 'text',
	           pk: 1,
	           name: 'pse',
	           title: 'PSE'
	    });
	    
		$("#"+this.id+" .x-dor-link").editable({
	    	
	    	container: 'body',
	        source: function () {
				
				var grupos = [];
			
				$("#dor-select option").each(function()	{
				    // Add $(this).val() to your list
				    grupos.push({id: $(this).val(), text: $(this).text()});
				});
				
				return grupos;
				
			},
	        select2: {
	            width: 200,
	            placeholder: ' -- Selecione -- ',
	            allowClear: true
	        },
	        emptytext: '<i class="fa fa-edit"></i>'
	    }); 
		
	});
    
}); //Fim do ready



