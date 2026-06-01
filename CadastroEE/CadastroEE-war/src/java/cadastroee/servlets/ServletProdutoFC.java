package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listar";
        }

        String destino = "ProdutoLista.jsp";

        switch (acao) {
            case "listar":
                {
                    List<Produto> lista = facade.findAll();
                    request.setAttribute("listaProdutos", lista);
                    destino = "ProdutoLista.jsp";
                    break;
                }
            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;
            case "formAlterar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Produto p = facade.find(id);
                    request.setAttribute("produto", p);
                    destino = "ProdutoDados.jsp";
                    break;
                }
            case "excluir":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Produto p = facade.find(id);
                    if (p != null) {
                        facade.remove(p);
                    }       List<Produto> lista = facade.findAll();
                    request.setAttribute("listaProdutos", lista);
                    destino = "ProdutoLista.jsp";
                    break;
                }
            case "incluir":
                {
                    Produto p = new Produto();
                    p.setNome(request.getParameter("nome"));
                    p.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
                    p.setPrecoVenda(Float.valueOf(request.getParameter("precoVenda")));
                    facade.create(p);
                    List<Produto> lista = facade.findAll();
                    request.setAttribute("listaProdutos", lista);
                    destino = "ProdutoLista.jsp";
                    break;
                }
            case "alterar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Produto p = facade.find(id);
                    if (p != null) {
                        p.setNome(request.getParameter("nome"));
                        p.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
                        p.setPrecoVenda(Float.valueOf(request.getParameter("precoVenda")));
                        facade.edit(p);
                    }       List<Produto> lista = facade.findAll();
                    request.setAttribute("listaProdutos", lista);
                    destino = "ProdutoLista.jsp";
                    break;
                }
            default:
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}