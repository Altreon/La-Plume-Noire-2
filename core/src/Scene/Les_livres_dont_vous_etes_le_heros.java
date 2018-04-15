package Scene;

public class Les_livres_dont_vous_etes_le_heros extends Scene{
	private static String sceneName = "Les livres dont vous etes le heros";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 6, 60+44}, {1110, 65, 90, 92, 100, 60+23}, {1110, 66, 90, 26, 3, 60+54}};
	private static float[] audioInfo = {1.8F, 60+59.4F};
	private static float[] coinTime =  {0, 0, 0, 0, 0};
	
	public Les_livres_dont_vous_etes_le_heros () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
