<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cadastroee.model.Produto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Produto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container mt-4">
        <%
            // Recupera o produto para caso de alteração
            Produto p = (Produto) request.getAttribute("produto");
            String acao = (p == null) ? "incluir" : "alterar";
            String titulo = (p == null) ? "Incluir Produto" : "Alterar Produto";
        %>
        
        <h1 class="mb-4"><%= titulo %></h1>
        
        <form action="ServletProdutoFC" method="post" class="form"> 
            <input type="hidden" name="acao" value="<%= acao %>"> 
            
            <% if (p != null) { %>
                <input type="hidden" name="id" value="<%= p.getCodigo() %>"> 
            <% } %>
            
            <div class="mb-3"> 
                <label class="form-label">Nome:</label> 
                <input type="text" name="nome" class="form-control" value="<%= (p != null) ? p.getNome() : "" %>" required> 
            </div>
            
            <div class="mb-3"> 
                <label class="form-label">Quantidade:</label> 
                <input type="number" name="quantidade" class="form-control" value="<%= (p != null) ? p.getQuantidade() : "" %>" required> 
            </div>
            
            <div class="mb-3"> 
                <label class="form-label">Preço de Venda:</label> 
                <input type="text" name="precoVenda" class="form-control" value="<%= (p != null) ? p.getPrecoVenda() : "" %>" required> 
            </div>
            
            <button type="submit" class="btn btn-primary"><%= titulo %></button> 
            <a href="ServletProdutoFC?acao=listar" class="btn btn-secondary">Cancelar</a>
        </form>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>