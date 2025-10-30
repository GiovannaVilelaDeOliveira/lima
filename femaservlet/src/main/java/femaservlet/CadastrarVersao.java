package femaservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import versao.Versao;
import versao.VersaoDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/cadastrarVersao")
public class CadastrarVersao extends HttpServlet {
	private static final long serialVersionUID = 3L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String operacao = req.getParameter("operacao");
		
		if ("Pesquisar".equals(operacao)) {
			resp.getWriter().write(prepararPaginaConsulta());
		} else {
			resp.getWriter().write(prepararPaginaCadastro());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operacao = req.getParameter("operacao");
		VersaoDao dao = new VersaoDao(); 
		
		if("cadastrar".equals(operacao)) {
			Integer codigo = Integer.parseInt(req.getParameter("codigo"));
			String nome = req.getParameter("nome");
			Integer ano = Integer.parseInt(req.getParameter("ano"));
			String novidades = req.getParameter("novidades");
			String problemasResolvidos = req.getParameter("problemasResolvidos");
			
			
			Versao versao = new Versao();
			versao.setCodigo(codigo);
			versao.setNome(nome);
			
			versao.setAno(ano);
			versao.setNovidades(novidades);
			versao.setProblemasResolvidos(problemasResolvidos);
			
		
			dao.cadastrar(versao);
			
		} else if ("excluir".equals(operacao)) {
			Integer codigo = Integer.parseInt(req.getParameter("id"));
			dao.excluir(codigo);
		}
		
		resp.sendRedirect("cadastrarVersao?operacao=Pesquisar");
	}

	private String gerarCabecalhoHTML(String titulo) {
		return "<!DOCTYPE html>"
			+ "<html lang='pt-br'>"
			+ "<head>"
			+ "    <meta charset='UTF-8'>"
			+ "    <meta name='viewport' content='width=device-width, initial-scale-1.0'>"
			+ "    <title>" + titulo + " - Painel de Controle</title>"
			+ "    <link rel='preconnect' href='https://fonts.googleapis.com'>"
			+ "    <link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>"
			+ "    <link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap' rel='stylesheet'>"
			+ "    <style>"
		
			+ "        body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #fce9f1 0%, #f1e7fe 100%); color: #333; padding: 40px 20px; min-height: 100vh; box-sizing: border-box; margin: 0; }"
			+ "        .container { max-width: 800px; margin: 0 auto; }"
			+ "        fieldset { background-color: #ffffff; border: none; border-radius: 12px; padding: 30px; box-shadow: 0 6px 20px rgba(0, 0, 0, 0.07); }"
			+ "        legend { font-size: 1.5em; font-weight: 600; color: #7B2CBF; padding: 0 5px; margin-bottom: 20px; }"
		
			+ "        label { font-weight: 600; margin-bottom: 5px; display: block; color: #555; }"
			+ "        input[type='text'], input[type='number'] { width: 100%; padding: 12px; margin-bottom: 20px; border-radius: 8px; border: 1px solid #ced4da; font-size: 1em; box-sizing: border-box; transition: border-color 0.3s ease, box-shadow 0.3s ease; }"
			+ "        input[type='text']:focus, input[type='number']:focus { border-color: #7B2CBF; box-shadow: 0 0 0 3px rgba(123, 44, 191, 0.15); outline: none; }"
			+ "        input[type='submit'] { width: auto; min-width: 120px; padding: 12px 20px; border-radius: 8px; border: none; background-color: #7B2CBF; color: white; font-size: 1em; font-weight: 600; cursor: pointer; transition: all 0.3s ease; }"
			+ "        input[type='submit']:hover { background-color: #5a1e96; transform: translateY(-2px); box-shadow: 0 4px 15px rgba(0,0,0,0.1); }"

			+ "        table { width: 100%; border-collapse: collapse; margin-top: 20px; }"
			+ "        th, td { padding: 15px; text-align: left; border-bottom: 1px solid #e2e8f0; }"
			+ "        th { font-weight: 600; color: #333; }"
			+ "        tr:last-child td { border-bottom: none; }"
			+ "        tr:hover { background-color: #f8f9fa; }"
	
			+ "        input[value='Excluir'] { background-color: #e53e3e; }"
			+ "        input[value='Excluir']:hover { background-color: #c53030; }"
			
			+ "        .actions-container { display: flex; justify-content: space-between; align-items: center; margin-top: 25px; }"
			+ "        .actions-container a { font-weight: 600; text-decoration: none; transition: all 0.3s ease; }"
			+ "        .link-primary { color: #7B2CBF; }"
			+ "        .link-primary:hover { color: #5a1e96; text-decoration: underline; }"
			+ "        .btn-voltar { background-color: #6c757d; color: white; padding: 10px 20px; border-radius: 8px; }"
			+ "        .btn-voltar:hover { background-color: #5a6268; box-shadow: 0 2px 8px rgba(0,0,0,0.1); transform: translateY(-1px); }"
			+ "    </style>"
			+ "</head>"
			+ "<body>";
	}

	private String prepararPaginaCadastro() {
		StringBuilder html = new StringBuilder();
		html.append(gerarCabecalhoHTML("Cadastrar Versão"));
		html.append("  <div class='container'>");
		html.append("      <fieldset>");
		html.append("          <legend>Cadastrar Nova Versão</legend>");
		html.append("          <form action='cadastrarVersao' method='post'>");
		html.append("              <input type='hidden' name='operacao' value='cadastrar'>");
		
		html.append("              <label for='codigo'>Código:</label>");
		html.append("              <input type='number' id='codigo' name='codigo' required><br>");
		
		html.append("              <label for='nome'>Nome:</label>");
		html.append("              <input type='text' id='nome' name='nome' required><br>");
		
	
		html.append("              <label for='ano'>Ano:</label>");
		html.append("              <input type='number' id='ano' name='ano' required><br>");
		
		html.append("              <label for='novidades'>Novidades:</label>");
		html.append("              <input type='text' id='novidades' name='novidades' required><br>");
		
		html.append("              <label for='problemasResolvidos'>Problemas Resolvidos:</label>");
		html.append("              <input type='text' id='problemasResolvidos' name='problemasResolvidos' required><br>");
		
		html.append("              <input type='submit' value='Cadastrar'>");
		html.append("          </form>");
		html.append("      </fieldset>");
		html.append("      <div class='actions-container'>");
		html.append("          <a href='cadastrarVersao?operacao=Pesquisar' class='link-primary'>&#8592; Voltar para a lista de versões</a>");
		html.append("          <a href='/femaservlet/inicial.html' class='btn-voltar'>Voltar ao Menu Principal</a>");
		html.append("      </div>");
		html.append("  </div>");
		html.append("</body></html>");
		return html.toString();
	}

	private String prepararPaginaConsulta() {
		List<Versao> versaoList = new VersaoDao().consultar();
		StringBuilder html = new StringBuilder();
		html.append(gerarCabecalhoHTML("Consultar Versões"));
		html.append("  <div class='container'>");
		html.append("      <fieldset>");
		html.append("          <legend>Versões Cadastradas</legend>");
		html.append("          <table>");
	
		html.append("              <tr><th>Código</th><th>Nome</th><th>Ano</th><th>Novidades</th><th>Problemas Resolvidos</th><th>Ação</th></tr>");
		
		for (Versao v : versaoList) {
			html.append("              <tr>");
			html.append("                  <td>").append(v.getCodigo()).append("</td>");
			html.append("                  <td>").append(v.getNome()).append("</td>");
		
			html.append("                  <td>").append(v.getAno()).append("</td>");
			html.append("                  <td>").append(v.getNovidades()).append("</td>");
			html.append("                  <td>").append(v.getProblemasResolvidos()).append("</td>");
			html.append("                  <td>");
			html.append("                      <form action='cadastrarVersao' method='post' style='margin:0;'>");
			html.append("                          <input type='hidden' name='operacao' value='excluir'>");
			html.append("                          <input type='hidden' name='id' value='").append(v.getCodigo()).append("'>");
			html.append("                          <input type='submit' value='Excluir'>");
			html.append("                      </form>");
			html.append("                  </td>");
			html.append("              </tr>");
		}
		
		html.append("          </table>");
		html.append("      </fieldset>");
		html.append("      <div class='actions-container'>");
		html.append("          <a href='cadastrarVersao' class='link-primary'>&#43; Cadastrar Nova Versão</a>");
		html.append("          <a href='/femaservlet/inicial.html' class='btn-voltar'>Voltar ao Menu Principal</a>");
		html.append("      </div>");
		html.append("  </div>");
		html.append("</body></html>");
		return html.toString();
	}
}