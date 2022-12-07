package com.example.banca.Controller;

import com.example.banca.Dao.CuentaDao;
import com.example.banca.Models.Cuenta;
import com.example.banca.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaDao cuentaDao;

    @Autowired
    private CuentaService cuentaService;

    @PostMapping(value="/")
    public ResponseEntity<Cuenta> agregar(@RequestBody Cuenta cuenta){
        Cuenta obj = cuentaService.save(cuenta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Cuenta> eliminar(@PathVariable String id){
        Cuenta obj = cuentaService.findById(id);
        if(obj!=null)
            cuentaService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value="/")
    public ResponseEntity<Cuenta> editar(@RequestBody Cuenta cuenta){
        Cuenta obj = cuentaService.findById(cuenta.getId_cuenta());
        if(obj!=null) {

            obj.setSaldo_cuenta(cuenta.getSaldo_cuenta());

            cuentaService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Cuenta> consultarTodo(){
        return cuentaService.findByAll();
    }

    @GetMapping("/list/{id}")
    public Cuenta consultaPorId(@PathVariable String id){
        return cuentaService.findById(id);
    }
}

