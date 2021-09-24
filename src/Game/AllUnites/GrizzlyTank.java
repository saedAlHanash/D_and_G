package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class GrizzlyTank extends Unite {
    public GrizzlyTank(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y,"t", 1000, 0.4f, 250, 250, 0.6f, 20, 30, "stS"
                , attackStrategy, owner);
        nameType = "GrizzlyTank";
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
