package com.example.banca.Dao;

import com.example.banca.Models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, String> {
}
