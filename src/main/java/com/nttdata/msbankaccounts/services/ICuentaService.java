package com.nttdata.msbankaccounts.services;

import com.nttdata.msbankaccounts.entity.Cuenta;

import java.util.List;

public interface ICuentaService {

    Cuenta save(Cuenta cuenta);

    Cuenta update(Integer id, Cuenta cuenta);

    List<Cuenta> getListAll();

    Cuenta getById(Integer id);

    boolean delete(Integer id);

    Cuenta fingByNumeroCuenta(String cuenta);

    List<Cuenta> fingByCliente(Integer clienteId);

}
