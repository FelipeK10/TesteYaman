#language: pt
#Author: Felipe Kchevi Siqueira
#Version: 1.0
#Encoding: iso-8859-1
Funcionalidade: Realizar pesquisa

  Contexto: 
    Dado que eu acesse o site do mercado livre

  Esquema do Cenario: realizar pesquisa no mercado livre e exibir somente titulo e valor dos N resultados
    Quando eu realizar uma pesquisa no site
      | Parametro de busca |
      | <parametroBusca>   |
    Entao devo obter o titulo e o valor dos <N> primeiros resultados

    Exemplos: 
      | parametroBusca | N |
      | Celular        | 5 |

  Esquema do Cenario: Realizar persquisa do penultimo item de uma determinada pagina
    Quando eu realizar uma pesquisa no site
      | Parametro de busca |
      | <parametroBusca>   |
    Entao devo localizar o penultimo item da pagina <N>

    Exemplos: 
      | parametroBusca | N |
      | Celular        | 2 |
