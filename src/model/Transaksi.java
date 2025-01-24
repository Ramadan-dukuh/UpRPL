/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public class Transaksi {
    private String idTransaksi;
    private String harga;
    private String tglTransaksi;
    private String nmPelanggan;

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getNmPelanggan() {
        return nmPelanggan;
    }

    public void setNmPelanggan(String nmPelanggan) {
        this.nmPelanggan = nmPelanggan;
    }

    
}
