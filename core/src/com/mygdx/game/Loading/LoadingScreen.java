package com.mygdx.game.Loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.End.EndScreen;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.Menu.MenuStage;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.GlobalClasses.*;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Play.PlayStage;

//Music: http://www.bensound.com

public class LoadingScreen extends MyScreen {


	private Stage stage;
	private OneSpriteStaticActor text;
	private float elapsedTime = 0;
	private OneSpriteStaticActor picture;

    public LoadingScreen(MyGdxGame game) {
		super(game);
		Gdx.input.setCatchBackKey(true);
		stage = new Stage();
		/*picture = new OneSpriteAnimatedActor("Menu/load.txt")
		{
			@Override
			public void init() {
				super.init();
				setFps(12);
			}

			@Override
			public void act(float delta) {
				super.act(delta);
				setRotation(360-elapsedTime*100);
			}
		};*/
		//stage.addActor(picture);

		picture = new OneSpriteStaticActor("Diszno/csontvaz.png");
		picture.setSize(stage.getWidth()/2,stage.getWidth()/2);
		picture.setPosition(stage.getViewport().getWorldWidth()/2 - picture.getWidth()/2,stage.getHeight()/2 - picture.getHeight());
		stage.addActor(picture);
		text = new OneSpriteStaticActor("Menu/justszoveg.png");
		stage.addActor(text);
		text.setPosition(stage.getViewport().getWorldWidth()/2-text.getWidth()/2,stage.getHeight()-text.getHeight());
    }


    @Override
	public void show() {
	    Assets.manager.finishLoading();
		Assets.load();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act(delta);
		stage.draw();

		if((int)(Assets.manager.getProgress()*100f) >= 25){
			picture = new OneSpriteStaticActor("Diszno/diszno-1.png");
			picture.setSize(stage.getWidth()/2,stage.getWidth()/2);
			picture.setPosition(stage.getViewport().getWorldWidth()/2 - picture.getWidth()/2,stage.getHeight()/2 - picture.getHeight());
			stage.addActor(picture);
		}
		if((int)(Assets.manager.getProgress()*100f) >= 50){
			picture = new OneSpriteStaticActor("Diszno/diszno-2.png");
			picture.setSize(stage.getWidth()/2,stage.getWidth()/2);
			picture.setPosition(stage.getViewport().getWorldWidth()/2 - picture.getWidth()/2,stage.getHeight()/2 - picture.getHeight());
			stage.addActor(picture);
		}
		if((int)(Assets.manager.getProgress()*100f) >= 75){
			picture = new OneSpriteStaticActor("Diszno/diszno-3.png");
			picture.setSize(stage.getWidth()/2,stage.getWidth()/2);
			picture.setPosition(stage.getViewport().getWorldWidth()/2 - picture.getWidth()/2,stage.getHeight()/2 - picture.getHeight());
			stage.addActor(picture);
		}
		if((int)(Assets.manager.getProgress()*100f) >= 90){
			picture = new OneSpriteStaticActor("Diszno/diszno-4.png");
			picture.setSize(stage.getWidth()/2,stage.getWidth()/2);
			picture.setPosition(stage.getViewport().getWorldWidth()/2 - picture.getWidth()/2,stage.getHeight()/2 - picture.getHeight());
			stage.addActor(picture);
		}

		if (elapsedTime > 2.0 && Assets.manager.update()) {
			Assets.afterLoaded();
			MenuStage.music = Assets.manager.get(Assets.MUSIC);
			MenuStage.playing = true;
			MenuStage.music.play();
			MenuStage.music.setVolume(0.9999f);
			game.setScreen(new MenuScreen(game));
		}

		elapsedTime+=delta;

	}

	@Override
	public void hide() {

	}

	@Override
	public void init() {
		setBackGroundColor(0f, 0f, 0f);
	}
}