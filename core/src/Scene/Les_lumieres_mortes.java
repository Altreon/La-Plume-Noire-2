package Scene;

public class Les_lumieres_mortes extends Scene{
	private static String sceneName = "Les lumieres mortes";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 20, 120+16-10}, {1110, 98, 90, 26, 21, 120+16-5}};
	private static float[] audioInfo = {1.8F, 120+16.6F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Les_lumieres_mortes () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
