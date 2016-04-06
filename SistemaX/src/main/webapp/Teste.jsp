<%-- 
    Document   : Teste
    Created on : 20/03/2016, 16:01:53
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="AppControle?logica=newuser " method="post" id=""class="form-add">
                <img src="img/profiles/reader-default.png" title="" class="photo">
                <h4>Carregar Foto</h4>
                <input type="file" name="foto"  class="btn-file" id="btn-file" >
                <label class="name">Nome de Usuário</label>
                <input for=" " type="text" name="name" placeholder="Ex:Antonio Marques" class="" id="name">  

                <label class="senha" >Senha</label>
                <input for=" " type="password" name="senha" placeholder="Ex: Anderc4ma5" class="" id="senha"> 

                <label class="email" >Email</label>
                <input  type="email" placeholder="Ex: zilderlan@meuemail.com" name="email" id="email"> 

                <label class="matricula" >Matricula</label>
                <input  type="text" placeholder="Ex: 123456" name="matricula" id="matricula"> 

                <label class="tipo" >Tipo</label>
                <select  type="select" name="papel"  id="papel" > 
                    <option value="">Selecione</option>
                    <option value="Administrador">admin</option>
                    <option value="Aluno">aluno</option>
                    <option value="ASSISTENTE_SALA">assistente de sala</option>
                    <option value="professor">professor</option>
                    <option value="Monitor">monitor</option>
                </select>


                <input for=" " type="button" name="" value="Cancelar" class="cancel" id="" onclick="document.getElementById('user-add').style.display = 'none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit" id="">       		
            </form >

        <h1>Hello World!</h1>
    </body>
</html>
