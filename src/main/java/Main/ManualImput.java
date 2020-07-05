package Main;

import Database.DatabasePath;
import Database.Livelli;
import Database.LivelliPath;
import Database.Utenti;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManualImput {

List<Integer> lvl = new ArrayList<Integer>();
List<Integer> Capexp = new ArrayList<>();
List<String> Ruoli = new ArrayList<>();
final int exp = 1000;

List<Livelli> LVL = new ArrayList<Livelli>();
    public ManualImput(){
        for(int x = 0; x<30; x++){
            int n = x;
            lvl.add(x, n);
            System.out.println(lvl.get(x));

        }
        for(int x = 0; x<30; x++){
            Integer Livello = lvl.get(x);
            System.out.println(Livello);
            int sup = Livello/5;
            System.out.println(sup);
            int cas = sup * exp;
            System.out.println(cas);
            int sum = exp+ cas;
            Capexp.add(sum);
            System.out.println(sum);

            System.out.println("Il valore di " +Livello+ "é di " +sum);
        }

        for(int x = 0; x<5; x++){

            Ruoli.add( x, "ChinaAuuupa");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 5; x<10; x++){

            Ruoli.add(x,"Ascellone");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 10; x<15; x++){

            Ruoli.add(x,"Nababbo");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 15; x<20; x++){

            Ruoli.add(x, "Fiocchetto");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 20; x<25; x++){

            Ruoli.add(x,"Signor Magi");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 25; x<29; x++){

            Ruoli.add(x,"Pirata");
            System.out.println(x+1 + Ruoli.get(x));
        }

        Ruoli.add(29,"L'ELEMENTO");
        System.out.println(30 + Ruoli.get(29));

        for(int x = 0; x<30; x++){

            LVL.add(x, new Livelli(lvl.get(x), Capexp.get(x), Ruoli.get(x)));

        }

        try{
            FileOutputStream out = new FileOutputStream(new LivelliPath().getPath());
            ObjectOutputStream Out = new ObjectOutputStream(out);
            for(int x= 1-1; x<=30-1; x++){

            Out.writeObject(LVL.get(x));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int x = 0; x<30; x++){

            System.out.println(LVL.get(x).toString());


        }

    }



}
