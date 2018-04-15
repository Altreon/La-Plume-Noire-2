package Scene;

public class Les_demons_des_profondeurs extends Scene{
	//G
	//VIE
	//EST
	private static String sceneName = "Les demons des profondeurs";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 98, 90, 124, 3, 60+51}, {1110, 98, 90, 26, 2, 60+56}};
	private static float[] audioInfo = {1.9F, 120+1};
	private static float[] coinTime =  {60+34.87F, 60+48.46F, 60+42.5F, 60+41, 60+44.2F};
	
	public Les_demons_des_profondeurs () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
