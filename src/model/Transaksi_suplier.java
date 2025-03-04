/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Hp
 */
public class Transaksi_suplier {
    private String nmSuplier;
    private String id_trsup;
    private String id_produk;
    private String jumlah;
    private String status;
    private Date tglRestock;

    public String getNmSuplier() {
        return nmSuplier;
    }

    public void setNmSuplier(String nmSuplier) {
        this.nmSuplier = nmSuplier;
    }

    public String getId_trsup() {
        return id_trsup;
    }

    public void setId_trsup(String id_trsup) {
        this.id_trsup = id_trsup;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglRestock() {
        return tglRestock;
    }

    public void setTglRestock(Date tglRestock) {
        this.tglRestock = tglRestock;
    }
    
    
}
