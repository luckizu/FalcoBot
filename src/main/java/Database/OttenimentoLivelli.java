package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OttenimentoLivelli {

    List<Livelli> Lvl = new ArrayList<>();
    int LVL;
    int cout = 0;
public OttenimentoLivelli(int Livello){

try {
    FileInputStream File  = new FileInputStream(new LivelliPath().getPath());
    ObjectInputStream IN = new ObjectInputStream(File);

    do {
        Lvl.add((Livelli) IN.readObject());
        LVL = Lvl.get(cout).Livello;
        cout++;
    }
    while (LVL != Livello-1);
    IN.close();

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}


}
    public int getMaxExp(){

return this.Lvl.get(cout-1).MaxExp;
    }
    public String getRuolo(){

    return this.Lvl.get(cout-1).Nome;
    }
}
