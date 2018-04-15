package Scene;

public class Cendres_de_lune extends Scene{
	//M
	//DES
	//BON
	private static String sceneName = "Cendres de lune";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 5, 60+25}, {1110, 65, 90, 92, 7, 60+31}, {1110, 66, 90, 26, 2, 60+37}};
	private static float[] audioInfo = {1.8F, 60+42.7F};
	private static float[] coinTime =  {29, 50.6F, 42, 38, 44.55F};
	
	public Cendres_de_lune () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
