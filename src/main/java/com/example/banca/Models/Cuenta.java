package com.example.banca.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable {


    @Id
    @Column(name = "id_cuenta")
    private String id_cuenta;
    @Column(name = "fecha_apertura")
    private Date fecha_apertura;
    @Column(name = "saldo_cuenta")
    private double saldo_cuenta;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Override
    public String toString() {
        return "Cuenta [id_cuenta=" + id_cuenta + ", fecha_apertura=" + fecha_apertura + ", saldo_cuenta="
                + saldo_cuenta + ", cliente=" + cliente + "]";
    }
}