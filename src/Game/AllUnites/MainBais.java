package Game.AllUnites;

import Game.Player;
import Game.Unite;

public class MainBais extends Unite {
    public MainBais() {
        super(0,200, 200, "m", 10000, 0, 0, 0, 0, 50, 0,
                "", null, new Player(1,"",200,200));
        //this.unitPosition.x=100;
      //  this.unitPosition.y=100;
        this.checkAndSet.add(this);
    }
}
