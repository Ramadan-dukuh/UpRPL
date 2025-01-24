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
public class Transaksi_suplier {
    private String kodeSuplier;
    private String id_trsup;
    private String id_produk;
    private String jumlah;

    public String getKodeSuplier() {
        return kodeSuplier;
    }

    public void setKodeSuplier(String kodeSuplier) {
        this.kodeSuplier = kodeSuplier;
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
    
    
}
