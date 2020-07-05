package Database;

import Database.Ottinfolevel;

import java.io.*;

public class Livelli implements Serializable {
int Livello;
int MaxExp;
String Nome;



public Livelli(int Livello, int MaxExp, String Nome){
    this.Livello = Livello;
    this.MaxExp = MaxExp;
    this.Nome = Nome;


}
}
