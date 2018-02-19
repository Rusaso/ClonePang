package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameBackground;
import org.izv.android.juego1718.media.Image;

/**
 * Created by yusas on 14/02/2018.
 */

public class Fondo extends GameBackground {

    private int positionX=0;

    public Fondo() {
        super(Assets.bk2);
        this.setMovement(Movement.MOVING);
    }

    @Override
    public void update() {
        if(isTouched()) {
            positionX = getTouchHandler().getTouchX();
        }
    }

    public int getTouchedX(){
        return positionX;
    }
}
