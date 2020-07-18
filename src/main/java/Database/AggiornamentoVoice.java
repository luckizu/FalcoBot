package Database;


import Main.BOTmain;
import Ranking.LVLUP;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AggiornamentoVoice {
Map<String, Integer> Tempi = new HashMap<>();
List<String> Membri = new ArrayList<>();
Timer timer;
    TimerTask task;
    Boolean Started = false;
    int time;
     int lvl;
     int exp;
     int MaxExp;
     String id;
     String Ruolo;
     Boolean Livellato;
     Boolean CambioRuolo;


public void setMembri(String Membro){

    if(Started){
        System.out.println("Gia partito");
        this.Membri.add(Membro);
        this.Tempi.put(Membro, time);

    } else {
       this.time = 0;
       System.out.println("In partenza");
        this.Membri.add(Membro);
        this.Tempi.put(Membro, 0);

        this.Started = true;
        Start();
    }
}

private void Start(){
     timer =new Timer();
    task = new TimerTask() {

        @Override
        public void run() {
            time = time+10;
            List<Integer> TEM = new ArrayList<>();
            for(int x = 0; x<Membri.size(); x++){
                TEM.add(time - Tempi.get(Membri.get(x)));
                OttenimentoUtenti OU = new OttenimentoUtenti(Membri.get(x));
                OttenimentoLivelli OL = new OttenimentoLivelli(OU.getLvl());
                System.out.println(Membri.get(x)+ " Ha il tempo di " + TEM.get(x));
                lvl = OU.getLvl();
                exp = OU.getexp() + AddExp(TEM.get(x));
                MaxExp = OL.getMaxExp();
                id = OU.getid();
                Ruolo = OL.getRuolo();

                LVLUP Up = new LVLUP(lvl,exp,MaxExp);
                if(Up.getSalito() & lvl != 100){
                    exp = Up.getExpSup();
                    System.out.println("Salito");
                    System.out.println(exp+ "aggiuntiva");
                    lvl++;
                    OttenimentoLivelli OT = new OttenimentoLivelli(lvl);
                    AggiornamentoUtente ag = new AggiornamentoUtente(Membri.get(x), id, OT.getRuolo(), lvl, exp);
                    System.out.println(OT.getRuolo() != Ruolo);
                    Livellato = true;
                    if(lvl == 6 || lvl == 11 || lvl == 16 || lvl == 21 || lvl == 26 || lvl == 31 || lvl == 36 || lvl == 41 || lvl == 46 || lvl == 51 || lvl == 56 || lvl ==61 || lvl == 66 || lvl == 71 || lvl== 76 || lvl==81 || lvl== 86 || lvl == 91 || lvl == 96 || lvl == 100){
                        Print(x);
                        Ruolo = OT.getRuolo();
                        System.out.println("true");
                        CambioRuolo = true;

                    } else {
                        Print(x);
                        CambioRuolo = false;

                    }


                } else {
                    Livellato = false;

                    if (lvl == 100) {
                        System.out.println("Cap Massimo");

                        AggiornamentoUtente AG = new AggiornamentoUtente(Membri.get(x), id, Ruolo, lvl, MaxExp);
                        CambioRuolo = false;


                    } else {
                        System.out.println("Cap non massimo");
                        AggiornamentoUtente AG = new AggiornamentoUtente(Membri.get(x), id, Ruolo, lvl, exp);
                        CambioRuolo = false;

                    }

                }

            }


            }




    };
    timer.scheduleAtFixedRate(task, 10000, 10000);


}

public void removeMembri(String Membro){
int cout = 0;
    for(int x = 0; x<Membri.size(); x++){
        if(Membri.get(x).equals(Membro)){
            cout = x;
            System.out.println("trovato");
        }

    }

    this.Tempi.remove(Membri.get(cout));
    this.Membri.remove(cout);

            if(Membri.size()== 0){
                timer.cancel();
                this.Started = false;
            }


    }

    private int AddExp(int caso){
    int EXP = 0;
    System.out.println(caso);
if(caso > 7200) {
    EXP = 90;
    System.out.println("EXP " + EXP);

    return EXP;
} else if (caso > 3600) {
        EXP = 45;
        System.out.println("EXP " + EXP);

    return EXP;
    } else if (caso > 1800){

            EXP = 24;
            System.out.println("EXP " + EXP);
    return EXP;

        } else if (caso > 600){

                EXP = 9;
                System.out.println("EXP " + EXP);
    return EXP;

            } else {

                EXP = 3;
                System.out.println("EXP " + EXP);
    return EXP;
            }

    }



    public void Print(int x){
       try {
           FileOutputStream File = new FileOutputStream(new File("C:\\Users\\luckizu\\Documents\\FalcoBot\\caso.dat"));
           ObjectOutputStream Out = new ObjectOutputStream(File);
            System.out.println("Scrittura");
           Out.writeUTF(Membri.get(x));
           String Livello = String.valueOf(lvl);
           Out.writeUTF(Livello);
           if(lvl == 6 || lvl == 11 || lvl == 16 || lvl == 21 || lvl == 26 || lvl == 31 || lvl == 36 || lvl == 41 || lvl == 46 || lvl == 51 || lvl == 56 || lvl ==61 || lvl == 66 || lvl == 71 || lvl== 76 || lvl==81 || lvl== 86 || lvl == 91 || lvl == 96 || lvl == 100){
               System.out.println("vero");
               Out.writeUTF(this.Ruolo);
           } else {
               System.out.println("Falso");
           }


            Out.close();



       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


    }

    }




