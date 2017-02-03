package com.mygdx.game.Play;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2017. 02. 03..
 */
public class Tuz extends OneSpriteAnimatedActor {
    private OneSpriteAnimatedActor oneSpriteAnimatedActor;


    public Tuz() {
        super(Assets.manager.get(Assets.TUZ_TEXTUREATLAS));
        setSize(200,200);
        setFps(8);
        setLooping(true);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
