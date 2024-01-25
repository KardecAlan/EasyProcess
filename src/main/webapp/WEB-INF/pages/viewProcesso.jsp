<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Processos</h2>
<a href="index.jsp"><button>Inicio</button></a><br><br>

<form method="get" action="/viewProcessoByNumero">
   <table>
      <tr>
         <td>Consultar Número do Processo: </td><td><input type = "text" name = "numero"/></td><td><input type="submit" value="Pesquisar" /></td>
      </tr>
   </table>
</form>


<table border="2" width="70%" cellpadding="2">
<tr><th>Tipo Processo</th><th>Numero</th><th>Objetivo</th><th>Data de Entrada</th><th>Valor do Recurso</th><th>Editar</th><th>Deletar</th></tr>
   <c:forEach var="p" items="${list}">
   <tr>
   <td>${p.tipoProcesso.nome}</td>
   <td>${p.numero}</td>
   <td>${p.objetivo}</td>
   <td>${p.dataEntrada}</td>
   <td>${p.valorRecurso}</td>
   <td><a href="processoEditForm/${p.id}">Editar</a></td>
   <td><a href="deleteProcesso/${p.id}">Deletar</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>

   <a href="processoForm"><button>Adicionar novo</button></a>