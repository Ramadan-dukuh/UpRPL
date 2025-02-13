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
public class Produk {
    private String idProduk;
    private String nmProduk;
    private String jenisProduk;
    private Integer hargaBeli;
    private Integer hargaJual;
    private Integer stock;

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNmProduk() {
        return nmProduk;
    }

    public void setNmProduk(String nmProduk) {
        this.nmProduk = nmProduk;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public Integer getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Integer hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    
}
