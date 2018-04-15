package Scene;

public class Les_fleurs_du_mal extends Scene{
	//E
	//CHERCHE
	//CENTRAL
	private static String sceneName = "Les fleurs du mal";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 98, 90, 124, 11, 120+5}, {1110, 98, 90, 26, 10, 120+10}};
	private static float[] audioInfo = {1.93F, 120+15.6F};
	private static float[] coinTime =  {60+46.17F, 120+1.15F, 60+54, 60+52.07F, 60+55.17F};
	
	public Les_fleurs_du_mal () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
