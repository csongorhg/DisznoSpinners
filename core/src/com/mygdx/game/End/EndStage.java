package com.mygdx.game.End;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Play.PlayStage;

/**
 * Created by Kicsi on 2017. 02. 03..
 */

public class EndStage extends MyStage {

    private MyLabel sz1, sz2, hs;
    private MyButton button;
    private float width, height;


    public EndStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        width = ((ExtendViewport)getViewport()).getMinWorldWidth();
        height = ((ExtendViewport)getViewport()).getMinWorldHeight();

        sz1 = new MyLabel("You have been collected", labelStyle());
        addActor(sz1);
        sz1.setPosition(width/2-sz1.getWidth()/2, height*4/6);

        sz2 = new MyLabel((PlayStage.darabHus == 0 ? 0 : (PlayStage.darabNemHus/PlayStage.darabHus*100))+"% of sausage.", labelStyle());
        addActor(sz2);
        sz2.setPosition(width/2-sz2.getWidth()/2, height*3/6);

        hs = new MyLabel("Your best score: 100%", labelStyle());
        addActor(hs);
        hs.setPosition(width/2-hs.getWidth()/2, height*2/6);

        button = new MyButton("MENU", game.getTextButtonStyle());
        addActor(button);
        button.setPosition(width/2-button.getWidth()/2, height*1/6);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    private Label.LabelStyle labelStyle(){
        Label.LabelStyle style;
        style = new Label.LabelStyle();

        style.fontColor = Color.BLACK;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/acmeregular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter meret = new FreeTypeFontGenerator.FreeTypeFontParameter();
        meret.size = 70;
        meret.characters = Assets.CHARS;
        BitmapFont font = generator.generateFont(meret);
        generator.dispose();
        style.font = font;
        return style;
    }
}
