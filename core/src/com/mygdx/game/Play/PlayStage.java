package com.mygdx.game.Play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class PlayStage extends MyStage {
    private TextButton textButton;

    private KolbaszTolto kolbaszTolto;

    private static int dbPotyogas;

    private static OneSpriteStaticActor palinkaKijelzoActor;
    public static int palinkaSzint, jelenlegiPalinkaSzint;

    public PlayStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init() {
        addBackEventStackListener();



        //pálinka
        palinkaSzint = 15;
        palinkaKijelzoActor = new OneSpriteStaticActor(new PalinkaKijelzo().getTexture());
        addActor(palinkaKijelzoActor);
        palinkaKijelzoActor.setSize(50,200);
        palinkaKijelzoActor.setPosition(getViewport().getWorldWidth() - palinkaKijelzoActor.getWidth(),0);
        jelenlegiPalinkaSzint = palinkaSzint;
        //pálinka



        kolbaszTolto = new KolbaszTolto();
        addActor(kolbaszTolto);

        Husok husok = new Husok(Assets.manager.get(Assets.TEST_TEXTURE));
        addActor(husok);

        palinkaszint();

        }

    @Override
    public void act(float delta) {
        super.act(delta);
        pozicionalas();

        //pálinkaszint váltása
        palinkaSzint--;
        palinkaszint();
        //pálinkaszint váltása

    }

    private void palinkaszint() {
        if (palinkaKijelzoActor != null && jelenlegiPalinkaSzint != palinkaSzint) {
            System.out.println("asd");
            palinkaKijelzoActor.remove();
            palinkaKijelzoActor = new OneSpriteStaticActor(new PalinkaKijelzo().getTexture());
            addActor(palinkaKijelzoActor);
            palinkaKijelzoActor.setSize(50,200);
            palinkaKijelzoActor.setPosition(getViewport().getWorldWidth() - palinkaKijelzoActor.getWidth(),0);
            jelenlegiPalinkaSzint = palinkaSzint;
            }
        }

    private void pozicionalas(){
        if(kolbaszTolto.getX() >=0 && kolbaszTolto.getX()+kolbaszTolto.getWidth() <= ((ExtendViewport)getViewport()).getMinWorldWidth())
            kolbaszTolto.setPosition(kolbaszTolto.getX()-(Gdx.input.getAccelerometerX()), kolbaszTolto.getY());
        if(kolbaszTolto.getX() < 0)
            kolbaszTolto.setPosition(0, kolbaszTolto.getY());
        if(kolbaszTolto.getX() + kolbaszTolto.getWidth() > ((ExtendViewport)getViewport()).getMinWorldWidth())
            kolbaszTolto.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth() - kolbaszTolto.getWidth(), kolbaszTolto.getY());
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
