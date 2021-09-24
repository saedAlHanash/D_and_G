package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class TeslaTank extends Unite {
    public TeslaTank(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id, x, y, "t", 30, 0.5f, 300, 250,
                0.6f, 20, 30, "ts",
                attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}

