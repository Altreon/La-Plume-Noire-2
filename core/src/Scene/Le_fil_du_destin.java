package Scene;

public class Le_fil_du_destin extends Scene{
	private static String sceneName = "Le fil du destin";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = true;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 28, 60+51-15}, {1110, 65, 90, 92, 34, 60+51-10}, {1110, 66, 90, 26, 30, 60+51-5}};
	private static float[] audioInfo = {2.1F, 60+51.6F, 60+56.3F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_fil_du_destin () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
