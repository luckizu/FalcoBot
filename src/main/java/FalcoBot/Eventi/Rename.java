package FalcoBot.Eventi;

import Database.InserimentoUtenti;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Rename extends ListenerAdapter {
    /*
    public void onUserUpdateName(UserUpdateNameEvent e) {
        String OldName = e.getOldName();
        String NewName = e.getNewName();
        InserimentoUtenti.Rename(OldName, NewName);

    }

    public void onGuildUpdateName(GuildUpdateNameEvent e) {
        String OldName = e.getOldName();
        String NewName = e.getNewName();
        InserimentoUtenti.Rename(OldName, NewName);
    }
  /*  public void onGuildMemberNickChange (GuildMemberNickChangeEvent event){
        String OldName = event.getPrevNick();
        String NewName = event.getNewNick();
        Utenti.Rename(OldName, NewName);
        event.getGuild().getDefaultChannel().sendMessage(OldName + NewName).queue();
        event.getGuild().getDefaultChannel().sendMessage("efeawpsf").queue();

    }
}
*/
}