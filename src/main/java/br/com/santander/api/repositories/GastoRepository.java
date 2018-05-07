package br.com.santander.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.santander.api.documents.Gasto;

public interface GastoRepository extends MongoRepository<Gasto, String> {
	@Query("{ 'codigousuario' : ?0 , 'descricao' : ?1 , 'categorizacao.descricao' : {\"$ne\" : null}}")
	Gasto findByCodigoUsuario(final String codigoUsuario, final String descricao);
}
