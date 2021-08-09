<%--
  Created by IntelliJ IDEA.
  User: Sergio Cortes
  Date: 26/07/2021
  Time: 02:45:p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <title>SCP Game Shop</title>
</head>
<body>

<a href="${context}/views/game/register.jsp" class="btn btn-outline-success"><i class="fas fa-plus"></i>Agregar VideoJuego</a>
<div class="d-flex">
    <div class="col-sm-12">
        <table class="table">
            <thead class="table-light">
            <tr>
                <th>No.</th><!--Enbcabezado-->
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Fecha Registro</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listgames}" var="game" ><!--iterar cada usuario-->
            <tr>
                <td>${game.getId()}</td>
                <td>${game.getName()}</td><!--datos del bean person-->
                <td>${game.getDescription()}</td>
                <td>${game.getDate_reg()}</td>
                <td>
                    <c:if test="${ game.getStatus() == 1 }">
                        <span class="badge rounded-pill bg-success">Activo</span>
                    </c:if>
                    <c:if test="${ game.getStatus() == 0 }">
                        <span class="badge rounded-pill bg-danger">Inactivo</span>
                    </c:if>
                </td>
                <td>
                    <c:if test="${ game.getStatus() == 1 }">
                        <form action="${context}/ServletVideogame" method="POST" style="display: inline">
                            <input type="hidden" name="action" value="Cargar">
                            <input type="hidden" name="id" value="${game.getId()}">
                            <button type="submit" class="btn btn-primary btn-sm" ><i class="fas fa-edit"></i></button>
                            <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal" id="btn-delete" data-code="${game.getId()}" data-text="${game.getName()}"><i class="fas fa-trash-alt"></i></button>
                        </form>
                        <form action="${context}/ServletVideogame" method="post">
                            <input type="hidden" name="action" value="Consultar">
                            <input type="hidden" name="id" value="${game.getId()}">
                            <button type="submit" class="btn btn-info btn-sm"><i class="fas fa-eye"></i></button>
                        </form>


                    </c:if>
                    <c:if test="${ game.getStatus() == 0 }">
                            <button type="button" class="btn btn-info btn-sm"><i class="fas fa-eye"></i>Detalles</button>

                    </c:if>
                    <!--  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modifyuser" ><i class="fas fa-edit"><a href="ServletContainer?menu=employe&accion=Cargarporid&id=></a></i></button>-->
                    <!-- <button type="button" class="btn btn-info"><i class="fas fa-eye"></i></button>-->
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!--modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${context}/ServletVideogame" method="post">
                <input type="hidden" name="action" value="Eliminar">
                <input type="hidden" name="id" id="id">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Eliminar VideoJuego</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label>¿Deshabilitar?</label>
                    <h5 id="text-delete"></h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i>Cerrar</button>
                    <button type="submit" class="btn btn-danger" ><i class="fas fa-trash-alt"></i>Eliminar usuario</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js" ></script>
</body>
</html>
