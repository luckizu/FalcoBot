package FalcoBot.Eventi;

import Database.DatabasePath;
import Database.InserimentoUtenti;
import Database.RilevamentoUtente;
import FalcoBot.Comandi.Comandi;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControlloUtenti extends ListenerAdapter {
    String Utente;
    String id;

    public void onUserUpdateOnlineStatus (UserUpdateOnlineStatusEvent e){

           this.Utente = e.getMember().getEffectiveName();



        this.id = e.getMember().getId();
        System.out.println(this.Utente);
        if(new DatabasePath().getPath().exists()){
            System.out.println("Il file esiste");
            if(new RilevamentoUtente(this.Utente).GetPresente()){
                System.out.println("Esiste");

                return;
            } else {
                System.out.println("non esiste");
                InserimentoUtenti INS = new  InserimentoUtenti(Utente, id );

            }
        } else {

            System.out.println("file inesistente");
        }



    }


}
