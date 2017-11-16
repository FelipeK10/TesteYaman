package br.com.yaman.pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.yaman.commons.Resultado;

public class MercadoLivrePage {

	public MercadoLivrePage() {
		super();
	}

	private static final String URL = "https://www.mercadolivre.com.br";

	public static WebDriver driver;

	/**
	 * Método responsável por subir o browser e acessar o link 
	 */
	public void acessar() {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\firefoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}

	/**
	 * Método responsável por retornar o elemento da barra de busca
	 * @return {@link WebElement}
	 * @author Felipe Kchevi Siqueira
	 */
	public WebElement getBarraBusca() {
		WebElement campoBusca;
		return campoBusca = driver.findElement(By.name("as_word"));
	}

	/**
	 * Método responsável por inseriri um valor no elemento get
	 * @param parametroBusca
	 * @author Felipe Kchevi
	 */
	public void setBarraBusca(String parametroBusca) {
		getBarraBusca().sendKeys(parametroBusca);
	}

	/**
	 * Método responsável por receber o elemento do botão de busca
	 * @return {@link WebElement}
	 * @author Felipe Kchevi
	 */
	public WebElement getBotaoBusca(){
		WebElement lupaBusca;
		return lupaBusca = driver.findElement(By.className("nav-search-btn"));
	}

	/**
	 * Método responsável por clicar no botao de busca
	 * @author Felipe Kchevi
	 */
	public void clickBotaoBusca(){
		getBotaoBusca().click();
	}

	/**
	 * Metodo responsável por retornar os n resultados da lita
	 * @param n
	 * @return list {@list WebElement}
	 * @author Felipe Kchevi
	 */
	public List<Resultado> getListaResultados(int n) {
		WebElement tableElement = driver.findElement(By.id("searchResults"));
		List<WebElement> listElementsResults = tableElement.findElements(By.className("results-item"));

		List<Resultado> resultados = new ArrayList<Resultado>();

		for (int i = 0; i < n; i++) {
			Resultado resultado = new Resultado();
			resultado.setTitulo(listElementsResults.get(i).findElement(By.xpath(".//*[span[@class='main-title']]")).getText());
			resultado.setPreco(listElementsResults.get(i).findElement(By.xpath(".//*[span[@class='price-fraction']]")).getText());
			resultados.add(resultado);
		}

		return resultados;
	}

	/**
	 * Metodo responsável por fechar o browser
	 * @author Felipe Kchevi
	 */
	public void fechar(){
		driver.close();
	}

	/**
	 * Método responsável por Navegar para a pagina conforme o indice passado
	 * @param indicePagina
	 * @author Felipe Kchevi
	 */
	public void navigateToPage(int indicePagina) {
		
		int indicePaginaClick = indicePagina - 1; 
		List<WebElement> indexPages = getIndexPages();
		
		indexPages.get(indicePaginaClick).click();
	}

	/**
	 * Método reponsável por Obter os indices das paginas acessiveis
	 * @return list {@list WebElement}
	 * @author Felipe Kchevi 
	 */
	private List<WebElement> getIndexPages() {
		WebElement tableElement = driver.findElement(By.xpath("//*[ul[@class='pagination stack u-clearfix']]/ul"));
		List<WebElement> listElementsPages = tableElement.findElements(By.className("pagination__page"));
		System.out.println("TAMANHO DO INDEX DAS PAGINAS: "+listElementsPages.size());
		return listElementsPages;
	}

	/**
	 * Método responsável por retornar a lista de todos os produtos da pagina 
	 * @return list {@list WebElement}
	 * @author Felipe Kchevi
	 */
	private List<WebElement> getListaResultadosAll() {
		WebElement tableElement = driver.findElement(By.id("searchResults"));
		List<WebElement> listElementsResults = tableElement.findElements(By.className("results-item"));
		return listElementsResults;
	}

	/**
	 * Método responsável por cessar o penultimo resultado da lista de apoio
	 * @author Felipe Kchevi
	 */
	public void acessarPenultimoResultado() {
		List<WebElement> resultados = getListaResultadosAll();
		
		resultados.get(resultados.size() - 2).findElement(By.xpath(".//*[span[@class='main-title']]")).click();		
	}
	/**
	 * Método responsável por esperar carregar a pagina
	 */
	public void carregamentoPagina(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
	}
}