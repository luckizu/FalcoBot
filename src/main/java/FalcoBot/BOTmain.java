package FalcoBot;

import FalcoBot.Comandi.ComandiLocale;
import FalcoBot.Comandi.RicevimentoComandi;
import FalcoBot.Eventi.*;
import Launcher.Event;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import okhttp3.OkHttpClient;
//import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class BOTmain extends JDABuilder {

    JDA FalcoBot;
    EventWaiter Waiter = new EventWaiter();
    boolean ONOFF;

    public void StartBot() {

     /*   {
            try {
                FalcoBot = new JDABuilder(SetBot.SetBotToken(ONOFF.getMain())).build();
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
*/
        try {
            FalcoBot = new JDABuilder(SetBot.Token(true)).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }


        FalcoBot.addEventListener(new Join());
            FalcoBot.addEventListener(new Leave());
            FalcoBot.getPresence().setStatus(OnlineStatus.ONLINE);
            //      FalcoBot.getPresence().setGame(Game.playing("Volando sopra i cieli"));
            //  Bot.addEventListener(new Expl());
            FalcoBot.addEventListener(new RicevimentoComandi());
            FalcoBot.addEventListener(new PrivateMessage());
            FalcoBot.addEventListener(new Rename());
        FalcoBot.getPresence().setStatus(OnlineStatus.ONLINE);

        ONOFF = true;






        }
        public void Close(){



        }


    }

