package Scene;

public class Les_enigmes_dans_le_noir extends Scene{
	private static String sceneName = "Les enigmes dans le noir";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 14, 60+32}, {1110, 65, 90, 92, 15, 60+43}, {1110, 66, 90, 26, 11, 120+23}};
	private static float[] audioInfo = {2.05F, 120+31.4F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Les_enigmes_dans_le_noir () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
