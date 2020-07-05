package FalcoBot.Comandi;

import Database.OttenimentoLivelli;
import Database.OttenimentoUtenti;


import java.util.ArrayList;
import java.util.List;

public class CreateEMB {

List<String > EMB = new ArrayList<String>();
 public CreateEMB(String Nome){
            OttenimentoUtenti OTT = new OttenimentoUtenti(Nome);
           OttenimentoLivelli LVL = new OttenimentoLivelli(OTT.getLvl());
String lvl = OTT.getLvl() +"" ;

             EMB.add("Queste sono le tue statistiche");
             EMB.add("Nome");
             EMB.add(OTT.getNome());
             EMB.add("Id");
             EMB.add(OTT.getid());
             EMB.add("Nome d'arte");
             EMB.add(LVL.getRuolo());
             EMB.add("Livello");
             EMB.add(lvl);
             EMB.add("Exp");
             EMB.add(OTT.getexp()+ "/"+ LVL.getMaxExp());

}

public List<String> GetEMBauto(){


 return this.EMB;
 }
}
