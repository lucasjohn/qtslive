<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTS | Painel de Config.</title>

</head>
<body>
	
	
	
      <ul>	
      
      	<!-- #usuarios-form --> 																		                                
          <li><a id="usuarios-link" href="#"><i class="fa fa-users"></i> Usuários</a></li>
          <!-- #perfis-form --> 																		                                
          <li><a id="perfis-link" href="#"><i class="fa fa-thumbs-up"></i> Perfis</a></li>
<!-- #categorias-form --> 																		                                
          <li><a id="categorias-link" href="#"><i class="fa fa-soccer-ball-o"></i> Categorias</a></li>	                                
<!-- #dominancias-form -->				                                
          <li><a id="dominancias-link" href="#"><i class="fa fa-thumbs-up"></i> Dominâncias</a></li>
          <!-- #exercicio-form -->				                                
          <li><a id="exercicios-link" href="#"><i class="fa fa-thumbs-up"></i> Exercícios</a></li>
          <!-- #localdor-form -->				                                
          <li><a id="localdor-link" href="#"><i class="fa fa-child"></i> Locais de Dor</a></li>
          <!-- #localdor-form -->				                                
          <li><a id="localtreino-link" href="#"><i class="fa fa-futbol-o"></i> Locais de Treino</a></li>
          <!-- #grupo-form -->				                                
          <li><a id="grupo-link" href="#"><i class="fa fa-futbol-o"></i> Grupo</a></li>
          <!-- #especial-form -->				                          
          <li><a id="especial-link" href="#"><i class="fa fa-file-text"></i> Especial</a></li>
          <!-- #periodos-form -->				                                
<!--           <li><a id="periodos-link" href="#">Períodos</a></li> -->
          <!-- #posicoes-form -->				                                
          <li><a id="posicoes-link" href="#"><i class="fa fa-thumb-tack"></i> Posições</a></li>
          <!-- #tiposessao-form -->				                                
          <li><a id="tiposessao-link" href="#"><i class="fa fa-plug"></i> Tipos de Sessão</a></li>
          <!-- #tipotreinamentofisico-form -->				                                
          <li><a id="tipotreinamentofisico-link" href="#"><i class="fa fa-thumbs-up"></i> Tipos Treinamento Físico</a></li>
          <!-- #tipotreinamentotatico-form -->				                                
          <li><a id="tipotreinamentotatico-link" href="#"><i class="fa fa-thumbs-up"></i> Tipos Treinamento Tático</a></li>
          <!-- #tipotreinamentotecnico-form -->				                                
          <li><a id="tipotreinamentotecnico-link" href="#"><i class="fa fa-thumbs-up"></i> Tipos Treinamento Técnico</a></li>	                                
          
      </ul>
 	
 	
 	<form id="categorias-form" action="categorias" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="dominancias-form" action="dominancias" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="posicoes-form" action="posicoes" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="usuarios-form" action="usuarios" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="perfis-form" action="perfis" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>	
	<form id="exercicios-form" action="exercicios" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>			
	<form id="localdor-form" action="dor" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="localtreino-form" action="localtreino" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>				
	<form id="tipotreinamentofisico-form" action="tipotreinamentofisico" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="tipotreinamentotecnico-form" action="tipotreinamentotecnico" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>
	<form id="tipotreinamentotatico-form" action="tipotreinamentotatico" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>		
	<form id="tiposessao-form" action="tiposessao" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>	
	<form id="periodos-form" action="periodos" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>		
	<form id="grupo-form" action="grupos" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>	
	<form id="especial-form" action="especial" method="POST">
		<input type="hidden" name="idClube" value="${usuario.clube.id}" />
	</form>				
	
			
	<content tag="local_script">
				
		

		<script>
		
			$(document).ready(function() {

				//Link para categorias
				$("#categorias-link").click(function(e) {
					//e.preventDefault();
					$("#categorias-form").submit();
				});
				
				//Link para dominancias
				$("#dominancias-link").click(function(e) {
					//e.preventDefault();
					$("#dominancias-form").submit();
				});
				
				//Link para posicoes
				$("#posicoes-link").click(function(e) {
					//e.preventDefault();
					$("#posicoes-form").submit();
				});
				
				//Link para usuarios
				$("#usuarios-link").click(function(e) {
					//e.preventDefault();
					$("#usuarios-form").submit();
				});
				
				//Link para perfis
				$("#perfis-link").click(function(e) {
					//e.preventDefault();
					$("#perfis-form").submit();
				});
				
				//Link para exercicio
				$("#exercicios-link").click(function(e) {
					//e.preventDefault();
					$("#exercicios-form").submit();
				});
				
				//Link para localdor
				$("#localdor-link").click(function(e) {
					//e.preventDefault();
					$("#localdor-form").submit();
				});
				
				//Link para localtreino
				$("#localtreino-link").click(function(e) {
					//e.preventDefault();
					$("#localtreino-form").submit();
				});
				
				//Link para tipotreinamentofisico
				$("#tipotreinamentofisico-link").click(function(e) {
					//e.preventDefault();
					$("#tipotreinamentofisico-form").submit();
				});
				
				//Link para tipotreinamentotecnico
				$("#tipotreinamentotecnico-link").click(function(e) {
					//e.preventDefault();
					$("#tipotreinamentotecnico-form").submit();
				});
				
				//Link para tipotreinamentotecnico
				$("#tipotreinamentotatico-link").click(function(e) {
					//e.preventDefault();
					$("#tipotreinamentotatico-form").submit();
				});
				
				//Link para tiposessao
				$("#tiposessao-link").click(function(e) {
					//e.preventDefault();
					$("#tiposessao-form").submit();
				});
				
				//Link para periodos
				$("#periodos-link").click(function(e) {
					//e.preventDefault();
					$("#periodos-form").submit();
				});
				
				//Link para grupos
				$("#grupo-link").click(function(e) {
					//e.preventDefault();
					$("#grupo-form").submit();
				});
				
				//Link para grupos
				$("#especial-link").click(function(e) {
					//e.preventDefault();
					$("#especial-form").submit();
				});

			}); //fim ready
			
			
			
		</script>
		
	</content>
</body>
</html>