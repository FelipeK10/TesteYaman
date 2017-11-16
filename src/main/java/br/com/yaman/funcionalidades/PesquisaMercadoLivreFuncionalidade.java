package br.com.yaman.funcionalidades;

import java.util.List;
import java.util.Map;

import br.com.yaman.commons.Resultado;
import br.com.yaman.pageobject.MercadoLivrePage;
import cucumber.api.DataTable;

public class PesquisaMercadoLivreFuncionalidade {

	MercadoLivrePage mercadoLivrePage = new MercadoLivrePage();
	
	/**
	 * Medoto respos�vel por acessar o link do mercado livre
	 * @author Felipe KChevi
	 */
	public void acessarMercadoLivre(){
	mercadoLivrePage.acessar();
	}
	
	
	/**
	 * Metodo repons�vel por realizar a pesquisa
	 * @param data
	 * @author Felipe Kchevi
	 */
	public void realizarPesquisa(DataTable data){
		for (Map<String, String> map : data.asMaps(String.class, String.class)){
			mercadoLivrePage.setBarraBusca(map.get("Parametro de busca"));
		}
		mercadoLivrePage.clickBotaoBusca();
		mercadoLivrePage.carregamentoPagina();
	}

	/**
	 * M�todo respons�vel por trazer o resultado da busca
	 * @param arg
	 * @throws InterruptedException
	 * @author Felipe Kchevi
	 */
	public void resultadoBusca(String arg) throws InterruptedException{
			
			int n = Integer.parseInt(arg);
			List<Resultado> resultados =  mercadoLivrePage.getListaResultados(n);
			
			for (int i = 0; i < resultados.size(); i++) {
				System.out.println("===============================================================");
				System.out.println("\nTitulo do Resultado: "+i+1+resultados.get(i).getTitulo());
				System.out.println("\nPre�o do Resultado: "+i+1+resultados.get(i).getPreco()+"\n");
				System.out.println("===============================================================");
			}
			mercadoLivrePage.fechar();
	}

	/**
	 * M�todo repons�vel por Pesquisar o pen�ltimo item de uma pagina de resultados da busca
	 * @param indicePagina
	 * @return
	 */
	public void localizarPenultimoItem(int indicePagina){
		mercadoLivrePage.navigateToPage(indicePagina);
		 mercadoLivrePage.acessarPenultimoResultado();
		 mercadoLivrePage.fechar();
	}
}
