package Scene;

public class La_vie_des_hauts extends Scene{
	//A
	//HAUTS
	//PASSAGE
	private static String sceneName = "La vie des hauts";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 3, 60+55}, {1110, 98, 90, 26, 2, 120+2}};
	private static float[] audioInfo = {1.8F, 120+7.2F};
	private static float[] coinTime =  {60+28.9F, 60+42.7F, 60+36, 60+34.4F, 60+36.74F};
	
	public La_vie_des_hauts () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
