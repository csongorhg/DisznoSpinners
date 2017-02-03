package com.mygdx.game.Play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class PlayStage extends MyStage {
    private TextButton textButton;

    private KolbaszTolto kolbaszTolto;
    private Husok husok;
    private float husTime = 0, gyilkosTime = 0, nonhusTime = 0;

    private float elapsedTime;
    private int speed = 1;
    private static ArrayList<OneSpriteStaticActor> potyogoDolgok;

    private static int dbPotyogas;

    public PlayStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init() {
        addBackEventStackListener();

        kolbaszTolto = new KolbaszTolto();
        addActor(kolbaszTolto);

        //potyogoDolgok.add(husok);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        husTime += delta;
        nonhusTime += delta;
        gyilkosTime += delta;

        pozicionalas();
        esik();
    }

    private void esik(){
        if(elapsedTime > 10){
            elapsedTime = 0;
            speed++;
        }
        if(husTime > 2){
            husTime = 0;
            Husok husok = new Husok(Assets.manager.get(Assets.TEST_TEXTURE));
            husok.setPosition(vel(0,getViewport().getWorldWidth()-husok.getWidth()),getViewport().getWorldHeight());
            addActor(husok);
            husok.setSpeed(speed);
        }
        if(nonhusTime > 5){
            nonhusTime = 0;
            NemHusok nemHusok = new NemHusok(Assets.manager.get(Assets.TEST_TEXTURE));
            nemHusok.setRotation(30);
            nemHusok.setPosition(vel(0,getViewport().getWorldWidth()-nemHusok.getWidth()),getViewport().getWorldHeight());
            addActor(nemHusok);
            nemHusok.setSpeed(speed+1);
        }
        if(gyilkosTime > 11){
            gyilkosTime = 0;
            DaraloGyilkos daraloGyilkos = new DaraloGyilkos(Assets.manager.get(Assets.TEST_TEXTURE));
            daraloGyilkos.setRotation(45);
            daraloGyilkos.setPosition(vel(0,getViewport().getWorldWidth()-daraloGyilkos.getWidth()),getViewport().getWorldHeight());
            addActor(daraloGyilkos);
            daraloGyilkos.setSpeed(speed+2);
        }
    }

    private float vel(float a, float b){
        return (float)(Math.random()*(b-a+1)+a);
    }

    private void pozicionalas(){
        if(kolbaszTolto.getX() >=0 && kolbaszTolto.getX()+kolbaszTolto.getWidth() <= ((ExtendViewport)getViewport()).getMinWorldWidth())
            kolbaszTolto.setPosition(kolbaszTolto.getX()-(Gdx.input.getAccelerometerX()*2), kolbaszTolto.getY());
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
