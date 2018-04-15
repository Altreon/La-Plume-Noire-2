package Scene;

public class Le_fil_d_Ariane extends Scene{
	private static String sceneName = "Le fil d Ariane";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = true;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 29, 60+32-15}, {1110, 65, 90, 92, 32, 60+32-10}, {1110, 66, 90, 26, 34, 60+32-5}};
	private static float[] audioInfo = {2.15F, 60+32.5F, 60+37.1F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_fil_d_Ariane () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
