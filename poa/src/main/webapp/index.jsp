<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.crud.dao.CupomDAO, com.crud.model.Cupom, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestão de Cupons</title>
</head>
<body style="font-family: sans-serif; padding: 20px;">

    <h2>Cadastrar Novo Cupom</h2>
    <form action="cadastrar" method="POST">
        Código: <input type="text" name="codigo" required> 
        Desconto (R$): <input type="number" step="0.01" name="valor" required> 
        Usos: <input type="number" name="usos" required> 
        <button type="submit">Salvar</button>
    </form>
    
    <hr>
    <h2>Cupons Ativos</h2>
    <table border="1" cellpadding="8" style="border-collapse: collapse; text-align: center;">
        <tr style="background-color: #f2f2f2;">
            <th>ID</th><th>Código</th><th>Desconto (R$)</th><th>Usos Restantes</th>
        </tr>
        <%
            // Aqui o JSP pede a lista direto pro seu DAO
            CupomDAO dao = new CupomDAO();
            List<Cupom> cupons = dao.buscarTodos();
            for (Cupom c : cupons) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><b><%= c.getCodigo() %></b></td>
            <td><%= c.getValorDesconto() %></td>
            <td><%= c.getQuantidadeUsos() %></td>
        </tr>
        <%  } %>
    </table>

</body>
</html>