package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class BlackEagle extends Unite {
    public int startX;
    public int startY;


    public BlackEagle(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id, x, y, "a", 1500, 0, 400, 30, 0, 0, 100, "m"
                , attackStrategy, owner);
        this.nameType = "BlackEagle";
        startX = this.unitPosition.x;
        startY = this.unitPosition.y;
        Id++;
        checkAndSet.add(this);
    }
}
