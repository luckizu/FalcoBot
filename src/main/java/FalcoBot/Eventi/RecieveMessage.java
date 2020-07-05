package FalcoBot.Eventi;

import Database.OttenimentoUtenti;
import FalcoBot.Comandi.Comandi;
import Ranking.AddExpTxt;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RecieveMessage  extends ListenerAdapter {
    String Utente;


    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals("/help") || e.getMessage().getContentRaw().equals("/stat")) {

        } else {
            System.out.println("Messaggio ricevuto");
            this.Utente = e.getAuthor().getName();
            AddExpTxt Add = new AddExpTxt(this.Utente);

            if (Add.getLivellato()) {
                OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                EmbedBuilder Em = new EmbedBuilder();
                if (Add.getCambioRuolo()) {
                    Em.setTitle(Utente + " é salito di livello");
                    Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                    Em.setColor(0x3333ff);
                    e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                } else {
                    Em.setTitle(Utente + " é salito di livello");
                    Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                    Em.setColor(0x3333ff);
                    e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                }

            }


        }
    }
}
