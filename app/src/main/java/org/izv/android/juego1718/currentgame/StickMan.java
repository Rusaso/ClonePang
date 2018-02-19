package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Animation;

/**
 * Created by yusas on 14/02/2018.
 */

public class StickMan extends GameObject {
 private static final int MAXSALTO = 15;
    private Animation animation;
    private long tiempo;
    private boolean saltando=false;
    private int salto = 0;

    public StickMan() {
        super(Assets.stand);
        this.setX(5);
        this.setY(250);
        animation = new Animation();
        animation.addFrame(Assets.stand, 500);
        animation.addFrame(Assets.right, 500);
        tiempo = System.currentTimeMillis();
    }

    @Override
    public void update() {
        if(getTouchHandler().isMoving() && getTouchHandler().isMovingUp()){
            this.setSpeedX(0);
            if(!saltando){
                salto = -MAXSALTO;
                setSpeedY(salto);
                saltando=true;
            }

        }else if(getTouchHandler().isMoving() && getTouchHandler().isMovingDown()){
            this.setImage(Assets.ducking);
            this.setSpeedX(0);

        }else if(getTouchHandler().isMoving() && getTouchHandler().isMovingRight()){
            this.setSpeedX(2);
        }else if(getTouchHandler().isMoving() && getTouchHandler().isMovingLeft()){
            this.setSpeedX(-2);

        }else{
            animation.update((System.currentTimeMillis() - tiempo));
            tiempo = System.currentTimeMillis();
            this.setImage(animation.getImage());
            this.setSpeedX(0);
        }

        if(saltando){
            setY(getY()+getSpeedY());
            this.setImage(Assets.jump);
            setSpeedY(getSpeedY() + 1);
            salto++;
            if(salto>MAXSALTO) {
                saltando = false;
                setSpeedY(0);
            }
        }

        if(this.getX()+this.getSpeedX()>350){
            this.setX(350);
        }else{
            this.setX(this.getX() +this.getSpeedX());
        }
    }
}
