package FalcoBot.Eventi;

import Database.InserimentoUtenti;
import Database.Utenti;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.Random;

public class Join extends ListenerAdapter {
    String Lista[] = {"[Membro] si è unito ai rapaci", "[Membro] è diventato un tartufo", "[Membro] si è unito al party", "[Membro] Not Nexy this is Sexy" };
    public void onGuildMemberJoin (GuildMemberJoinEvent e) {
        Random r = new Random();
        int x = r.nextInt(Lista.length);
        EmbedBuilder Emb = new EmbedBuilder();
        Emb.setDescription(Lista[x].replace("[Membro]", e.getMember().getUser().getAsMention()));
        Emb.setColor(0x00bb2d);


     e.getGuild().getDefaultChannel().sendMessage(Emb.build()).queue();

    }
}
