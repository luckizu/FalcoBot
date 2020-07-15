package FalcoBot.Eventi;

import Database.AggiornamentoVoice;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Voice extends ListenerAdapter {
    String Membri;
    AggiornamentoVoice cs = new AggiornamentoVoice();

    public void onGuildVoiceJoin(GuildVoiceJoinEvent e) {
        if(e.getChannelJoined().getName().equals("dioporco")){
            System.out.println("canale afk");
        } else {
            Membri = e.getMember().getEffectiveName();
            System.out.println("Entrato");
            cs.setMembri(Membri);
        }



    }


    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e) {
        if(e.getChannelLeft().getName().equals("diocane")){

        } else {


            Membri = e.getMember().getEffectiveName();
            cs.removeMembri(Membri);
        }

    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent e){
        System.out.println("Utente mosso");
        if(e.getChannelJoined().getId().equals("570197389034651648")){
                Membri = e.getMember().getEffectiveName();
                cs.removeMembri(Membri);


            } else if(e.getChannelLeft().getId().equals("570197389034651648")) {
                Membri = e.getMember().getEffectiveName();
                cs.setMembri(Membri);
            }


    }
}



