package Main;

import FalcoBot.Comandi.Comandi;
import FalcoBot.Comandi.ComandiLocale;
import FalcoBot.Eventi.IconRecieved;
import FalcoBot.Eventi.casdo;
import FalcoBot.SetBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Botmomentaneo extends JDABuilder {
JDA Falcobot;

Botmomentaneo(){

    try {
        Falcobot = new JDABuilder(new SetBot().GetBotToken()).build();

       // Falcobot.addEventListener(new ComandiLocale());
       // Falcobot.addEventListener(new IconRecieved());
        Falcobot.addEventListener(new casdo());






    } catch (LoginException e) {
        System.out.println("errore");
    }


}

}
