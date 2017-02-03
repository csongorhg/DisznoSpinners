package com.mygdx.game.Play;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 02. 03..
 */
public class NemHusok extends OneSpriteStaticActor {

    private int speed = 1;

    public NemHusok(Texture texture) {
        super(texture);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(getX(), getY()-2*speed);

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
