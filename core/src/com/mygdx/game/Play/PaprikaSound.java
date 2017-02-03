package com.mygdx.game.Play;

import com.badlogic.gdx.audio.Music;
import com.mygdx.game.GlobalClasses.Assets;

/**
 * Created by Vince on 2017. 02. 03..
 */

public class PaprikaSound {

    public Music zene;

    public PaprikaSound() {
        zene = Assets.manager.get(Assets.PAPRIKAHANG);
        zene.stop();
    }

    public void start(){
        if(!zene.isLooping()) zene.play();
    }

    public void stop(){
        zene.stop();
    }
}
