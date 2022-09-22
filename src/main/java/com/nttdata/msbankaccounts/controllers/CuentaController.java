package com.nttdata.msbankaccounts.controllers;

import com.nttdata.msbankaccounts.entity.Cuenta;
import com.nttdata.msbankaccounts.services.ICuentaService;
import com.nttdata.msbankaccounts.services.impl.CuentaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(CuentaController.class);
    @GetMapping
    public ResponseEntity<List<Cuenta>> getListALl(){
        log.info("[INI] getListALl Cuenta");

        List<Cuenta> lista = cuentaService.getListAll();

        log.info("[END] getListALl Cuenta");
        return new ResponseEntity<List<Cuenta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getListById(@PathVariable("id") Integer id){
        log.info("[INI] getListById Cuenta " + id);

        Cuenta cuenta = cuentaService.getById(id);

        log.info("[END] getListById Cuenta " + id);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        log.info("[INI] save Cuenta");

        Cuenta p = cuentaService.save(cuenta);

        log.info("[END] save Cuenta");
        return new ResponseEntity<Cuenta>(p, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody Cuenta cuenta){
        log.info("[INI] update Cuenta " + id);

        Cuenta p = cuentaService.update(id, cuenta);

        log.info("[END] update Cuenta " + id);

        if(p!=null){
            return new ResponseEntity<Object>(p, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Object>("Cuenta no Existe.", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        log.info("[INI] delete Cuenta " + id);

        cuentaService.delete(id);

        log.info("[END] delete Cuenta " + id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
