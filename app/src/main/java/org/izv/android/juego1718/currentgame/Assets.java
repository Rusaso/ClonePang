package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.media.Graphics;
import org.izv.android.juego1718.media.Image;

public class Assets {

    public static Image background, ball, jump, right, stand,bk2,ducking,bigBubble1, mediumBubble1,smallBubble1,rope;

    public static void load(Graphics g) {
        Assets.background = g.newImage("background.jpg");
        Assets.bk2 = g.newImage("bk2.jpg");
        Assets.ball = g.newImage("ball.png");
        Assets.jump = g.newImage("jump.png");
        Assets.right = g.newImage("right.png");
        Assets.stand = g.newImage("stand.png");
        Assets.stand = g.newImage("stand.png");
        Assets.ducking = g.newImage("ducking.png");
        Assets.bigBubble1 = g.newImage("BurbujaGrande1.png");
        Assets.mediumBubble1 = g.newImage("BurbujaMediana1.png");
        Assets.smallBubble1 = g.newImage("BurbujaPequeña.png");
        Assets.rope = g.newImage("cuerda.png");
    }
}