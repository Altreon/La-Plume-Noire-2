package Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import la.plume.noire2.LaPlumeNoire2;

public class Gnothi_seauton_part2 extends Scene{
	private static String sceneName = "Gnothi seauton part2";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 720};
	private static int[][] textInfo = {{1110, 196, 90, 0, 0, 31}, {1110, 65, 90, 92, 0, 31+5}, {1110, 66, 90, 26, 0, 31+10}};
	private static float[] audioInfo = {0};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	private FileHandle introEndFile2;
	private int[] boucleInfo2 = {0, 5};
	protected FileHandle[] boucle2;
	private int switchStat = 0;
	private int[] switchScreenTime = {25, 60+37};
	private boolean setTime = false;
	
	public Gnothi_seauton_part2 () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
		if(Gdx.app.getType().name().equals("Desktop")) {
			loadFile2("bin/" + sceneName + "/boucle2");
			introEndFile2 = Gdx.files.internal("bin/" + sceneName + "/introEnd.jpg");
		}else if(Gdx.app.getType().name().equals("Android")) {
			loadFile2(LaPlumeNoire2.data + "/" + sceneName + "/boucle2");
			introEndFile2 = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/introEnd.jpg");
		}
	}
	
	@Override
	public void update () {
		if(isPause){
			unPause();
		}
		
		if(stat == 0){
			if(LaPlumeNoire2.getLanch().isPlaying()){
				if(firstScene){
					if(System.currentTimeMillis() - time >= 20){
						imgApear(true, true);
						time += 20;
					}
				}else{
					if(System.currentTimeMillis() - time >= 10){
						imgApear(false, true);
						time += 10;
					}
				}
			}else{
				introBegin.dispose();
				introEnd.dispose();
				if(!speBoucle){
					introBegin = new Pixmap(introEndFile);
				}else{
					introBegin = new Pixmap(boucle[boucleInfo[1]-1]);
				}
				introEnd = new Pixmap(introEndFile2);
				
				stat++;
				LaPlumeNoire2.getLanch().stop();
				preS = new int[55];
				frameText = new int[textInfo.length];
				startTimeText = new float[textInfo.length];
				timeText = System.currentTimeMillis();
				startText = new boolean[textInfo.length];
				endText = new boolean[textInfo.length];
				for(int i=0; i < textInfo.length; i++){
					startText[i] = true;
					endText[i] = false;
				}
				audio.play();
			}
			
		}else if(stat == 1){
			if(switchStat == 0){
				if(!speBoucle){
					if(System.currentTimeMillis() - time > 33){
						if(frame < boucleInfo[1]-1){
							frame++;
						}else{
							frame = boucleInfo[0];
						}
						img.dispose();
						Pixmap pixmap = new Pixmap(boucle[frame]);
						img = new Texture(pixmap);
						pixmap.dispose();
						time += 33;
					}
				}else if(frame < boucleInfo[1]-1 && System.currentTimeMillis() - time > 33){
					frame++;
					img.dispose();
					Pixmap pixmap = new Pixmap(boucle[frame]);
					img = new Texture(pixmap);
					pixmap.dispose();
					time += 33;
				}
					
			}else if(switchStat == 1){
				if(!singleDraw){
					img = new Texture(introEndFile2);
					singleDraw = true;
				}
				if(System.currentTimeMillis() - timeText >= 40){
					for(int i=0; i < textInfo.length; i++){
						if(isText(i)){
							textApear(i, false);
						}
					}
					timeText += 40;
				}
			}else{
				if(!setTime && audio.getPosition() >= 60+39.24F){
					time = System.currentTimeMillis();
					setTime = true;
				}
				if(setTime && frame < boucleInfo2[1]-1 && System.currentTimeMillis() - time > 33*3){
					frame++;
					img.dispose();
					Pixmap pixmap = new Pixmap(boucle2[frame]);
					img = new Texture(pixmap);
					pixmap.dispose();
					time += 33*3;
				}
				if(!audio.isPlaying()){
					close(false);
					unload();
					stat = 0;
					switchStat = 0;
					setTime = false;
					LaPlumeNoire2.ending();
				}
			}
			if(switchStat < 2 && switchScreenTime[switchStat] <= audio.getPosition()){
				singleDraw = false;
				stat++;
			}
			
		}else if(stat == 2){
			if(switchScreenTime[switchStat] + 2 > audio.getPosition()){
				if(System.currentTimeMillis() - time >= 20){
					imgEndApear(true);
					time += 20;
				}
			}else{
				img.dispose();
				img = new Texture(introEnd);
				introBegin.dispose();
				introBegin = new Pixmap(introEndFile2);
				introEnd.dispose();
				introEnd = new Pixmap(boucle2[0]);
				switchStat++;
				frame = 0;
				stat--;
			}
			
		}else if(stat == 4){
			if(LaPlumeNoire2.getLanch().getPosition() < 1.5F){
				if(System.currentTimeMillis() - time >= 10){
					imgApear(false, false);
					if(asText){
						for(int i=0; i < textInfo.length; i++){
							textApear(i, true);
						}
					}
					time += 10;
				}
			}else{
				if(asText){
					textBegin.drawPixmap(textEnd, 0, 0);
					imgText.dispose();
					imgText = new Texture(textBegin);
				}
				stat = 0;
				preS = new int[25];
				preTextS = new int[85];
				firstScene = false;
				if(!LaPlumeNoire2.isLastScenes()){
					passAudio = true;
				}
				isEnd = false;
				LaPlumeNoire2.change();
			}
		}
	}
	
	private void loadFile2 (String folderPath) {
		FileHandle folder = Gdx.files.absolute(folderPath);
		boucle2 = new FileHandle[folder.list().length];
		int i=0;
		for (FileHandle file : folder.list()) {
			boucle2[i] = file;
			i++;
		}
	}
	
	@Override
	public void imgEndApear (boolean intro) {
		int s = 0;
		if(intro){
			s = 28 - (int)(((2f - (audio.getPosition() - switchScreenTime[switchStat]))/2f) * 28);
		}else{
			s = 29 - (int)(((2f - (audio.getPosition() - switchScreenTime[switchStat] - 2))/2f) * 29);
		}
		if(frame < 6-1){
			frame ++;
		}else{
			frame = 0;
		}
		for(int x=frame; x <= 54; x+=6){
			for(int f=0; f < s-preS[x]; f++){
				if(x%2 == 0){
					for(int y=0; y <= 318/2; y+=8){
						for(int a=y; a < y+8; a++){
							introBegin.drawPixel(((x*14)+s-f) - 14, y+a, introEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}else{
					for(int y=4; y <= 318/2; y+=8){
						for(int a=y; a < y+8; a++){
							introBegin.drawPixel(((x*14)+s-f) - 14, y+a, introEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}
			}
			preS[x] = s;
		}
		img.dispose();
		img = new Texture(introBegin);
	}
	
	@Override
	public void unload () {
		introBegin.dispose();
		if(asText){
			textBegin.dispose();
			textEnd.dispose();
		}
		introEnd.dispose();
		img.dispose();
		imgText.dispose();
		audio.dispose();
		mouvementPos = 0;
		mouvementSave = 0;
		mouv = false;
		mouvSt = 0;
		
		//+
		switchStat = 0;
		setTime = false;
	}
}
