package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

import java.io.Serializable;

public class Sniper extends Unite implements Serializable {
    public Sniper(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y, "s",250,0.1f,75,700,0.4f,3,10,"s"
        ,attackStrategy,owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
