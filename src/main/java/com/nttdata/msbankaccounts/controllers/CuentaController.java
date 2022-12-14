package com.nttdata.msbankaccounts.controllers;

import com.nttdata.msbankaccounts.entity.Cliente;
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
@RequestMapping("/api/cuentas")
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

    @PostMapping("{id}")
    public ResponseEntity<Cuenta> save(@PathVariable("id") Integer id, @RequestBody Cuenta cuenta){
        log.info("[INI] save Cuenta");
        Cliente c = new Cliente();
        c.setClienteid(id);
        cuenta.setCliente(c);
        Cuenta p = cuentaService.save(cuenta);

        log.info("[END] save Cuenta");
        return new ResponseEntity<Cuenta>(p, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
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

    @GetMapping("/numero/{n}")
    public ResponseEntity<Cuenta> fingByNumeroCuenta(@PathVariable("n") String n){
        log.info("[INI] fingByNumeroCuenta Cuenta " + n);

        Cuenta cuenta = cuentaService.fingByNumeroCuenta(n);

        log.info("[END] fingByNumeroCuenta Cuenta " + n);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Cuenta>> fingByCliente(@PathVariable("clienteId") Integer clienteId){
        log.info("[INI] fingByCliente Cuenta " + clienteId);

        List<Cuenta> cuentas = cuentaService.fingByCliente(clienteId);

        log.info("[END] fingByCliente Cuenta " + clienteId);
        return new ResponseEntity<List<Cuenta>>(cuentas, HttpStatus.OK);
    }
}
