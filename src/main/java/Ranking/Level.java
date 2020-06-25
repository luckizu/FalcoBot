package Ranking;

import Database.Ottinfolevel;

import java.io.*;

public class Level {
    String maxExp;
    String lvl;
    String surname;
    Boolean surnsetmanualy;
    public Level(String lvl, String surnmanual, Boolean surnsetmanualy){
        this.lvl = lvl;
        this.surnsetmanualy = surnsetmanualy;


            String[] info = new Ottinfolevel(lvl, surnsetmanualy).getInfo();
            this.maxExp = info[0];
        if(surnsetmanualy){
            this.surname = surnmanual;
        } else {
            this.surname = info[1];
        }

    }


}
