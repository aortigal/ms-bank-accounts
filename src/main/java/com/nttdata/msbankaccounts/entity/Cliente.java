package com.nttdata.msbankaccounts.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nttdata.msbankaccounts.util.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer clienteid;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "estado", nullable = false, length = 30)
    private boolean estado;
}
