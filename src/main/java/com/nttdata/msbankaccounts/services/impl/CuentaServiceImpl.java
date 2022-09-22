package com.nttdata.msbankaccounts.services.impl;

import com.nttdata.msbankaccounts.entity.Cuenta;
import com.nttdata.msbankaccounts.repository.ICuentaRepository;
import com.nttdata.msbankaccounts.services.ICuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta update(Integer id, Cuenta cuenta) {
        log.info("findById "+ id);
        Optional<Cuenta> c = cuentaRepository.findById(id);
        if (c.isPresent()){
            log.info("update "+ id);
            return cuentaRepository.save(cuenta);
        }
        log.info("Account is not exist "+ id);
        return null;
    }

    @Override
    public List<Cuenta> getListAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta getById(Integer id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        return cuenta.orElseGet(Cuenta::new);
    }

    @Override
    public boolean delete(Integer id) {
        cuentaRepository.deleteById(id);
        return true;
    }
}
