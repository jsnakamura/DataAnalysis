# Apisul 

Teste admissional prático da Apisul

Requisitos do sistema:
-------

* jdk 11
* Testng 7.1
* Google gson 2.8.6
* Google Guava 29.0
* Lombok 1.18
* Hamcrest 2.2

Modo de uso:
-------

Teste das funcionalidades executando o arquivo testng.xml.

Base de dados
-------

Por ser uma implementação de uma interface, a funcionalidade dos métodos é mostrada a partir dos testes implementados, os dados utilizados foram criados dentro dos testes para ajudar na compreensão e nos próprios testes, o carregamento dos dados de um json pedido pelo desafio foi implementado dentro da classe DataHelper.

Melhorias
-------

* Os testes só mostram o comportamento ótimo dos métodos, faltando mostrar o comportamento perante ao estresse.

* Uso de enum para modelagem dos dados que permitiria remoção de valores mágicos.

* Declaração de diversas variáveis  que podem ser dinâmicos, como no caso da criação de listas para cada andar.


 

Observações:
-------

* Por não haver uma especificação exata das funcionalidades algumas escolhas tiveram que ser feitas pra determinar o comportamento dos métodos.

* No geral as escolhas das listas é por chegada, ou seja, não há a execução de um sorting involvido.

** Um exemplo é no caso do andarMenosFrequentado(), que caso haja empate o primeiro ser carregado ganha prioridade.

** Outro exemplo de escolha para o comportamento é o exemplo do método periodoMenorFluxoElevadorMenosFrequentado() que a escolha do periodo de menor fluxo em caso de empate é matutino -> vespertino -> noturno.

