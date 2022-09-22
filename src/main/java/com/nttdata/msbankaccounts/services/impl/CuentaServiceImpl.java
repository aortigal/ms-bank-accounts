package com.nttdata.msbankaccounts.services.impl;

import com.nttdata.msbankaccounts.entity.Cuenta;
import com.nttdata.msbankaccounts.repository.ICuentaRepository;
import com.nttdata.msbankaccounts.services.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;


    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
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
