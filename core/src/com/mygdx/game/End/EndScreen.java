package com.mygdx.game.End;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Kicsi on 2017. 02. 03..
 */

public class EndScreen extends MyScreen {

    protected EndStage menuStage;
    private MyStage bgStage;


    public EndScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        bgStage.act(delta);
        bgStage.draw();

        menuStage.act(delta);
        menuStage.draw();

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

    }

    @Override
    public void dispose() {
        menuStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        menuStage  = new EndStage(new ExtendViewport(720,1280,new OrthographicCamera(720,1280)), spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);


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
                backGroundActor = new OneSpriteStaticActor(Assets.manager.get(Assets.ENDBACKGROUND));
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


}
