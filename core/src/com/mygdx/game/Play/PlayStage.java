package com.mygdx.game.Play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.End.EndScreen;
import com.mygdx.game.GlobalClasses.Assets;
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
    private float husTime = 0, gyilkosTime = 0, nonhusTime = 0, palinkaTime = 0;

    private float elapsedTime;
    private int speed = 1;

    private Preferences preferences;

    public static int darabHus = 0;
    public static int darabNemHus = 0;
    private static int dbPotyogas;

    public static float hurkaIdozito;
    public static float palinkaIdozito;

    private static ArrayList<OneSpriteStaticActor> esodolgok;
    private static OneSpriteStaticActor palinkaKijelzoActor, palinkasPohar;
    public static int palinkaSzint, jelenlegiPalinkaSzint;


    public PlayStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init() {
        addBackEventStackListener();
        preferences = Gdx.app.getPreferences(PlayScreen.PREFS);



        esodolgok = new ArrayList<OneSpriteStaticActor>();



        //pálinka
        palinkaSzint = 15;
        palinkaKijelzoActor = new OneSpriteStaticActor(new PalinkaKijelzo().getTexture());
        palinkaKijelzoActor.setSize(50,200);
        palinkaKijelzoActor.setPosition(0 , getViewport().getWorldHeight() - palinkaKijelzoActor.getHeight());
        addActor(palinkaKijelzoActor);
        jelenlegiPalinkaSzint = palinkaSzint;
        //pálinka



        kolbaszTolto = new KolbaszTolto();
        addActor(kolbaszTolto);

        palinkaszint();

        }

    @Override
    public void act(float delta) {

        super.act(delta);
        elapsedTime += delta;
        husTime += delta;
        nonhusTime += delta;
        gyilkosTime += delta;
        palinkaTime += delta;
        palinkaIdozito += delta;

        kolbaszTolto.act(delta);

        pozicionalas();
        esik();
        utkozik();


        //pálinkaszint váltása - 10mp ként 1 fogy
        if (palinkaIdozito >= 1) {
            palinkaSzint--;
            palinkaIdozito = 0;
            palinkaszint();

        }


        if (palinkaSzint == 0) {
            dispose();
            game.setScreen(new EndScreen(game));
        }
        //pálinkaszint váltása

        if (hurkaIdozito > 0.0f) {
            kolbaszTolto.setFps(30);
        }
        if(hurkaIdozito > 0.0f)
            hurkaIdozito -= delta;

        if (hurkaIdozito <= 0.0f) {
            hurkaIdozito = 0.0f;
            kolbaszTolto.setFps(4);
        }

    }

    private void utkozik() {
        for (int i = 0; i < esodolgok.size(); i++) {
            OneSpriteStaticActor a = esodolgok.get(i);

            if(a.getY()+a.getHeight() < 0){
                a.remove();
                esodolgok.remove(i);
                i--;
            }else{
                //itt kapok el valamit
                if(kolbaszTolto.getY()+kolbaszTolto.getHeight() > a.getY() &&
                        a.getX()+a.getWidth()/2 > kolbaszTolto.getX() &&
                        a.getX()-a.getWidth()/2 < kolbaszTolto.getX()+kolbaszTolto.getWidth()){
                    if(a instanceof Husok){
                        hurkaIdozito += 1.0f;
                        darabHus++;
                    }else if( a instanceof NemHusok){
                        hurkaIdozito += 1.0f;
                        darabNemHus++;
                    }else if( a instanceof DaraloGyilkos){
                        hurkaIdozito += 1.0f;
                    }else if (a instanceof Palinka) {
                        if ( (palinkaSzint+1) <= 15 ) {
                            palinkaSzint++;
                            palinkaszint();
                        }
                    }

                    a.remove();
                    esodolgok.remove(i);
                    i--;
                }
            }


        }
    }

    private void palinkaszint() {
        if (palinkaKijelzoActor != null && jelenlegiPalinkaSzint != palinkaSzint) {
            palinkaKijelzoActor.remove();
            palinkaKijelzoActor = new OneSpriteStaticActor(new PalinkaKijelzo().getTexture());
            addActor(palinkaKijelzoActor);
            palinkaKijelzoActor.setSize(50,200);
            palinkaKijelzoActor.setPosition(0 , getViewport().getWorldHeight() - palinkaKijelzoActor.getHeight());
            jelenlegiPalinkaSzint = palinkaSzint;
            }
        }
    private void esik(){
        if(elapsedTime > 50){
            elapsedTime = 0;
            speed++;
        }
        if(husTime > 2){
            husTime = 0;
            int ez = vel(1,5);
            Texture t = null;
            if(ez == 1) t = Assets.manager.get(Assets.HUS1);
            else if(ez == 2) t = Assets.manager.get(Assets.HUS2);
            else if(ez == 3) t = Assets.manager.get(Assets.HUS3);
            else if(ez == 4) t = Assets.manager.get(Assets.HUS4);
            else if(ez == 5) t = Assets.manager.get(Assets.HUS5);

            Husok husok = new Husok(t);
            husok.setPosition(vel(((ExtendViewport)getViewport()).getMaxWorldWidth(),((ExtendViewport)getViewport()).getMinWorldWidth()-husok.getWidth()),getViewport().getWorldHeight());
            addActor(husok);
            esodolgok.add(husok);
            husok.setSpeed(speed);
        }
        if(nonhusTime > 5){
            nonhusTime = 0;
            NemHusok nemHusok = new NemHusok(vel(0,1) == 0 ? Assets.manager.get(Assets.RONT1) : Assets.manager.get(Assets.RONT2));
            nemHusok.setPosition(vel(((ExtendViewport)getViewport()).getMaxWorldWidth(),((ExtendViewport)getViewport()).getMinWorldWidth()-nemHusok.getWidth()),getViewport().getWorldHeight());
            addActor(nemHusok);
            esodolgok.add(nemHusok);
            nemHusok.setSpeed(speed+1);
        }
        if(gyilkosTime > 11){
            gyilkosTime = 0;
            int ez = vel(1,3);
            Texture t = null;
            if(ez == 1) t = Assets.manager.get(Assets.GYILKOS1);
            else if(ez == 2) t = Assets.manager.get(Assets.GYILKOS2);
            else if(ez == 3) t = Assets.manager.get(Assets.GYILKOS3);

            DaraloGyilkos daraloGyilkos = new DaraloGyilkos(t);
            daraloGyilkos.setPosition(vel(((ExtendViewport)getViewport()).getMaxWorldWidth(),((ExtendViewport)getViewport()).getMinWorldWidth()-daraloGyilkos.getWidth()),getViewport().getWorldHeight());
            addActor(daraloGyilkos);
            esodolgok.add(daraloGyilkos);
            daraloGyilkos.setSpeed(speed+2);
        }
        if (palinkaTime > 5) {
            palinkaTime = 0;
            Palinka palinka = new Palinka(Assets.manager.get(Assets.PALINKA));
            palinka.setPosition(vel(((ExtendViewport) getViewport()).getMaxWorldWidth(), ((ExtendViewport) getViewport()).getMinWorldWidth() - palinka.getWidth()), getViewport().getWorldHeight());
            addActor(palinka);
            esodolgok.add(palinka);
            palinka.setSpeed(speed + 1);
        }
    }

    private int vel(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    private float vel(float a, float b){
        return (float)(Math.random()*(b-a+1)+a);
    }

    private void pozicionalas(){
        if(kolbaszTolto.getX() >=((ExtendViewport)getViewport()).getMaxWorldWidth() && kolbaszTolto.getX()+kolbaszTolto.getWidth() <= ((ExtendViewport)getViewport()).getMinWorldWidth())
            kolbaszTolto.setPosition(kolbaszTolto.getX()-(Gdx.input.getAccelerometerX()*2), kolbaszTolto.getY());
        if(kolbaszTolto.getX() < ((ExtendViewport)getViewport()).getMaxWorldWidth())
            kolbaszTolto.setPosition(((ExtendViewport)getViewport()).getMaxWorldWidth(), kolbaszTolto.getY());
        if(kolbaszTolto.getX() + kolbaszTolto.getWidth() > ((ExtendViewport)getViewport()).getMinWorldWidth())
            kolbaszTolto.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth() - kolbaszTolto.getWidth(), kolbaszTolto.getY());
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
