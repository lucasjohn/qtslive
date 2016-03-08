var botoesOK = false;

$( document ).ready(function() {
	
	var tabelas = [];
	
	var index = 0;
	
	//Inicializa as tabelas.
	$('#abas-tabelas-div table').each(function(){ 
		
		var id = "#"+this.id;
		
		tabelas[index] = $(id).DataTable({
			
			"responsive": true,
			"paging":   false,
	        "ordering": true,
	        "info":     true,	
	        "dom": '<"toolbar">frtip',
	        "iDisplayLength": 100,
			"language": {
	            "url": "assets/plugins/datatables/Portuguese-Brasil.json"
	        },
	        "fnDrawCallback": function() {
	        	//Se já não foi escrito (o campo de busca reescreve a tabela)
	        	//if (isEmpty($('div.toolbar'))) {
	        	if(botoesOK==false) {
	        		$(id+"_wrapper div.toolbar").prepend(obterBotaoAcoes());
	        	}	                 
	        }
		});
		
		index++;
	   
	});
	 
    
}); //Fim do ready




function obterBotaoAcoes() {

	// 			return  '<div class="btn-group m-b-sm">'+
	// 			            '<button type="button" class="btn btn-info">Ações</button>'+
	// 			            '<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'+
	// 			                '<span class="caret"></span>'+
	// 			                '<span class="sr-only">Toggle Dropdown</span>'+
	// 			            '</button>'+
	// 			            '<ul class="dropdown-menu" role="menu">'+
	// 			                '<li><a href="#">Adicionar grupo</a></li>'+
	// 			                '<li><a href="#" data-toggle="modal" data-target="#nova-linha-modal">Adicionar atleta</a></li>'+
	// 			                '<li class="divider"></li>'+
	// 			                '<li><a href="#">Limpar tudo</a></li>'+
	// 			            '</ul>'+
	// 			         '</div>'; 

	return '<button id="nova-atividade-button" type="button" class="btn btn-info btn-addon m-b-sm btn-sm" data-toggle="modal" data-target="#nova-atividade-modal" onclick="esconderHeader();"><i class="fa fa-plus"></i> Atividade </button>';
}

