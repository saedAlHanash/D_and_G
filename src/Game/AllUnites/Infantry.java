package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class Infantry extends Unite {
    public Infantry( Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y, "s", 250, 0.2f, 50, 500, 1500, 3, 10, "s"
               , attackStrategy, owner);
       this.nameType = "Infantry";
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
