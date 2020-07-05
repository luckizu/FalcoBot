package FalcoBot.Comandi;

import Database.Config;
import Database.OttenimentoUtenti;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Comandi {


    List<String> EMB = new ArrayList<>();


    public List<String> EsecuzioneComandi (String Comando, String Nome, String Ruolo) {

        switch (Comando) {
            case "/help":
                this.EMB.add("Comandi disponibili");
                this.EMB.add("/stat");
                this.EMB.add("Comando per visualizzare le proprie statistiche");
                this.EMB.add("/join");
                this.EMB.add("Comando per richiedere l'accesso al canale I Rapaci");
                return this.EMB;

            case "/stat":

                this.EMB.addAll(new CreateEMB(Nome).GetEMBauto());


                return this.EMB;


        }

        return null;
    }
}






