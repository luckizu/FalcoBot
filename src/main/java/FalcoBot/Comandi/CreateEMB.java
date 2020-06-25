package FalcoBot.Comandi;

import Ranking.RankingSystem;

public class CreateEMB {

    String TITOLO;
    String[] Descizioneauto;

 public static String[] EMBauto(String TITOLO, String[] DATA){

     switch (TITOLO){

         case "/stat":
             int[] Max = RankingSystem.LevellMAX() ;

             String MaxLvl = String.valueOf(Max[Integer.parseInt(DATA[3])]);

             String Des = "Nome: " + DATA[0] + "       " + "Id: " + DATA[1] + "        " + "Nome d'arte: " + DATA[2]
                     + "\n" + "Livello: " +DATA[3]  + "        Punti: " + DATA[4] + "/" + MaxLvl;
             String Title = "Queste sono le tue statiche";
             String[] EMB = new String[2];
             EMB[0] = Title;
             EMB[1] = Des;
        return EMB;

         case "/help":
                int x = 0;
             Title = "Questi sono i comandi";
             String des = null;
             while (DATA[x] != null){
                 des = des + DATA[x];
                 x++;
                 des = des + ": " + DATA[x];
                 x++;


             }
            String[] Emb = new String[2];
             Emb[0] = Title;
             Emb[1] = des;
             return Emb;
     }
    return null;
 }
}
