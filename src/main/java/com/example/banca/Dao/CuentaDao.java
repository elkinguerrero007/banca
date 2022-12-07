package com.example.banca.Dao;

import com.example.banca.Models.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuentaDao extends CrudRepository<Cuenta, String> {
}
