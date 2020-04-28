package com.company;

public class Produit {
    String nome;
    String libelle;
    int code;
    float Price;

    public Produit(String nome,int code, String libelle, float price) {
        this.nome = nome;
        this.code=code;
        this.libelle = libelle;
        Price = price;
    }
    public boolean tester(int codee)
    {
        if(codee==code)
        {
            return true;

        }else {
            return false;
        }
    }
}
