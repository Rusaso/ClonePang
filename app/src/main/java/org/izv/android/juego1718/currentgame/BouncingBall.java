package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Image;

import java.util.Random;

public class BouncingBall extends GameObject {
    private boolean dissapear = false;
    public BouncingBall(Image asset) {
        super(asset);
        this.setSpeedX(2);
        this.setSpeedY(2);
    }

    public void update() {
        if (this.getX() > this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth() || this.getX() < 0) {
            this.setSpeedX(- this.getSpeedX());
        }
        this.setX(this.getX() + this.getSpeedX());
        if (this.getY() > this.getGraphics().getHeight() - this.getImage().getBitmap().getHeight() ||  this.getY() < 0) {
            this.setSpeedY(- this.getSpeedY());
        }
        this.setY(this.getY() + this.getSpeedY());
    }
}