package com.mygdx.game.Menu;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.Play.PlayScreen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2, textButton3;
    private TextButton.TextButtonStyle textButtonStyle;
    private OneSpriteStaticActor musicButton;
    public static Music music;
    public static boolean playing;

    //Gdx.input.getAccelerometerX() / 2

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init()
    {

        addBackEventStackListener();

        //valami
        textButton2 = new MyButton("Play", game.getTextButtonStyle());
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });
        textButton2.setSize(textButton2.getWidth()*2,textButton2.getHeight());
        textButton2.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth() / 2 - textButton2.getWidth() / 2,
                ((ExtendViewport)getViewport()).getMinWorldHeight() / 2 + textButton2.getHeight()*0.8f);
        addActor(textButton2);

        //quit
        textButton3 = new MyButton("Quit", game.getTextButtonStyle());
        textButton3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.dispose();
                dispose();
                System.exit(0);
            }
        });
        textButton3.setSize(textButton2.getWidth(),textButton2.getHeight());
        textButton3.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth() / 2 - textButton3.getWidth() / 2,
                ((ExtendViewport)getViewport()).getMinWorldHeight() / 2 - textButton3.getHeight()/3);
        addActor(textButton3);

        musicOnOff();






    }

    private void musicOnOff(){
        musicButton = new OneSpriteStaticActor( music.getVolume() >= 0.9f ?
                Assets.manager.get(Assets.SOUND) : Assets.manager.get(Assets.NOSOUND));

        musicButton.setSize(128,128);

        musicButton.setPosition(((ExtendViewport)getViewport()).getMaxWorldWidth()-musicButton.getWidth()/2,((ExtendViewport)getViewport()).getMinWorldHeight()-musicButton.getHeight());

        addActor(musicButton);

        musicButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                musicButton.remove();
                if(music.getVolume()>0.9f){
                    playing = false;
                    music.setVolume(0f);
                }
                else{
                    playing = true;
                    music.setVolume(1f);
                }
                musicOnOff();
            }
        });
    }

    private void musicIsPlaying() {
        if(playing){
            if(!music.isPlaying()){
                music.stop();
                music.play();
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        musicIsPlaying();
    }

    @Override
    public void dispose() {
        music.dispose();
        super.dispose();
    }
}
