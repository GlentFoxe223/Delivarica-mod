package MainMod;

import arc.graphics.Color;
import mindustry.game.Team;
import mindustry.type.TeamEntry;

public class DelivaricaTeams {
    public static Team vicious;
    public static TeamEntry viciousEntry;

    public static void load() {
        vicious = Team.get(78);
        vicious.name = "vicious";
        
        vicious.color.set(Color.valueOf("38d9c8"));

        vicious.palette[0] = Color.valueOf("82fff2");
        vicious.palette[1] = Color.valueOf("38d9c8");
        vicious.palette[2] = Color.valueOf("1d8f83");

        for (int i = 0; i < 3; i++) {
            vicious.palettei[i] = vicious.palette[i].rgba();
        }

        viciousEntry = new TeamEntry(vicious);
    }
}
