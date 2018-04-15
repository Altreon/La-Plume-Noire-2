package la.plume.noire2.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import la.plume.noire2.LaPlumeNoire2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "La Plume Noire 2";
		config.addIcon("bin/icon.png", Files.FileType.Internal);
		config.width = 1280;
		config.height = 720;
		/*config.width = 600;
		config.height = 480;*/
		config.fullscreen = false;
		config.resizable = false;
		new LwjglApplication(new LaPlumeNoire2(null), config);
	}
}
