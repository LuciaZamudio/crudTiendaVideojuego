<%--
  Created by IntelliJ IDEA.
  User: Lucía Zamudio
  Date: 26/07/2021
  Time: 04:34:p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <title>SCP Game Shop | Consulta</title>
</head>
<body>

<div class="card col-sm-5 border-0">
  <div class="card-body ">
    <form action="${context}/ServletVideogame" method="post">
      <input type="hidden" name="action" value="Cancelar">
      <div class="form-group">
        <label>Nombre(s)</label>
        <input type="text" class="form-control" name="txtnombre"  value="${juegoseleccionado.getName()}" disabled/>
      </div>
      <div class="form-group">
        <label>Descripcion</label>
        <input type="text" class="form-control campo" name="txtdescripcion"  value="${juegoseleccionado.getDescription()}" disabled/>
      </div>
      <div class="form-group">
        <label>Fecha: </label>
        <input type="text" class="form-control" name="txtfecha"  value="${juegoseleccionado.getDate_reg()}" disabled/>
      </div>
      <br>
      <button type="submit" class="btn btn-info"><i class="fas fa-edit"></i>Cancelar</button>
    </form>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
