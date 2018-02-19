package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Image;

/**
 * Created by yusas on 14/02/2018.
 */

public class Rope extends GameObject {

    private boolean touchedTop = false;
    public Rope(Image image) {
        super(image);
        this.setSpeedX(0);
        this.setSpeedY(2);
    }

    @Override
    public void update() {
        //if (this.getY() > this.getGraphics().getHeight() - this.getImage().getBitmap().getHeight() ||  this.getY() < 0) {
        if(this.getY() <= 0){
            touchedTop=true;
            this.setSpeedY(0);
            this.setVisible(false);
        }
        this.setX(this.getX() + this.getSpeedX());
        this.setY(this.getY() + this.getSpeedY());
    }

    public boolean isTouchedTop(){
        return touchedTop;
    }

}
