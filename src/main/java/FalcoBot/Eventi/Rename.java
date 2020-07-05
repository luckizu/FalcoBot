package FalcoBot.Eventi;

import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Rename extends ListenerAdapter {

    public void onUserUpdateName(UserUpdateNameEvent e) {
        String OldName = e.getOldName();
        String NewName = e.getNewName();
     //   CambioNome CN = new CambioNome(OldName, NewName);

    }

}