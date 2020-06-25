package FalcoBot.Eventi;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.Random;

public class Leave extends ListenerAdapter {
    String[] Lista = {"[Membro] ci ha lasciato", "[Membro] ha perso le ali", "[Membro] ha finito il booost", "[Membro] è inciampato e ci ha lasciato"};
    public void onGuildMemberLeave (GuildMemberLeaveEvent e){
        Random r = new Random();
        int x = r.nextInt(Lista.length);
        EmbedBuilder Emb = new EmbedBuilder();
        Emb.setDescription(Lista[x].replace("[Membro]", e.getMember().getUser().getAsMention()));
        Emb.setColor(0x00C7C0);


        e.getGuild().getDefaultChannel().sendMessage(Emb.build()).queue();
      /* try {
           Data4Contain.LeaveExcution(e.getMember().getUser().getName());
       } catch (IOException z){
           System.out.println("errore");
       }*/
    }

}
