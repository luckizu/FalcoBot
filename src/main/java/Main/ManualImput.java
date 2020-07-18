package Main;

import Database.DatabasePath;
import Database.Livelli;
import Database.LivelliPath;
import Database.Utenti;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManualImput {

List<Integer> lvl = new ArrayList<Integer>(100);
List<Integer> Capexp = new ArrayList<>(100);
List<String> Ruoli = new ArrayList<>(100);
final int exp = 1000;

List<Livelli> LVL = new ArrayList<Livelli>();
    public ManualImput(){
        for(int x = 0; x<100; x++){
            int n = x;
            lvl.add(x, n);
            System.out.println(lvl.get(x));

        }
        for(int x = 0; x<100; x++){
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
        for(int x = 25; x<30; x++){

            Ruoli.add(x,"Pirata");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 30; x<35; x++){

            Ruoli.add(x,"Camper");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 35; x<40; x++){

            Ruoli.add(x,"Buldozzero");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 40; x<45; x++){

            Ruoli.add(x,"Porcellone");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 45; x<50; x++){

            Ruoli.add(x,"Hentai");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 50; x<55; x++){

            Ruoli.add(x,"Clashone");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 55; x<60; x++){

            Ruoli.add(x,"Biscio");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 60; x<65; x++){

            Ruoli.add(x,"Facki");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 65; x<70; x++){

            Ruoli.add(x,"Gestore dello spazio");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 70; x<75; x++){

            Ruoli.add(x,"Bazoookaa");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 75; x<80; x++){

            Ruoli.add(x,"Ricciolino");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 80; x<85; x++){

            Ruoli.add(x,"Bel Prosciuttone");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 85; x<90; x++){

            Ruoli.add(x,"RANDOMICO");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 90; x<95; x++){

            Ruoli.add(x,"PERMASTUN");
            System.out.println(x+1 + Ruoli.get(x));
        }
        for(int x = 95; x<99; x++){

            Ruoli.add(x,"Sviluppatore");
            System.out.println(x+1 + Ruoli.get(x));
        }

        Ruoli.add(99,"L'ELEMENTO");
        System.out.println(99 + Ruoli.get(99));

        for(int x = 0; x<100; x++){

            LVL.add(x, new Livelli(lvl.get(x), Capexp.get(x), Ruoli.get(x)));

        }

        try{
            FileOutputStream out = new FileOutputStream(new LivelliPath().getPath());
            ObjectOutputStream Out = new ObjectOutputStream(out);
            for(int x= 1-1; x<=100-1; x++){

            Out.writeObject(LVL.get(x));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int x = 0; x<100; x++){

            System.out.println(LVL.get(x).toString());


        }

    }



}
