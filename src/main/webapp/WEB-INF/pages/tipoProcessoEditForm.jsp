<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <h1>Editar Tipo de Processo</h1>
       <form:form method="post" action="/editTipoProcessoSave">
        <table >
        <tr>
        <td></td>
         <td><form:hidden  path="id" /></td>
         </tr>
         <tr>
          <td>Nome : </td>
          <td><form:input path="nome"  /></td>
         </tr>
         <tr>
          <td> </td>
          <td><input type="submit" value="Salvar" /></td>
         </tr>
        </table>
       </form:form>

<a href="/viewTipoProcesso"><button>Voltar</button></a><br>