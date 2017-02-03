package com.mygdx.game.Play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class PlayScreen extends MyScreen {
    protected PlayStage playStage;
    private MyStage bgStage;
    public static final String PREFS = "MAX";

    private Preferences preferences = Gdx.app.getPreferences(PREFS);

    public PlayScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        bgStage.act(delta);
        bgStage.draw();

        playStage.act(delta);
        playStage.draw();

    }

    @Override
    public void init() {
        playStage  = new PlayStage(new ExtendViewport(720,1280,new OrthographicCamera(720,1280)), spriteBatch, game);
        Gdx.input.setInputProcessor(playStage);


        bgStage = new MyStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())), spriteBatch, game) {

            public OneSpriteStaticActor getBackGroundActor() {
                return backGroundActor;
            }

            private OneSpriteStaticActor backGroundActor;

            @Override
            public void init() {
                r = 0;
                g = 0;
                b = 0;
                backGroundActor = new OneSpriteStaticActor(Assets.manager.get(Assets.INGAMEGROUND));
                backGroundActor.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                setCameraZoomXY(backGroundActor.getWidth() / 2, backGroundActor.getHeight() / 2, 40);
                setCameraMoveToXY(backGroundActor.getWidth() / 2
                        , backGroundActor.getHeight() / 2, 1, 80);
                addActor(backGroundActor);
            }

            @Override
            protected void resized() {

            }

            @Override
            public void act(float delta) {
                super.act(delta);
            }
        };

    }

    @Override
    public void dispose() {
        super.dispose();
        preferences.flush();
        playStage.dispose();
    }

    @Override
    public void hide() {
        super.hide();
        preferences.flush();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

    }

}
