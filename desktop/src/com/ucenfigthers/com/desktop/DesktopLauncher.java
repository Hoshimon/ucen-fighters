package com.ucenfigthers.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ucenfigthers.com.GameScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "UCEN Figthers!";
		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new GameScreen(), config);
	}
}
