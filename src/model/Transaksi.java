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
public class Transaksi {
    private String noOrder;
    private Date tglTransaksi;
    private String nmPelanggan;
    private Integer total;

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getNmPelanggan() {
        return nmPelanggan;
    }

    public void setNmPelanggan(String nmPelanggan) {
        this.nmPelanggan = nmPelanggan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
