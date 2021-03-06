package com.dranitix.railtime;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Created by Kenta Iwasaki on 11/26/2016.
 */
public class Crate extends Actor {
    TextureRegion crate;

    public Crate(Texture crate, int x, int y) {
        this.crate = new TextureRegion(crate);

        setOrigin(16, 16);
        getColor().a = 0.5f;
        setBounds(x, y, 128, 128);
        setTouchable(Touchable.enabled);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(crate, getX(), getY(), getOriginX(), getOriginY(),
               32, 32, getScaleX(), getScaleY(), getRotation());

        setRotation(getRotation() + 1);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        if (touchable && getTouchable() != Touchable.enabled) return null;
        return x >= -getOriginX() && x < (getWidth() - getOriginX())
                && y >= -getOriginY() && y < (getHeight() - getOriginY()) ? this : null;
    }
}
