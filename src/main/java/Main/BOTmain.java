package Main;

import FalcoBot.Comandi.AccessoTemporaneo;
import FalcoBot.Comandi.ComandiLocale;
import FalcoBot.Comandi.RicevimentoComandi;
import FalcoBot.Eventi.*;
import FalcoBot.SetBot;
import Launcher.Event;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import okhttp3.OkHttpClient;
//import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class BOTmain extends JDABuilder {

  JDA FalcoBot;

public BOTmain(){




        try {
            FalcoBot = new JDABuilder(new SetBot().GetBotToken()).build();

            FalcoBot.addEventListener(new AccessoTemporaneo());
            FalcoBot.addEventListener(new Join());
            FalcoBot.addEventListener(new Leave());
            FalcoBot.getPresence().setStatus(OnlineStatus.ONLINE);
            FalcoBot.addEventListener(new RicevimentoComandi());
            FalcoBot.getPresence().setActivity(Activity.listening("Volando sopra i cieli"));
         //   FalcoBot.addEventListener(new Rename());
            FalcoBot.addEventListener(new ControlloUtenti());
            FalcoBot.addEventListener(new RecieveMessage());
        } catch (LoginException e) {
            System.out.println("errore");
        }



        }


}

