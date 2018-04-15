package Scene;

public class For_whom_the_bell_tolls extends Scene{
	private static String sceneName = "For whom the bell tolls";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 11, 60+19}, {1110, 65, 90, 92, 16, 60+24}, {1110, 66, 90, 26, 20, 60+35}};
	private static float[] audioInfo = {1.9F, 60+47.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public For_whom_the_bell_tolls () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
