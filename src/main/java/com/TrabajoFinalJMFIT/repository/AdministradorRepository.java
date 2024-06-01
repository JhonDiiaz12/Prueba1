package com.TrabajoFinalJMFIT.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.TrabajoFinalJMFIT.entity.Administrador;

public interface AdministradorRepository extends MongoRepository<Administrador, String>{
	
	Administrador findByUsuarioAndPassword(String usuario, String password);
}