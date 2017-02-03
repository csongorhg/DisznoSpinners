package com.mygdx.game.Play;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.mygdx.game.GlobalClasses.Assets;

/**
 * Created by Kicsi on 2017. 02. 03..
 */

public class HusdaraloSound {

    public Music zene;

    public HusdaraloSound() {
        zene = Assets.manager.get(Assets.GRINDING);
        zene.stop();
    }

    public void start(){
        if(!zene.isLooping()) zene.play();
    }

    public void stop(){
        zene.stop();
    }
}
