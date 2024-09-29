package br.com.danielsantdev.calculadorajuroscompostos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculadoraServlet", urlPatterns = {""})
public class CalculadoraServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        System.out.println("Método doPost chamado");
        String valorPrincipal = request.getParameter("valorprincipal");
        String taxaJuros = request.getParameter("juros");
        String anos = request.getParameter("anos");
        String periodoComposto = request.getParameter("periodocomposto");

        String erro;

        if (valorPrincipal == null || valorPrincipal.isBlank() ||
                taxaJuros == null || taxaJuros.isBlank() ||
                anos == null || anos.isBlank() ||
                periodoComposto == null || periodoComposto.isBlank()) {

            erro = "Um ou mais campos estavam em branco. Tente novamente.";
            request.setAttribute("erro", erro);

        } else {

            double resultado = Utils.calcularJurosCompostos(Double.parseDouble(valorPrincipal),
                    Double.parseDouble(taxaJuros) / 100, Integer.parseInt(anos), Integer.parseInt(periodoComposto));

            request.setAttribute("valorPrincipal", valorPrincipal);
            request.setAttribute("juros", taxaJuros);
            request.setAttribute("anos", anos);
            request.setAttribute("periodoComposto", periodoComposto);
            request.setAttribute("resultado", resultado);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}