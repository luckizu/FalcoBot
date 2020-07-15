package Database;

import java.io.Serializable;

public class Utenti implements Serializable {
    public String Nome;
   public   String id, ruolo;
   public int Livello, experienza;
    private static final long serialVersionUID = -4704511417355895239L;
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
