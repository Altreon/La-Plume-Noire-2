package Scene;

public class Les_rats_dans_les_murs extends Scene{
	private static String sceneName = "Les rats dans les murs";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 3, 60+51}, {1110, 98, 90, 26, 20, 60+56}};
	private static float[] audioInfo = {1.9F, 120+1};
	private static float[] coinTime =  {0, 0, 0, 0, 0};
	
	public Les_rats_dans_les_murs () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
