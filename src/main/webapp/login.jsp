<%-- 
    Document   : login
    Created on : 19 mar. 2021, 21:13:50
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="#">Restaurante Bosco</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
              <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="ServletProductos?op=listar&pagina=1">Listar productos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="ServletProductos?op=insert1"">Nuevo Producto</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">TPV</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="login.jsp">Login</a>
                </li>
              </ul>
            </div>
          </nav>
        <h1>Login</h1>
        <%
            String alert="";
            String mensaje = (String) request.getAttribute("mensaje");
            if(mensaje==null) mensaje = "";
            else{
                alert="alert-danger";
            }
        %>
        <div class="container">
            <form method="post" action="ServletLogin">
                Usuario: <input class="form-control" type="text" name="usuario">
                Contraseña <input class="form-control" type="password" name="pass">
                <input class="my-2 btn btn-primary" type="submit" value="Entrar">
            </form>
            <p class="alert <%=alert%>"><%=mensaje%></p>
        </div>
    </body>
</html>
