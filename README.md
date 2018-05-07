# API REST Integração de gastos por cartão
API RESTful com Spring Boot, Java 8, MongoDB

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.
git clone https://github.com/sricardo97/api-rest-gestao-gasto.git
cd api-rest-gestao-gasto
mvn spring-boot:run
Acesse http://localhost:8080/api/gastos
Utilize o usuário "user" e a senha que é impressa no terminal ao executar a aplicação para autenticar.


### APIs endpoints para Teste
POST http://localhost:8080/api/gastos [cadastra um novo gasto]  

	##### Body
	{
		"descricao":"Santander",
		"valor":"505,00",
		"codigousuario":"12",
		"data":"19/04/2017"
	}
 

### Importando o projeto no Eclipse ou STS
mvn eclipse:eclipse