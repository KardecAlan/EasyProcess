<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Tipos de Processos</h2>
<a href="index.jsp"><button>Inicio</button></a><br><br>

<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Nome</th><th>Editar</th><th>Deletar</th></tr>
   <c:forEach var="tp" items="${list}">
   <tr>
   <td>${tp.id}</td>
   <td>${tp.nome}</td>
   <td><a href="tipoProcessoEditForm/${tp.id}">Editar</a></td>
   <td><a href="deleteTipoProcesso/${tp.id}">Deletar</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="tipoProcessoForm"><button>Adicionar novo</button></a>