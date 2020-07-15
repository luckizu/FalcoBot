package Database;

import Ranking.LVLUP;
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
        this.Membri.add(Membro);
        this.Tempi.put(Membro, time);

    } else {
       this.time = 0;
        this.Membri.add(Membro);
        this.Tempi.put(Membro, 0);
        Start();
        this.Started = true;
    }
}

private void Start(){
     timer =new Timer();
    task = new TimerTask() {

        @Override
        public void run() {
            time = time+4;
            List<Integer> TEM = new ArrayList<>();
            for(int x = 0; x<Membri.size(); x++){
                TEM.add(time - Tempi.get(Membri.get(x)));
                OttenimentoUtenti OU = new OttenimentoUtenti(Membri.get(x));
                OttenimentoLivelli OL = new OttenimentoLivelli(OU.getLvl());

                lvl = OU.getLvl();
                exp = OU.getexp() + AddExp(TEM.get(x));
                MaxExp = OL.getMaxExp();
                id = OU.getid();
                Ruolo = OL.getRuolo();

                LVLUP Up = new LVLUP(lvl,exp,MaxExp);
                if(Up.getSalito() & lvl != 30){
                    exp = Up.getExpSup();
                    System.out.println("Salito");
                    System.out.println(exp+ "aggiuntiva");
                    lvl++;
                    OttenimentoLivelli OT = new OttenimentoLivelli(lvl);
                    AggiornamentoUtente ag = new AggiornamentoUtente(Membri.get(x), id, OT.getRuolo(), lvl, exp);
                    System.out.println(OT.getRuolo() != Ruolo);
                    Livellato = true;
                    if(lvl == 6 || lvl == 11 || lvl == 16 || lvl == 21 || lvl == 26 || lvl == 30){
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

                    if (lvl == 30) {
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
    timer.scheduleAtFixedRate(task, 4000, 4000);


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

    private int AddExp(int Time){
    int exp;
if(Time < 600) {
    exp = 1;
    return exp;

} else if(Time < 1.800) {
    exp = 3;
    return exp;

} else if(Time < 3.600) {
    exp = 8;
    return exp;

} else if(Time < 7.200) {
    exp = 15;
    return exp;

} else {

    exp = 30;
    return exp;
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
           if(lvl == 6 || lvl == 11 || lvl == 16 || lvl == 21 || lvl == 26 || lvl == 30){
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




