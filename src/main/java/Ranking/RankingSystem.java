package Ranking;


import java.util.Timer;
import java.util.TimerTask;

//Sistema di ranking del server
public class RankingSystem  {
    int secondi = 0;

    Timer Timer = new Timer();
    TimerTask Task = new TimerTask() {
        @Override
        public void run() {
            secondi++;
        }
    };

    int N;
    public void Start(){
        Timer.scheduleAtFixedRate(Task, 1000, 1000);


    }

    public static int[] AddM (int N, int lvl){
    //add per messaggio 10 pt
        N=+10;
        int [] LevelStat = LevelUp(lvl, N);
        return LevelStat;
    }

    public int AddV (){
        //add minuti per timer
        //TODO timer ed il resto

    return 0;

    }
    public static int[] LevelUp(int lvl, int N){
        int max = 100;
        int NewLvl;
        int[] Levelstat = new int[1];
        int[] MAX = LevellMAX();
        if (N>MAX[lvl]){
            NewLvl = lvl+1;

            N = N-MAX[lvl];

            Levelstat[0] = N;
            Levelstat[1] = NewLvl;


            return Levelstat;
        }
        else {
            NewLvl = lvl;
            Levelstat[0] = N;
            Levelstat[1] = NewLvl;

            return Levelstat;
        }



    }
public static int[] LevellMAX(){
    int[] LivelliMax = {0, 64, 640, 1280, 1920, 2560, 3200, 3840, 4480, 5120, 5760, 6400, 13440, 13568, 13632, 13696, 13760, 13824, 13888, 13952, 14016, 14080};


       return LivelliMax;
}
}

