# Introduction 
Teste para a Agibank

# Contact:
 e-mail: luispastre@hotmail.com
 
# Getting Started
Technologies: Java 13, Maven, Lombok


# Build
* Comando para compilar: mvn clean install -U
* Main Class
 	com.agibank.startup.Start.java

# Execute
* 1º
	- É necessário possuir as pastas %HOMEPATH%/data/in e %HOMEPATH%/data/out
* 2º
	- Incluir os arquivos de extensão .bat dentro da pasta %HOMEPATH%/data/in
* 3º
	- Os resultados dos processamento dos arquivos .dat, ficaram em %HOMEPATH%/data/out   
* 4º
	- Compile o projeto
* 5º	
	- Copie a pasta lib que está dentro de target (target/lib), para onde a aplicação será executada 
* 6º 	
    - Copie o arquivo agibanktest.jar, que está dentro de target (target/agibanktest.jar), para onde a aplicação será executada 
* 7º	
	- Comando para executar: java -jar agibanktest.jar
		É necessario copiar o artefato gerado em ../target/agibanktest.jar e a pasta lib.

###		ex.
			../agibanktest.jar
			../lib
###     comando:			
         ../java -jar agibanktest.jar

# Docker Execute

* Execute o comando na pasta raiz do projeto: docker-compose up -d  