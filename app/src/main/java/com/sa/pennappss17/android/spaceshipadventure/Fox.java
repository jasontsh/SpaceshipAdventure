package com.sa.pennappss17.android.spaceshipadventure;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by emilytan on 1/21/17.
 */

public class Fox implements GameObj {

    private final int xPosition;
    private int yPosition;
    private final double velocity;
    private Bitmap bitmap;
    private int maxHeight;
    static final Bitmap[] FOXES = new Bitmap[3];
    private int worth;


    public Fox(int xInitial, int yInitial, int maxHeight, Resources res, int which) {
        xPosition = xInitial;
        yPosition = yInitial;
        if (FOXES[0] == null) {
            Bitmap bm = BitmapFactory.decodeResource(res, R.drawable.fox3);
            FOXES[0] = Bitmap.createScaledBitmap(bm, 200, 200, true);
            bm.recycle();
            bm = BitmapFactory.decodeResource(res, R.drawable.fox2);
            FOXES[1] = Bitmap.createScaledBitmap(bm, 200, 200, true);
            bm.recycle();
            bm = BitmapFactory.decodeResource(res, R.drawable.fox1);
            FOXES[2] = Bitmap.createScaledBitmap(bm, 200, 200, true);
            bm.recycle();
        }
        this.bitmap = FOXES[which];
        this.maxHeight = maxHeight;
        velocity = 8 + Math.random()*4;
        worth = which == 0 ? 10 : which == 1 ? 1 : 3;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public int getX() {
        return xPosition;
    }

    @Override
    public int getY() {
        return yPosition;
    }

    @Override
    public Hitbox getHitbox() {
        return new Hitbox(xPosition, yPosition, 400, 300);
    }

    @Override
    public void movement() {
        yPosition += velocity;
        if (yPosition > maxHeight) {
            MainActivity.gameView.gameObjs.remove(this);
            MainActivity.foxSet.remove(this);
        }
    }

    public int getWorth() {
        return worth;
    }
}