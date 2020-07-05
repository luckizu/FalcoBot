package FalcoBot.Comandi;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class RicevimentoComandi extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] Messaggio = event.getMessage().getContentRaw().split("");
        if (event.getMember().getUser().isBot()) {
        } else if(Messaggio[0].equals("/") ) {
         String Comando = event.getMessage().getContentRaw();
            String Nome = event.getAuthor().getName();
            String Ruolo = event.getMember().getRoles().toString();
            String id = event.getMember().getUser().getName();

            Comandi com = new Comandi();
            List<String> Field = new ArrayList<>();
            Field.addAll(com.EsecuzioneComandi(Comando, Nome, Ruolo));
            EmbedBuilder Em = new EmbedBuilder();
            Em.setTitle(Field.get(0));
            Em.setColor(0x3333ff);
if(Comando.equals("/help")){
    System.out.println("Help");
    Em.addField(new MessageEmbed.Field(Field.get(1), Field.get(2), true));
    Em.addField(new MessageEmbed.Field(Field.get(3), Field.get(4), true));
    event.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();
} else if(Comando.equals("/stat")){
        System.out.println("stat");
    Em.addField(new MessageEmbed.Field(Field.get(1), Field.get(2), true));
    Em.addField(new MessageEmbed.Field(Field.get(3), Field.get(4), true));
    Em.addField(new MessageEmbed.Field(Field.get(5), Field.get(6), true));
    Em.addField(new MessageEmbed.Field(Field.get(7), Field.get(8), true));
    Em.addField(new MessageEmbed.Field(Field.get(9), Field.get(10), true));
    event.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();
}




        }
    }


}
