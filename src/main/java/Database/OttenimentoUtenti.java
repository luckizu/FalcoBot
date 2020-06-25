package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OttenimentoUtenti {

    public String[] Ottenimento(String Nome){

        String[] NomeUtente = new String[5];
        String Utente1;
        try {

            FileInputStream IN = new FileInputStream("DataBase.dat");

            try {

                ObjectInputStream Lett = new ObjectInputStream(IN);

                while (NomeUtente[0] != Nome){

                    Utente1 = Lett.readUTF();
                    NomeUtente = Utente1.split(" ");



                }
                Lett.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return NomeUtente;
    }
}
