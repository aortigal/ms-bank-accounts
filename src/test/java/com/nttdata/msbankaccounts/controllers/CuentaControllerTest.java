package com.nttdata.msbankaccounts.controllers;

import com.nttdata.msbankaccounts.entity.Cliente;
import com.nttdata.msbankaccounts.entity.Cuenta;
import com.nttdata.msbankaccounts.enums.CuentaEnum;
import com.nttdata.msbankaccounts.services.ICuentaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CuentaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ICuentaService cuentaService;

    @Test
    void getListALl() throws Exception {
        mvc.perform(get("/api/cuentas"))
                .andExpect(status().isOk());
    }

    @Test
    void getListById() throws Exception {

        Integer id =1;
        Cuenta cuenta = new Cuenta(id, "123", CuentaEnum.AHORRO, 1000.0, true, new Cliente());

        when(cuentaService.getById(id)).thenReturn(cuenta);

        mvc.perform(get("/api/cuentas/" + id))
                .andExpect(status().isOk());
    }

}
