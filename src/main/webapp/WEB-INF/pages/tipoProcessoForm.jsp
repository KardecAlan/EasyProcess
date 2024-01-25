<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Adicionar Novo Tipo de Processo</h2>
<a href="index.jsp"><button>Inicio</button></a><br><br>
<form:form method="post" action="tipoProcessoSave">
    <table >
        <tr>
            <td>Nome : </td>
            <td><form:input path="nome" required="true" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Salvar" /></td>
        </tr>
    </table>
</form:form>