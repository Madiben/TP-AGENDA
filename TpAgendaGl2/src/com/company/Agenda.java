package com.company;

import java.util.ArrayList;
import java.util.Date;


public class Agenda {
    String name;
    public ArrayList<Evenement> caln;
    Agenda(String name){
        caln= new ArrayList<Evenement>();
        this.name=name;
    }
    public Evenement rechercheEvenement(String nom){
        for(Evenement e:caln){
            if((e.nomeven).equals(nom)){

                return e;
            }
        }
        return  null;
    }
    public void Affichage()
    {
        int i=1;
        for(Evenement e:caln){
            System.out.println("\n"+"L'Evenement :"+ i +
                    "\t Nom :"+ e.nomeven +" \t Date Debut :"+
                    e.Debutev+" \t Date Fin :"+e.finev +" \n.");
            i++;
        }
    }
    public void duree(Date debut , Date fin)
    {
        long diffinmils = Math.abs(fin.getTime() - debut.getTime());
        long hours=(diffinmils/(60*60*1000));
        long days=0;
        long months=0;
        long years=0;


        while(hours>24)
        {
            hours=hours-24;
            days++;
        }
        while(days>365)
        {
            days=days-365;
            years++;
        }
        while(days>30)
        {
            days=days-30;
            months++;
        }

        System.out.println("jour "+days+" Mois "+months +" Annee "+years);


    }
    public void ajouterEvenement(String nom, Date debut, Date fin){
        if(caln.size()==0)
        {
            caln.add(new Evenement(nom,debut,fin));

        }else
        {
        for(Evenement e:caln){
            if((e.nomeven).equals(nom)){
                System.out.println("L'Evenement existe deja!");
        }
        }
            caln.add(new Evenement(nom,debut,fin));
        }
    }
    public boolean suprimEvenement(String nom,Date debut,Date fin){
        for(Evenement e:caln){
            if((e.nomeven).equals(nom)){
                caln.remove(e);
                Affichage();
                return true;
            }
        }
        return false;
    }
    public boolean modifierEventNom(String nom,String nome){
        for(Evenement e:caln){
            if((e.nomeven).equals(nom)){
                e.nomeven=nome;
                System.out.println("\n"+"L'Evenement Change:" +
                        "\t Nom :"+ e.nomeven +" \t Date Debut :"+
                        e.Debutev+" \t Date Fin :"+e.finev +" \n.");
                return true;
            }
        }
        return  false;
    }
    public boolean modifyEventDate(String nom,Date Nd,Date Nf){
        for(Evenement e:caln){
            if((e.nomeven).equals(nom)){
                e.Debutev=Nd;
                e.finev=Nf;
                System.out.println("\n"+"L'Evenement Change:" +
                        "\t Nom :"+ e.nomeven +" \t Date Debut :"+
                        e.Debutev+" \t Date Fin :"+e.finev +" \n.");
                return true;
            }
        }
        return  false;
    }
}
