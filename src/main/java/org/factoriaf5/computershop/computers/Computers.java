package org.factoriaf5.computershop.computers; // ruta hasta donde está el modelo

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "computers")
public class Computers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trade;

    @Column(nullable = false)
    private int ram;

    @Column(nullable = false)
    private String micro;

    @Column(nullable = false)
    private String os;

    @Column(nullable = false)
    private int price;

    // RELACION DE FK CON SHOP
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shops shop;

    // CONSTRUCTOR CON PARAMETROS
    public Computers(Long id, String trade, int ram, String micro, String os, int price) {
        this.id = id;
        this.trade = trade;
        this.ram = ram;
        this.micro = micro;
        this.os = os;
        this.price = price;
    }

    // CONSTRUCTOR VACIO
    public Computers() {
    }

    // GETTERS Y SETTERS ////////////
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
