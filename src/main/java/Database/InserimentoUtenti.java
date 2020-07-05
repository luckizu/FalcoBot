package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InserimentoUtenti {


    String ruolo = "Fiocco";
    int lvl = 0;
    int exp = 0;
    int cout = 0;
    List<Utenti> Membri = new ArrayList<Utenti>();
    public InserimentoUtenti(String Utente, String id) {


        try {
            FileInputStream File = new FileInputStream(new DatabasePath().getPath());

            ObjectInputStream IN = new ObjectInputStream(File);

            System.out.println("Lettura");
            for(int x= 0; x<=File.available(); x++){

                Membri.add((Utenti) IN.readObject()) ;
                System.out.println(Membri.get(x).Nome);

            }
            IN.close();

            Membri.add(new Utenti(Utente, id, "ChinaAuuupa", 1, 0));
            FileOutputStream File1 = new FileOutputStream(new DatabasePath().getPath());
            ObjectOutputStream Out = new ObjectOutputStream(File1);
            System.out.println("Scrittura");
            for ( int x = 0; x<=Membri.size(); x++  ){

                Out.writeObject( Membri.get(x));

            }
            System.out.println("Scritto");
            Out.close();




    } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();

        }
}
}