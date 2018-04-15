package Scene;

public class Random_house extends Scene{
	private static String sceneName = "Random house";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 4, 60+21}, {1110, 65, 90, 92, 5, 60+41}, {1110, 66, 90, 26, 7, 60+46}};
	private static float[] audioInfo = {1.8F, 60+54.2F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Random_house () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
