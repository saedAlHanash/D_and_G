package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class Pillbox extends Unite {
    public Pillbox(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y, "S",4000,0.7f,100,200,0.7f,40,0,"s"
                , attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
