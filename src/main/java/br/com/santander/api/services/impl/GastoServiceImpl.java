package br.com.santander.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.santander.api.documents.Gasto;
import br.com.santander.api.repositories.GastoRepository;
import br.com.santander.api.services.GastoService;

@Service
public class GastoServiceImpl implements GastoService {

	@Autowired
	private GastoRepository gastoRespository;

	@Override
	public Gasto cadastrar(Gasto gasto) {
		/**
		 * No processo de integração de gastos, a categoria deve ser incluida
		 * automaticamente caso a descrição de um gasto seja igual a descrição de
		 * qualquer outro gasto já categorizado pelo cliente o mesmo deve receber esta
		 * categoria no momento da inclusão do mesmo
		 **/
		if (ObjectUtils.isEmpty(gasto.getCategorizacao())) {
			Gasto gastoCategorizado = gastoRespository.findByCodigoUsuario(gasto.getCodigousuario(),
					gasto.getDescricao());
			if (!ObjectUtils.isEmpty(gastoCategorizado)) {
				gasto.setCategorizacao(gastoCategorizado.getCategorizacao());
			}
		}
		return this.gastoRespository.save(gasto);
	}
}
