package FalcoBot.Comandi;

/*import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Expl extends ListenerAdapter {
public void onGuildMessageReceived (GuildMessageReceivedEvent e){
    if (e.getMember().getUser().isBot()){
        return;
    } else {
        String Name = e.getMember().getUser().getId();
        e.getChannel().sendMessage(Name).queue();
        if (Name.equalsIgnoreCase("321684767626231819")) {
            TextChannel canale = e.getGuild().getTextChannelsByName("funzioni del bot", true).get(0);
            e.getChannel().sendMessage("funziona").queue();
            if (canale.equals("funzioni del bot")) {
                e.getChannel().sendMessage("funziona").queue();
                String[] Messaggio = e.getMessage().getContentRaw().split(" ");
                e.getMessage().delete().queue();
                e.getChannel().sendMessage(Messaggio(Messaggio)).queue();
                EmbedBuilder EMB = new EmbedBuilder();
                EMB.setTitle("Falcobot è stato aggiornato");
                EMB.setColor(0x0000ff);
                EMB.setDescription(Messaggio(Messaggio));
                e.getChannel().sendMessage(EMB.build()).queue();
            }
        }
    }
        }


        public static String Messaggio(String[] Messaggio){
        int x= 0;
        String Message = null;
    while(Messaggio[x] != null){
        Message = Message + " " + Messaggio[x];
        x++;
    }
        return Message;
        }
    */
