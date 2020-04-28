package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import java.util.Date;

public class Evenement {

    public String nomeven;
    public Date Debutev;
    public Date finev;

    public Evenement(String nomeven, Date debutev, Date finev) {
        this.nomeven = nomeven;
        Debutev = debutev;
        this.finev = finev;
    }
     public boolean CheckDate (Date debut, Date fin)
    {
        boolean test=fin.after(debut);
        if(!test){
            return false;
        }else
        {
            return true;
        }
    }
    public void dureee(Date debut , Date fin)
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



}
