package com.company;

import sun.util.calendar.BaseCalendar;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.ParsePosition;

public class Personne {

    private String nom;
    private String prenom;
    private int age;
    public Agenda agenda;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;

    }

    public void operation(Agenda agenda) throws ParseException {
        int i;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choisir L'operation :" +
                "\n 1- Ajouter Evenement." +
                "\n 2- Supprimer Evenement." +
                "\n 3- Calcule Duree Even."+
                "\n 4- Recherche sur l'Evenement." +
                "\n 5- Afficher Calendrie." +
                "\n 6- Quitter.");
        do{
            i= scanner.nextInt();
        }while(i<0 || i>7);
        switch (i)
        {
            case 1:
                System.out.println("Entrer Nom de L'Evenement ");
                String n=scanner.next();

                if(n.equals(" ")){
                    System.out.println("Le nom est mot vide!");
                    break;
                }
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("la Date sur la forme (dd/MM/yyyy):\n ");
                Scanner scdate=new Scanner(System.in);
                System.out.println(" Entrer la date debut d'evenement :\n ");
                Date db = new Date();
                db=sdf.parse(scdate.nextLine());
                System.out.println(" Entrer la date Fin d'evenement :\n ");
                Date fin = sdf.parse(scdate.nextLine());
                boolean c= new Evenement(n, db, fin).CheckDate(db,fin);
                if(!c){
                System.out.println("La date est fausse!");
                break;
                }
                agenda.duree(db,fin);
                agenda.ajouterEvenement(n, db, fin);
                agenda.Affichage();

                break;
            case 2:
                System.out.println("Donner Nom de L'evenement pour supprimer:");
                String Nm=scanner.next();
                String rslt="";
                Date d=new Date(),f=new Date();
                for(Evenement e:agenda.caln){
                    if((e.nomeven).equals(Nm)){
                        d=e.Debutev;
                        f=e.finev;
                        rslt =e.nomeven;
                    }else{
                        rslt=" ";
                    }
                }

                if(!rslt.equals(Nm))
                {
                    System.out.println("L'Evenement n'existe pas.");
                }else{
                    agenda.suprimEvenement(rslt,d,f);
                }
                break;
            case 3:
                System.out.println("Entrer Nom de L'Evenement ");
                String nomm = scanner.next();
                Evenement a=agenda.rechercheEvenement(nomm);
                a.dureee(a.Debutev,a.finev);
                break;
            case 4:
                System.out.println("Recharche:");
                int aa;
                Scanner scaner = new Scanner(System.in);
                System.out.println(" \t \t \t \tChoisir L'operation :" +
                        "\n \t \t \t \t1- Recharche par Nom."+
                        "\n \t \t \t \t2- Quitter.");

                do {
                    aa = scaner.nextInt();
                } while (aa < 0 || aa > 3);
                switch (aa) {
                    case 1:
                        int dd=0;
                        Evenement ee;
                        String nommm="";
                        do{
                            System.out.println("\t \t \t \tEntrer Nom de L'Evenement ");
                        nommm = scanner.next();
                        ee=agenda.rechercheEvenement(nommm);

                        if(ee==null)
                        {
                            dd=1;
                        }else{dd=0;}
                        }while(dd!=0);

                        int tst;
                        Scanner scanerr = new Scanner(System.in);
                        System.out.println("\t \t \t \t \tChoisir L'operation :" +
                                "\n \t \t \t \t \t 1- Modifier L'evenement."+
                                "\n \t \t \t \t \t 2- Suprimmer L'evenement. "+
                                "\n \t \t \t \t \t 3- Quitter.");

                        do {
                            tst = scanerr.nextInt();
                        } while (tst < 0 || tst > 4);
                        switch (tst) {
                            case 1:
                                int tsst;
                                Scanner scanr = new Scanner(System.in);
                                System.out.println(" \t \t \t \t \t \t Choisir L'operation :" +
                                        "\n \t \t \t \t \t \t 1- Modifier Nom."+
                                        "\n \t \t \t \t \t \t 2- Modifier Date. "+
                                        "\n \t \t \t \t \t \t 3- Quitter.");

                                do {
                                    tsst = scanr.nextInt();
                                } while (tsst < 0 || tsst > 4);
                                switch (tsst) {
                                    case 1:
                                    System.out.println("\t \t \t \t \t \tDonner Nouveau Nom de L'evenement :");
                                    String Nnm=scanner.next();
                                    agenda.modifierEventNom(nommm,Nnm);
                                    break;
                                    case 2:

                                        SimpleDateFormat sdff=new SimpleDateFormat("dd/MM/yyyy");
                                        System.out.println("\t \t \t \t \t \tla Date sur la forme (dd/MM/yyyy):\n ");
                                        Scanner scdatte=new Scanner(System.in);
                                        System.out.println("\t \t \t \t \t \tDonner Nouvelle Date debut de L'evenement pour Modifier:");
                                        Date debutt =new Date();
                                        debutt= sdff.parse(scdatte.nextLine());
                                        System.out.println("\t \t \t \t \t \tDonner Nouvelle Date fin de L'evenement pour Modifier:");
                                        Date finn = sdff.parse(scdatte.nextLine());
                                        agenda.modifyEventDate(nommm,debutt,finn);

                                        break;
                                    case 3:
                                        break;
                                        default:
                                            break;
                                }

                                break;
                            case 2:
                                agenda.suprimEvenement(ee.nomeven,ee.Debutev,ee.finev);
                                break;

                                default:
                                    break;
                        }
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }

                break;

            case 5:
                System.out.println("Affiche Calandrie du M."+nom + " "+prenom+" :");
                agenda.Affichage();
                break;
            case 6:
                System.out.println("\n Merci Tp Ecrire et Editer Par Etudiant Mahdi Bentaleb ^ _ ^ \n");
                break;
            default:
                    break;
        }
    }
    public static void main(String[] args) throws ParseException {
        int i=1;
        Scanner in=new Scanner(System.in);
        ArrayList<Personne> personnes= new ArrayList<Personne>();
        System.out.println("Entrer : le Nom du personne:");
        String nomPer=in.nextLine();
        System.out.println("Entrer : le prenom du personne: ");
        String PrenomPer=in.nextLine();
        System.out.println("Entrer : l'age du personne :");
        int age=in.nextInt();
        Personne p=new Personne(nomPer,PrenomPer,age);
        personnes.add(p);
        System.out.println("Creer L'agenda du "+nomPer+ ' '+PrenomPer);
        System.out.println("Entrer : le nom du l'agenda :\n");
        String agd=in.next();
        p.agenda = new Agenda(agd);
        int menu=1;
        do {
            System.out.println("\n Afficher Menu \n " + "\n 1-Oui" + "\n 2-Non");
            menu = in.nextInt();
            if (menu == 1) {
                p.operation(p.agenda);
            } else {
                in.close();
                break;
            }
        }while (menu!=1 || menu!=2);
    }
}
