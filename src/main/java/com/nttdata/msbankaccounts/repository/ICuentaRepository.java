package com.nttdata.msbankaccounts.repository;

import com.nttdata.msbankaccounts.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {
}
