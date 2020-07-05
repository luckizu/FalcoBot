package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AggiornamentoUtente {
    List<Utenti> Membri = new ArrayList<>();
    int cout;
    public AggiornamentoUtente(String Nome, String id, String Ruolo, int lvl, int exp){

        try {
            System.out.println("Aggiornamento");
            FileInputStream File = new FileInputStream(new DatabasePath().getPath());

            ObjectInputStream IN = new ObjectInputStream(File);

            for (int x = 0; x < File.available(); x++) {

                Membri.add((Utenti) IN.readObject());
                if (Membri.get(x).Nome.equals(Nome)) {
                    System.out.println(Membri.get(x).Nome + " ottenimento");
                    this.cout = x;
                }

            }
            IN.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Membri.set(cout, new Utenti(Nome, id, Ruolo, lvl, exp));
try {
            FileOutputStream File1 = new FileOutputStream(new DatabasePath().getPath());
            ObjectOutputStream Out = new ObjectOutputStream(File1);
            System.out.println(Membri.get(cout).experienza + " esp cout " + cout);
            Out.flush();

            for ( int x = 0; x<Membri.size(); x++  ){
                System.out.println(Membri.get(x).Nome);
                Out.writeObject( Membri.get(x));


            }

            Out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
