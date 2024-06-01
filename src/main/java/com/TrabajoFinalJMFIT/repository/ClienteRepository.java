package com.TrabajoFinalJMFIT.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.TrabajoFinalJMFIT.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	 Cliente findByUsuarioAndPassword(String usuario, String password);
	    Cliente findByUsuario(String usuario);
	
}
