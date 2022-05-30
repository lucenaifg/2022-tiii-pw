<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Pessoa</title>
</head>
<body>
    <h1>Cadastro de Pessoa</h1>
    <form action="/aula02/cadastro" method="post">
        <fieldset>
            <legend>Dados pessoais</legend>
            <label>Nome:</label>
            <input name="nome">
            <label>Telefone:</label>
            <input name="telefone" type="number">
        </fieldset>
        <button type="submit">Salvar</button>
        <% if (request.getSession().getAttribute("nome") != null) {%>
        <h2 style="color: green">O cadastro da pessoa <%= request.getSession().getAttribute("nome") %> foi salvo com
            sucesso.</h2>
        <% } %>
    </form>
    <br>
    <a href="/aula02">Voltar</a>
</body>
</html>
