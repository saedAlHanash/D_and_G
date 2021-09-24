package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class GrandCannon extends Unite {
    public GrandCannon(Player owner, int x, int y , AttackStrategy attackStrategy) {
        super(Id,x, y,"S",6500,0.3f,150,400,0.9f,40,0,"st"
                , attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
