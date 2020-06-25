package FalcoBot.Comandi;

import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ComandiLocale extends ListenerAdapter {
    String Messaggio1;
    String Canale = "Global";
    String Utente;
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        this.Messaggio1= e.getMessage().getContentRaw();
        this.Utente = e.getAuthor().getName();
        String[] Mes = Messaggio1.split("");
        if(Mes[0].equals("/")){
        if(this.Messaggio1.equals("/join") || Messaggio1.equals("/Join")) {
            e.getGuild().getDefaultChannel().sendMessage(Utente + " ha richiesto di collegarsi al canale I rapaci").queue();
            e.getMessage().delete().queue();


        } else if(Messaggio1.equals("/giphy")|| Messaggio1.equals("/tenor")|| Messaggio1.equals("/tts") || Messaggio1.equals("/me")|| Messaggio1.equals("/tableflip")|| Messaggio1.equals("/unflip")|| Messaggio1.equals("/shrug")|| Messaggio1.equals("/spoiler")|| Messaggio1.equals("/nick")){


        } else {
            e.getChannel().sendMessage("Comando errato").queue();

        }

        }

    }
}
