package Scene;

public class ENIGMA_X_IMAGINE extends Scene{
	private static String sceneName = "ENIGMA X IMAGINE";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 20, 120+10}, {1110, 98, 90, 26, 26, 60+49}};
	private static float[] audioInfo = {2.1F, 120+27.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public ENIGMA_X_IMAGINE () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
