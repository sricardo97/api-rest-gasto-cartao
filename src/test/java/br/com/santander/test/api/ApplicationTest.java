package br.com.santander.test.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.santander.api.Application;
import br.com.santander.api.documents.Gasto;
import br.com.santander.api.services.GastoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	private GastoService gastoService;

	@Test
	public void cadastraGasto() {
		Gasto gasto = new Gasto();
		gasto.setDescricao("Santander");
		gasto.setValor("505,00");
		gasto.setCodigousuario("");
		gasto.setData("19/04/2017");
		this.gastoService.cadastrar(gasto);
	}
}