package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class Config  {


    public static String getDirectory() {
    //Prende La posizione del programma

        String Directory = FileReading(1);



    return Directory;
    }


    public static String getToken(){
    //Prende il token per l'avvio del bot
        String Token =FileReading(2);

        return Token;
    }

    public  String[] getCommand() {
        int x = 0;
        int z = 0;
        String[] Conf = new String[1000000000];
        String[] Comandi = new String[1000000000];
        String[] Spiegazioni = new String[1000000000];
        try {
            ObjectInputStream In = new ObjectInputStream(new FileInputStream("Config.cf"));
            Conf[x] = In.readUTF();
            while (Conf[x] != "Command") {
                ++x;
                Conf[x] = In.readUTF();

            }
        while (Conf[x] != null){
            ++x;
            Conf[x] = In.readUTF();
            Comandi[z] = Conf[x];
            ++x;
            Conf[x] = In.readUTF();
            Spiegazioni[z] = Conf[x];
            z++;


        }




        } catch (IOException e){


        }
        String[] Descizione = new String[1000000000];
        int y = 0;
        int i = 0;
        while (Comandi[y] != null){
            Descizione[i] = Comandi[y];
            i++;
            Descizione[i] = Spiegazioni[y];
            y++;
            i++;


        }
        return Descizione;
    }


    // TODO Spazio lasciato per eventuali aggiunte







    public static String FileReading(int x){
        String [] cf =  new String[x];
        try {
            ObjectInputStream Config = new ObjectInputStream(new FileInputStream("Config.cf"));

            for (int i = 0; i<x; i++ ){
               cf[i] = Config.readUTF();

            }
            Config.close();

            return cf[x-1];

        } catch (IOException e) {
            System.out.println("error");
            return null;
        }


    }


}
