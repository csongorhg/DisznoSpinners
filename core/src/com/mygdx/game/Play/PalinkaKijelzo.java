package com.mygdx.game.Play;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.OneSpriteActor;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 02. 03..
 */
public class PalinkaKijelzo{

    public static Texture getTexture(){
        int e = PlayStage.palinkaSzint;
        Pixmap p = new Pixmap(5,17, Pixmap.Format.RGBA8888);
        Color c = e>10 ? Color.GREEN : e>5 ? Color.ORANGE : Color.RED;
        for (int i = 0; i < p.getWidth(); i++){
            for (int j = 0; j< p.getHeight(); j++){
                if(i == 0 || i == 4 || j == 0 || j == 16){
                    p.drawPixel(i,j,Color.rgba8888(Color.BLACK));
                }
                else{
                    if(j >= 16-e){
                        p.drawPixel(i,j,Color.rgba8888(c));
                    }
                    else{
                        p.drawPixel(i,j,Color.rgba8888(Color.BLACK));
                    }
                }
            }
        }

        return new Texture(p);
    }


}
