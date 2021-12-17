package com.escolacrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.escolacrud.escolacrud.models.Matricula;

public interface EscolaRepository extends CrudRepository<Matricula, String> {

	Matricula findByCodigo(long codigo);

}
