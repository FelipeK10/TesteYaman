package br.com.yaman.steps;

import br.com.yaman.funcionalidades.PesquisaMercadoLivreFuncionalidade;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PesquisaMercadoLivreSteps {
	PesquisaMercadoLivreFuncionalidade pesquisaMercadoLivreFuncionalidade = new PesquisaMercadoLivreFuncionalidade();
	
	@Dado("^que eu acesse o site do mercado livre$")
	public void que_eu_acesse_o_site_do_mercado_livre() throws Throwable {
		pesquisaMercadoLivreFuncionalidade.acessarMercadoLivre();
	}

	@Quando("^eu realizar uma pesquisa no site$")
	public void que_eu_tenha_realizado_uma_pesquisa_no_site(DataTable data) throws Throwable {
		pesquisaMercadoLivreFuncionalidade.realizarPesquisa(data);
		Thread.sleep(5000);
	}

	@Entao("^devo obter o titulo e o valor dos (\\d+) primeiros resultados$")
	public void devo_obter_o_titulo_e_o_valor_dos_primeiros_resultados(String arg) throws Throwable {
		pesquisaMercadoLivreFuncionalidade.resultadoBusca(arg);
	}
	
	@Entao("^devo localizar o penultimo item da pagina (\\d+)$")
	public void devo_localizar_o_penultimo_item_da_pagina(int arg1) throws Throwable {
		pesquisaMercadoLivreFuncionalidade.localizarPenultimoItem(arg1);
	}
}
