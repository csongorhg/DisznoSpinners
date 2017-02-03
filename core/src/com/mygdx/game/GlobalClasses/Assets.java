//https://github.com/tuskeb/mester
package com.mygdx.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";

	//FONT
	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "Font/acmeregular.ttf";
		fontParameter.fontParameters.size = 100;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> ACMEREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);



	//MUSIC
	public static final AssetDescriptor<Music> MUSIC
			= new AssetDescriptor<Music>("Music/bensound-jazzcomedy.mp3", Music.class);
	public static final AssetDescriptor<Texture> SOUND
			= new AssetDescriptor<Texture>("Menu/sound.png", Texture.class);
	public static final AssetDescriptor<Texture> NOSOUND
			= new AssetDescriptor<Texture>("Menu/nosound.png", Texture.class);




	//ATLAS
	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("Explosion/explosion.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> DARALO_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("atlasok/daralo.atlas", TextureAtlas.class);


	//BACKGROUND
	public static final AssetDescriptor<Texture> BACKGROUND
			= new AssetDescriptor<Texture>("Menu/hatter.png", Texture.class);



	//TEXTURE
	public static final AssetDescriptor<Texture> TEST_TEXTURE
			= new AssetDescriptor<Texture>("TestImg/ratyitutu.png", Texture.class);

	public static final AssetDescriptor<Texture> DARALOALLO
			= new AssetDescriptor<Texture>("atlasok/daralostill.png", Texture.class);

	public static final AssetDescriptor<Texture> HUS1
			= new AssetDescriptor<Texture>("hus/disznoresz1.png", Texture.class);
	public static final AssetDescriptor<Texture> HUS2
			= new AssetDescriptor<Texture>("hus/disznores2.png", Texture.class);
	public static final AssetDescriptor<Texture> HUS3
			= new AssetDescriptor<Texture>("hus/disznoresz3.png", Texture.class);
	public static final AssetDescriptor<Texture> HUS4
			= new AssetDescriptor<Texture>("hus/disznoresz4.png", Texture.class);
	public static final AssetDescriptor<Texture> HUS5
			= new AssetDescriptor<Texture>("hus/disznoresz5.png", Texture.class);

	public static final AssetDescriptor<Texture> GYILKOS1
			= new AssetDescriptor<Texture>("gyilkos/csont.png", Texture.class);
	public static final AssetDescriptor<Texture> GYILKOS2
			= new AssetDescriptor<Texture>("gyilkos/kes.png", Texture.class);
	public static final AssetDescriptor<Texture> GYILKOS3
			= new AssetDescriptor<Texture>("gyilkos/protko.png", Texture.class);

	public static final AssetDescriptor<Texture> RONT1
			= new AssetDescriptor<Texture>("ront/cipo.png", Texture.class);
	public static final AssetDescriptor<Texture> RONT2
			= new AssetDescriptor<Texture>("ront/gumicsizma.png", Texture.class);

	public static final AssetDescriptor<Texture> DISZNOCSONTVAZ
			= new AssetDescriptor<Texture>("Diszno/csontvaz.png", Texture.class);
	public static final AssetDescriptor<Texture> DISZNODARAB1
			= new AssetDescriptor<Texture>("Diszno/diszno-1.png", Texture.class);
	public static final AssetDescriptor<Texture> DISZNODARAB2
			= new AssetDescriptor<Texture>("Diszno/diszno-2.png", Texture.class);
	public static final AssetDescriptor<Texture> DISZNODARAB3
			= new AssetDescriptor<Texture>("Diszno/diszno-3.png", Texture.class);
	public static final AssetDescriptor<Texture> DISZNODARAB4
			= new AssetDescriptor<Texture>("Diszno/diszno-4.png", Texture.class);




	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(TEST_TEXTURE);

		manager.load(EXPLOSION_TEXTUREATLAS);
		manager.load(DARALO_TEXTUREATLAS);
		manager.load(DARALOALLO);

		manager.load(MUSIC);
		manager.load(SOUND);
		manager.load(NOSOUND);

		manager.load(ACMEREGULAR_FONT);

		manager.load(BACKGROUND);

		manager.load(HUS1);
		manager.load(HUS2);
		manager.load(HUS3);
		manager.load(HUS4);
		manager.load(HUS5);
		manager.load(GYILKOS1);
		manager.load(GYILKOS2);
		manager.load(GYILKOS3);
		manager.load(RONT1);
		manager.load(RONT2);

		manager.load(DISZNOCSONTVAZ);
		manager.load(DISZNODARAB1);
		manager.load(DISZNODARAB2);
		manager.load(DISZNODARAB3);
		manager.load(DISZNODARAB4);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}


}
