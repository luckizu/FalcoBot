package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Ottinfolevel {
    String[] info = new String[2];
    String path = "lvlinfo.inf";

    public Ottinfolevel(String lvl, Boolean surnchange){

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            String lvllett = "";
            while (lvl == lvllett){
                lvllett = in.readUTF();
            }
            for(int x = 0; x<2; x++){
                this.info[x] = in.readUTF();
            }
        } catch (IOException e){

        }
    }

    public String[] getInfo() {
        return info;
    }
}
