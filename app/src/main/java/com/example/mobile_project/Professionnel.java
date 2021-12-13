package com.example.mobile_project;

public class Professionnel {

    public  String nom;
    public  String prenom;
    public  String tele;
    public  String ville;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }


    public String getTele() {
        return tele;
    }
    public String getVille() {
        return ville;
    }

    public Professionnel(String nom, String prenom,  String tele, String ville) {

        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.ville = ville;
    }
}
