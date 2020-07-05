package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OttenimentoUtenti {

List<Utenti> Membri = new ArrayList<Utenti>();
int cout = 0;
int caso;
    String Nome;
    public OttenimentoUtenti(String Utente){


        try {

            FileInputStream FL = new FileInputStream(new DatabasePath().getPath());
                System.out.println("diocane");



            ObjectInputStream Lett = new ObjectInputStream(FL);
            System.out.println("funz");
            do {

                Membri.add((Utenti) Lett.readObject());
                this.Nome = Membri.get(cout).Nome;
                System.out.println(Nome);
                cout++;
                if (Nome.equals(Utente)) {
                    System.out.println(Nome);
                    this.caso = cout-1;

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

    public String getNome(){

        System.out.println(this.Membri.get(caso).Nome);
        return this.Membri.get(caso).Nome;
    }

    public String getid(){
System.out.println(this.Membri.get(caso).id);
        return this.Membri.get(caso).id;
    }

    public String getRuolo(){
        System.out.println(this.Membri.get(caso).ruolo);
        return this.Membri.get(caso).ruolo;
    }

    public int getLvl(){
        System.out.println(this.Membri.get(caso).Livello);
        return this.Membri.get(caso).Livello;
    }

    public int getexp(){
        System.out.println(this.Membri.get(caso).experienza);
        return this.Membri.get(caso).experienza;
    }
}
