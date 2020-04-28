package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Atelier {
    String nom;
    String Adress;
    ArrayList<Produit> pr;
    ArrayList<Client> cl;

    public Atelier(String nom,String Adress) {
        this.nom = nom;
        this.Adress=Adress;
        pr = new ArrayList<Produit>();
        cl=new ArrayList<Client>();
    }

    public void ajouter_pr(){
        String nm;
        String lbl;
        float prix;
        int code;
        System.out.println(" Ajouter un nouveau Produit ");
        Scanner scanner=new Scanner(System.in);
        System.out.println(" Donner nom du Produit ");
        nm =scanner.nextLine();
        System.out.println(" Donner libelle du Produit ");
        lbl =scanner.nextLine();
        System.out.println(" Donner Prix du Produit ");
        Scanner scn=new Scanner(System.in);
        prix =scn.nextInt();
        System.out.println(" Donner Code du Produit ");
        code =scn.nextInt();
        Produit p=new Produit(nm,code,lbl,prix);
        pr.add(p);
    }
    public void ajouter_cl(){
        String nm;
        int num;
        System.out.println(" Ajouter un nouveau Client ");
        Scanner scanner=new Scanner(System.in);
        System.out.println(" Donner nom du Client ");
        nm =scanner.nextLine();
        System.out.println(" Donner numero du Client ");
        Scanner scn=new Scanner(System.in);
        num =scn.nextInt();
        Client c=new Client(nm,num);
        cl.add(c);
    }

    public void afficher_produit()
    {
        int i=1;
            for(Produit e:pr){
                System.out.println("\n"+"Product Name :"+ i +
                        "\t Nom :"+ e.nome +" \t Product label :"+
                        e.libelle+" \t Product prix :"+e.Price +"\t Product code :"+e.code + "\n.");
                i++;
            }

    }
    public void afficher_client()
    {
        int i=1;
        for(Client e:cl){
            System.out.println("\n"+"Client Name :"+ i +
                    "\t Nom :"+ e.nomC +" \t Client numero :"+
                    e.numC+" \n.");
            i++;
        }

    }
    public void affichage(){
        System.out.println("Mon Atelier" + nom +" Adress " + Adress + "Contient ");
        System.out.println(" Clients ");
        afficher_client();
        System.out.println(" Produits ");
        afficher_produit();

    }
    public void operation() throws ParseException{
        int i;
        int cod;
        Date d=new Date();
        int Quantite;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choisir L'operation :" +
                "\n 1- Ajouter Produit." +
                "\n 2- Ajouter Client." +
                "\n 3- faire un commande."+
                "\n 4-etat Atelier." +
                "\n 5- Quitter.");
        do{
            i= scanner.nextInt();
        }while(i<0 || i>6);
        switch (i)
        {
            case 1:
                ajouter_pr();

                break;
            case 2:
                ajouter_cl();
                break;
            case 3:
                Scanner scer=new Scanner(System.in);
                System.out.println("Faire un Commande ");
                System.out.println(" Donner code Produit ");
                cod =scer.nextInt();
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("la Date sur la forme (dd/MM/yyyy):\n ");
                Scanner scdate=new Scanner(System.in);
                System.out.println(" Donner Date du Commande ");
                Date db = new Date();
                db=sdf.parse(scdate.nextLine());
                System.out.println(" Donner quantite Produit ");
                Quantite =scer.nextInt();
                commonde cm=new commonde(cod,db,Quantite);

                break;
            case 4:
                System.out.println("Atelier:");
                int aa;
                Scanner scaner = new Scanner(System.in);
                System.out.println(" \t \t \t \tAffichage :" +
                        "\n \t \t \t \t1- liste Client."+
                        "\n \t \t \t \t2- liste Produit."+
                        "\n \t \t \t \t3- Tout.");

                do {
                    aa = scaner.nextInt();
                } while (aa < 0 || aa > 4);
                switch (aa) {
                    case 1:
                        afficher_client();
                        break;
                    case 2:
                        afficher_produit();
                        break;
                        case 3:
                            affichage();
                            break;

                    default:
                        break;
                }

                break;
            case 5:
                System.out.println("\n Merci Tp Ecrire et Editer Par Etudiant Mahdi Bentaleb ^ _ ^ \n");
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) throws ParseException {
        int i=1;
        String nomm,adress;
        Scanner in=new Scanner(System.in);
        System.out.println("Mon Atelier");
        System.out.println("Entrer : le nom d'atelier: ");
        nomm=in.nextLine();
        System.out.println("Entrer : adress d'atelier :");
        adress=in.nextLine();
        Atelier atelier=new Atelier(nomm,adress);
        int menu=1;
        do {
            System.out.println("\n Afficher Menu \n " + "\n 1-Oui" + "\n 2-Non");
            menu = in.nextInt();
            if (menu == 1) {
                atelier.operation();
            } else {
                in.close();
                break;
            }
        }while (menu!=1 || menu!=2);
    }
}
