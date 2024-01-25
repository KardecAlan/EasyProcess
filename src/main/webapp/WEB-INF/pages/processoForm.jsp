<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Adicionar Novo Processo</h2>
<a href="index.jsp"><button>Inicio</button></a><br><br>
<form:form method="post" action="/processoSave">
    <table >
        <tr>
            <td>Tipo de Processo :</td>
            <td><form:select path="tipoProcessoId" required="true">
                <c:forEach items="${listTipoProcesso}" var="p">
                    <option value="${p.id}">${p.nome}</option>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>Numero : </td>
            <td><form:input path="numero" required="true" /></td>
        </tr>
        <tr>
            <td>Objetivo : </td>
            <td><form:input path="objetivo" required="true" /></td>
        </tr>
        <tr>
            <td>Data de Entrada : </td>
            <td><form:input path="dataEntrada" type="date" required="true"/></td>
        </tr>
         <tr>
            <td>Valor do Recurso : </td>
            <td><form:input path="valorRecurso" required="true" /></td>
         </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Salvar" /></td>
        </tr>
    </table>
</form:form>