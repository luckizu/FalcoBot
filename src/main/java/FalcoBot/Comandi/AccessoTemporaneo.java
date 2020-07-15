package FalcoBot.Comandi;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collection;

public class AccessoTemporaneo extends ListenerAdapter {
    String Messaggio;
    String Emote;
    String id;
    Boolean Condizione = false;
    String Messaggio1;
    String Utente;
    String MemberId;
    Role Seguaci;
    Role Fan;
    String[] Concessi = new String[10];
    int cout = 0;
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e) {
        if (e.getUser().getName().equals("OlBelo") || e.getUser().getName().equals("gekrek") || e.getUser().getName().equals("Luckizu")) {
            if (Messaggio.equals(Utente + " ha richiesto di collegarsi al canale I rapaci")) {
                this.Fan = e.getGuild().getRolesByName("Fan del Rapacio", false).get(0);
                this.Emote = e.getReactionEmote().getId();
                if (Emote.equals("725351298525954048")) {
                    System.out.println("True");
                    this.Messaggio = "";
                    this.Condizione = true;
                    e.getChannel().deleteMessageById(id).queue();

                    e.getGuild().addRoleToMember(MemberId, Fan).queue();
                    Concessi[cout] = MemberId;
                    this.cout++;
                } else if (Emote.equals("725351310387314720")) {
                    System.out.println("False");
                    this.Messaggio = "";
                    this.Condizione = true;

                    e.getChannel().deleteMessageById(id).queue();

                }

            }

        }
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        this.Messaggio1 = e.getMessage().getContentRaw();
        this.Seguaci = e.getGuild().getRolesByName("Seguaci del Rapacio", false).get(0);

        String[] Mes = Messaggio1.split("");
        if (Mes[0].equals("/")) {
            if (this.Messaggio1.equals("/join") || Messaggio1.equals("/Join")) {
                this.Utente = e.getAuthor().getName();
                e.getGuild().getDefaultChannel().sendMessage(Utente + " ha richiesto di collegarsi al canale I rapaci").queue();
                e.getMessage().delete().queue();
                this.MemberId = e.getAuthor().getId();
                this.Messaggio1 = "";


            } else if (Messaggio1.equals("/giphy") || Messaggio1.equals("/tenor") || Messaggio1.equals("/tts") || Messaggio1.equals("/me") || Messaggio1.equals("/tableflip") || Messaggio1.equals("/unflip") || Messaggio1.equals("/shrug") || Messaggio1.equals("/spoiler") || Messaggio1.equals("/nick")) {


            }

        }


        String cas = e.getMessage().getContentRaw();
        if (cas.equals(Utente+ " ha richiesto di collegarsi al canale I rapaci")) {
            System.out.println("Funz");
            this.Messaggio = cas;
            this.id = e.getMessage().getId();
            System.out.println(this.id);
        }

    }

    public void onGuildVoiceLeave (GuildVoiceLeaveEvent e){
       String leaveid = e.getChannelLeft().getId();
       System.out.println(leaveid);
       if(leaveid.equals("570184258124120064")){
           for (int x = 0; x<cout; x++){
               if(e.getMember().getId().equals(Concessi[x])){
                   e.getGuild().removeRoleFromMember(MemberId, Fan).queue();
               }
           }
       }
    }
}
