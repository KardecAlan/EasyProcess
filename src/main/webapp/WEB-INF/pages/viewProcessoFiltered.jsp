<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="get" action="/viewProcessoByNumero">
    <table>
        <tr>
            <td><input type = "text" name = "numero"/></td><td><input type="submit" value="Pesquisar" /></td>
        </tr>
    </table>
</form>

<h2>Tipos de Processos</h2>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Tipo Processo</th><th>Numero</th><th>Objetivo</th><th>Data de Entrada</th><th>Valor do Recurso</th><th>Editar</th><th>Deletar</th></tr>
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.id}</td>
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

<a href="viewProcesso"><button>Voltar</button></a><br>
