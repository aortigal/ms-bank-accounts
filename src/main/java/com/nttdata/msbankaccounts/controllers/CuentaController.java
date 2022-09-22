package com.nttdata.msbankaccounts.controllers;

import com.nttdata.msbankaccounts.entity.Cuenta;
import com.nttdata.msbankaccounts.services.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getListALl(){
        List<Cuenta> lista = cuentaService.getListAll();
        return new ResponseEntity<List<Cuenta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getListById(@PathVariable("id") Integer id){
        Cuenta cuenta = cuentaService.getById(id);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        Cuenta p = cuentaService.save(cuenta);
        return new ResponseEntity<Cuenta>(p, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cuenta> update(@RequestBody Cuenta cuenta){
        Cuenta p = cuentaService.update(cuenta);
        return new ResponseEntity<Cuenta>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        cuentaService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
