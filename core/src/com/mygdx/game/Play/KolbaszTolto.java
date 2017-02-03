package com.mygdx.game.Play;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2017. 02. 03..
 */
public class KolbaszTolto extends OneSpriteAnimatedActor {

    private OneSpriteAnimatedActor oneSpriteAnimatedActor;

    public KolbaszTolto() {
        super(Assets.manager.get(Assets.EXPLOSION_TEXTUREATLAS));
        setSize(100,100);
        setFps(30);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
