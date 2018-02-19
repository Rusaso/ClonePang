package org.izv.android.juego1718;

import android.util.Log;

import org.izv.android.juego1718.currentgame.Assets;
import org.izv.android.juego1718.currentgame.BouncingBall;
import org.izv.android.juego1718.currentgame.Fondo;
import org.izv.android.juego1718.currentgame.Rope;
import org.izv.android.juego1718.currentgame.StickMan;
import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.generic.GenericGameActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class JuegoNuevo extends GenericGameActivity {

    private BouncingBall b;
    private ArrayList<BouncingBall> balls = new ArrayList<>();
    private ArrayList<Rope> ropes = new ArrayList<>();

    private ArrayList<BouncingBall> temporalBall = new ArrayList<>();
    private ArrayList<Rope> ropeToDelete = new ArrayList<>();
    private ArrayList<BouncingBall> ballToDelete = new ArrayList<>();

    private StickMan st;
    private Fondo fondo;
    private Rope rope = new Rope(Assets.rope);
    private static final int MAXROPES=10;

    @Override
    public void start() {
        Random rand = new Random();
        fondo = new Fondo();
        addGameObject(fondo);

        b = new BouncingBall(Assets.bigBubble1);
        b.setX(rand.nextInt(700));
        b.setSpeedX(3);
        b.setSpeedY(3);
        balls.add(b);
        addGameObject(b);

        b = new BouncingBall(Assets.bigBubble1);
        b.setX(rand.nextInt(700));
        b.setSpeedX(3);
        b.setSpeedY(3);
        balls.add(b);
        addGameObject(b);


        st = new StickMan();
        //addGameObject(st);
    }

    @Override
    public void update() {
        super.update();
        temporalBall.clear();
        ballToDelete.clear();
        ropeToDelete.clear();
        //Log.v("XXX",""+ropes.size());
        if(fondo.isTouched()){
            rope = new Rope(Assets.rope);
            rope.setY(280);
            rope.setSpeedY(-10);
            rope.setX(fondo.getTouchedX());
            ropes.add(rope);
            addGameObject(rope);

        }

        if(balls.size()>1){
            for (BouncingBall b: balls){
                for (BouncingBall b2: balls){
                    if(!b.equals(b2)){
                        chocaRebota(b,b2);
                    }
                }
            }
        }
        for(BouncingBall bo : balls){
            //chocaRepele(bo,st);
            for(Rope r:ropes) {
                chocaCuerda(r, bo);
            }
        }

        for(Rope r:ropes){
            if(r.isTouchedTop()){
                ropeToDelete.add(r);
            }
        }
        balls.removeAll(ballToDelete);
        ropes.removeAll(ropeToDelete);
        balls.addAll(temporalBall);

        for(BouncingBall bb: temporalBall){
            addGameObject(bb);
        }


    }

    private Boolean chocaRepele(GameObject dinamic, GameObject estatic ){
        boolean chocan = dinamic.instersects(estatic);
        if(chocan){
            if(dinamic.getX()>estatic.getX()){
                dinamic.setSpeedX(3);
            }else{
                dinamic.setSpeedX(-3);
            }
            if(dinamic.getY()>estatic.getY()){
                dinamic.setSpeedY(3);
            }else{
                dinamic.setSpeedY(-3);
            }
        }
        return false;
    }

    private void chocaCuerda(Rope rp, BouncingBall bb ){
        boolean chocan = bb.instersects(rp);
        if(chocan) {
            rp.setVisible(false);
            ropeToDelete.add(rp);
            if (bb.getImage().equals(Assets.smallBubble1)) {
                bb.setVisible(false);
                ballToDelete.add(bb);
            } else {
                if (bb.getImage().equals(Assets.bigBubble1)) {
                    bb.setImage(Assets.mediumBubble1);
                    bb.setX(rp.getX() + 100);
                    b = new BouncingBall(Assets.mediumBubble1);
                    b.setX(rp.getX() - 100);
                    b.setY(rp.getY());
                    temporalBall.add(b);
                } else if (bb.getImage().equals(Assets.mediumBubble1)) {
                    bb.setImage(Assets.smallBubble1);
                    bb.setX(rp.getX() + 100);
                    b = new BouncingBall(Assets.smallBubble1);
                    b.setX(rp.getX() - 100);
                    b.setY(rp.getY());
                    temporalBall.add(b);
                }

                //addGameObject(b);
            }
        }
    }

    private void chocaRebota( GameObject b1, GameObject b2){
        boolean chocan = b1.instersects(b2);
        if(chocan){
            if(b1.getX()>b2.getX()){
                b1.setSpeedX(3);
                b2.setSpeedX(-3);
            }else{
                b1.setSpeedX(-3);
                b2.setSpeedX(3);
            }
            if(b1.getY()>b2.getY()){
                b1.setSpeedY(3);
                b2.setSpeedY(-3);
            }else{
                b1.setSpeedY(-3);
                b2.setSpeedY(3);
            }
        }
    }
}
