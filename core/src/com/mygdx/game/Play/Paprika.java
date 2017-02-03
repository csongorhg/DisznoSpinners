package com.mygdx.game.Play;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 02. 03..
 */
public class Paprika extends OneSpriteStaticActor{

    private int speed = 1;
    private float ido =0;

    public Paprika(Texture texture) {
        super(texture);
        setSize(100,100);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(getX(), getY()-2*speed);
        ido+= delta;
        setRotation(360-ido*100);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
