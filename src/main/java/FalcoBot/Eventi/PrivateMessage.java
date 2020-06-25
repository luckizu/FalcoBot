package FalcoBot.Eventi;

import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.concurrent.TimeUnit;

public class PrivateMessage extends ListenerAdapter {
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().getName().equalsIgnoreCase("Luckizu")) {
            String Message = event.getMessage().getContentRaw().replace("/exp", "");
            if (event.getMessage().getContentRaw().equalsIgnoreCase("/stop")) {
              /*  event.getChannel().sendMessage("Boot Fermato").queue();
                try {
                    TimeUnit.SECONDS.sleep(10);
                  //  Startlaunch.Start();
                    System.exit(0);
                } catch (InterruptedException e) {
                    event.getChannel().sendMessage("errore").queue();
                } */
            event.getJDA().shutdownNow();
            }
        }
    }
}
