package com.example.banca.Service;

import com.example.banca.Dao.CuentaDao;
import com.example.banca.Models.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaDao cuentaDao;

    @Transactional(readOnly=false)
    public Cuenta save() {
        return save(null);
    }

    @Transactional(readOnly=false)
    public Cuenta save(Cuenta cuenta) {
        return cuentaDao.save(cuenta);
    }
    @Transactional(readOnly=false)
    public void delete(String id) {
        cuentaDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Cuenta findById(String id) {
        return cuentaDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Cuenta> findByAll() {
        return (List<Cuenta>) cuentaDao.findAll();
    }

}
