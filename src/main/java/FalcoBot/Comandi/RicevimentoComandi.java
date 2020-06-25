package FalcoBot.Comandi;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.io.IOException;


public class RicevimentoComandi extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] Messaggio = event.getMessage().getContentRaw().split("");
        if (event.getMember().getUser().isBot()) {
        } else if(Messaggio[0].equals("/") ) {
            String[] Text = event.getMessage().getContentRaw().split(" ");

            String Ruolo = event.getMember().getRoles().toString();
            String id = event.getMember().getUser().getName();
            try {


                String[] EMB = Comandi.EsecuzioneComandi(Text, id, Ruolo);
                String title = EMB[0];
                String Des = EMB[1];
                EmbedBuilder Em = new EmbedBuilder();
                Em.setTitle(title);
                Em.setDescription(Des);
                Em.setColor(0xffffff);
              event.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();
                System.out.println(Des);
            } catch (IOException e) {
                System.out.println("error");
            }

        }
    }


}
