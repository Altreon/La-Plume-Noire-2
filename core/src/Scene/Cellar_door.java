package Scene;

public class Cellar_door extends Scene{
	private static String sceneName = "Cellar door";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 8, 120}, {1110, 65, 90, 92, 9, 120+7}, {1110, 66, 90, 26, 3, 120+19}};
	private static float[] audioInfo = {1.9F, 120+25F};
	private static float[] coinTime =  {0, 0, 0, 0, 0};
	
	public Cellar_door () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
