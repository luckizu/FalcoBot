package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RilevamentoUtente {
    boolean Presente = false;
    String Nome;
    int cout = 0;
List <Utenti> Membri =  new ArrayList<>();
    public RilevamentoUtente(String Utente) {

        try {
            File File = new DatabasePath().getPath();
            if(File.exists()){
                System.out.println("diocane");

            }
            ObjectInputStream Lett = new ObjectInputStream(new FileInputStream(File));
            System.out.println("funz");
do {

    Membri.add((Utenti) Lett.readObject());
    this.Nome = Membri.get(cout).Nome;
    System.out.println(Nome);
    cout++;
    if (Nome.equals(Utente)) {
        System.out.println(Nome);
        this.Presente = true;

    }
}             while (Nome != null);


          Lett.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public boolean GetPresente() {
        return this.Presente;
    }
}
