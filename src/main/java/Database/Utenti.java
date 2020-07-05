package Database;

import java.io.Serializable;

public class Utenti implements Serializable {
    String Nome, id, ruolo;
    int Livello, experienza;

    public Utenti (String Nome, String id, String ruolo, int Livello, int experienza){

        this.Nome = Nome;
        this.id = id;
        this.ruolo = ruolo;
        this.Livello = Livello;
        this.experienza = experienza;

    }


    public String ToString(){

        return Nome + " " + id + " " + ruolo + " " + Livello + " " + experienza;
    }
}
