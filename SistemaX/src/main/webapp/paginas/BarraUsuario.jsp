<%-- 
    Document   : BarraUsuario
    Created on : 23/04/2016, 16:39:42
    Author     : José
--%>

<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <% 
        
        Usuario usuario = (Usuario) session.getAttribute("user");
        pageContext.setAttribute("usuario", usuario);
        
    %>
      <div class="container container-full ">
        <div class="row">
          <div class="alert alert-info col-lg-12 header-size">
              <div class="logo-box float-left">
                  <img src="img/logo.jpg" alt="..." class="img-rounded logo-img">
              </div>
              <div class="header-box float-left header-title">
                <h3><strong>Systema X</strong></h3>
                <p>Logado como ${usuario.papel} </p>
              </div>

              <div class="profile-img-box float-right">
                  <img src="${usuario.foto}" alt="..." class="img-rounded profile-img" style="height: 100px">
              </div>
              <div class="header-box float-right header-profile">
                <h4><strong>${usuario.nome}</strong></h4>
                <p><a href="">Editar Perfil</a> | <a href="AppControle?logica=sair">Sair</a></p>
              </div>
          </div>
        </div>
    </header>
