package com.crud.controller;

import com.crud.dao.CupomDAO;
import com.crud.model.Cupom;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A anotação abaixo substitui o antigo arquivo web.xml
@WebServlet("/cadastrar")
public class CupomServlet extends HttpServlet {
    
    private CupomDAO dao;

    public void init() {
        dao = new CupomDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Pega os dados que vieram do formulário index.jsp
        String codigo = request.getParameter("codigo");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int usos = Integer.parseInt(request.getParameter("usos"));

        // Salva no banco usando a regra que já estava pronta
        Cupom novoCupom = new Cupom(codigo, valor, usos);
        dao.salvar(novoCupom);

        // Redireciona o usuário de volta para a página inicial
        response.sendRedirect("index.jsp");
    }
}