package com.mygdx.game.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.Play.PlayScreen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2, textButton3;
    private TextButton.TextButtonStyle textButtonStyle;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init()
    {

        addBackEventStackListener();



        //quit
        textButton3 = new MyButton("Quit", game.getTextButtonStyle());
        textButton3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });
        textButton3.setPosition(getViewport().getWorldWidth() / 2 - textButton3.getWidth() / 2,
                textButton3.getHeight());
        addActor(textButton3);



        //valami
        textButton2 = new MyButton("Play", game.getTextButtonStyle());
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });

        textButton2.setPosition(getViewport().getWorldWidth() / 2 - textButton2.getWidth() / 2,
                textButton3.getX() + textButton3.getHeight());
        addActor(textButton2);









    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
