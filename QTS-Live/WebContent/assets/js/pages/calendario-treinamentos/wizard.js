$( document ).ready(function() {
    
	//WIZARD ============================================================
	
	var $validator = $("#wizardForm").validate({
	        rules: {
	        	local: {
	                required: true
	            },
	            data: {
	                required: true
			    },
			    periodo: {
	                required: true,
	                email: true
			    }/*,
			    duracao: {
	                required: true
			    }*/,			    
			    pseEsperado: {
	                required: true
			    },
			    grupo: {
	                required: true
			    },
			    atletas: {
	                required: true
	            },
	            atividade: {
	                required: true,
	                number: true
			    }/*,
			    duracaoAtividade: {
	                required: true,
	                number: true
			    }*/
	        }
	    });
	 
	    $('#rootwizard').bootstrapWizard({
	        'tabClass': 'nav nav-tabs',
	        onTabShow: function(tab, navigation, index) {
	            var $total = navigation.find('li').length;
	            var $current = index+1;
	            var $percent = ($current/$total) * 100;
	            $('#rootwizard').find('.progress-bar').css({width:$percent+'%'});
	        },
	        'onNext': function(tab, navigation, index) {
	            var $valid = $("#wizardForm").valid();
	            if(!$valid) {
	                $validator.focusInvalid();
	                return false;
	            }
	        },
	        'onTabClick': function(tab, navigation, index) {
	            var $valid = $("#wizardForm").valid();
	            if(!$valid) {
	                $validator.focusInvalid();
	                return false;
	            }
	        },
	    });
	    
	  //WIZARD FIM ========================================================
	    
	  
	    
	  //Adicionar grupo  
	  $("#nome-novo-grupo-div").hide();
	  $("#loading-img").hide();
	  
	  
	  $('#criar-grupo-link').click(function () {
	    	
		  $('#criar-grupo-link').hide();
		  $("#nome-novo-grupo-div").show("slow");
		  
	  });
	  
	  $('#cancelar-novo-grupo-link').click(function () {
	    	
		  $("#nome-novo-grupo-div").hide();
		  $('#criar-grupo-link').show("fast");
		  
	  });
	  
	  $('#salvar-novo-grupo-link').click(function () {
	    	
		  $('#cancelar-novo-grupo-link').hide();
		  $('#salvar-novo-grupo-link').hide();
		  $("#loading-img").show("fast");
		  
		  setTimeout(function() {
			  		  $("#loading-img").hide("fast");
					  $("#nome-novo-grupo-div").hide();
					  $("#loading-img").hide();	
					  $('#criar-grupo-link').show("fast");
					  $('#cancelar-novo-grupo-link').show();
					  $('#salvar-novo-grupo-link').show();
				  	}, 2000);
		  
	  });
	  
	  
	  //Resumo
	  criarTextoResumo();
	  $('#periodo-wizard-select').change(function () {
		  criarTextoResumo();
	  });
	  
    
});

function criarTextoResumo() {
	var texto = '<i class="fa fa-check-square-o"></i> Dados preenchidos corretamente para o treino da <b>' + $('#periodo-wizard-select option:selected').text() + '</b>.';
	$("#resumo-div").html(texto);
	return false;
}



