package org.izv.android.juego1718;

import org.izv.android.juego1718.currentgame.Background;
import org.izv.android.juego1718.currentgame.BouncingBall;
import org.izv.android.juego1718.generic.GenericGameActivity;

public class GameActivity extends GenericGameActivity {

    private BouncingBall bouncingBall;

    @Override
    public void paint() {
        super.paint();
    }

    @Override
    public void start() {
        addGameObject(new Background());
        //bouncingBall = new BouncingBall();
        addGameObject(bouncingBall);
    }

    @Override
    public void update() {
        super.update();
    }
}