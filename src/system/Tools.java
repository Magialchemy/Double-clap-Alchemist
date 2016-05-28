package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import object.Player;

public class Tools {

	public boolean goOut(String place,Player player) throws InterruptedException, IOException{
		boolean goOut;
		System.out.println("**************************");
		System.out.println("ここからでますか？");
		showSlowMessage("1：でる");
		showSlowMessage("2：でない");
		System.out.println("**************************");
		System.out.println("▽【数字を入力してください】");

		// コマンド選択
		int outSelect = command_input(1, 2);

		if(outSelect == 1) {
			goOut = true;
			showSlowMessage(player.name + "は"+ place +"をあとにした\nてくてく・・・・\n\n\n\n");
		}else {
			goOut = false;
		}
		return goOut;

		//メソッドのおわり
	}


	// 文字送りさせるメソッド
	public void showSlowMessage(String str) throws InterruptedException {
		char[] charS = str.toCharArray();
		for (int i = 0; i < charS.length; i++) {
			System.out.print(charS[i]);
			Thread.sleep(50);
		}
		System.out.println();
		// メソッドのおわり
	}

	// コマンドを入力させるメソッド
	// スイッチ文と一緒に使うこと
	public int command_input(int min, int max) throws IOException,
			InterruptedException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		int command = 0;
		while (true) {
			try {
				int x = Integer.parseInt(reader.readLine());

				if (x >= min && x <= max) {
					command = x;
					break;
				} else {
					System.out.println(min + "～" + max + "を入力してください");
					continue;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("入力したものが数字ではありません");
				System.out.println(min + "～" + max + "を入力してください");
				continue;
			}
		}
		return command;
		// メソッドのおわり
	}

	// 名前を入力させるメソッド
	public String name_input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;
		while (true) {
			try {
				line = reader.readLine();
				line = line.replace('　', ' ');
				line = line.trim();
				if (line.length() == 0) {
					throw new NoNameException();
				} else {
					break;
				}
			} catch (NoNameException nune) {
				System.out.println("【！】名前がありません");
				System.out.println("      名前を入力してください▽");
			}
		}

		return line;
	}

	// 待機中三角を表示させるメソッド
	// Enterで次にいく
	public void enter_wait() throws IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println();
		System.out.print("**********************▼**");

		reader.readLine();

		System.out.println();

	}

	// ★ 主人公のステータスの表示
	public void showPlayerInfo(Player player) throws IOException,
			InterruptedException {
		System.out.println("**************************");
		System.out.println(player.name);
		System.out.println("LEVEL：" + player.level);
		System.out.println("HP   ：" + player.hp + "/" + player.maxhp);
		System.out.print("MP   ：");
		for (int i = 0; i < player.chargecounter; i++) {
			System.out.print("■");
		}
		System.out.println();
		System.out.println("EXP  ：" + player.exp + "/" + player.neededEXP);
		if (!(player.item == null)) {
			System.out.println("ITEM ：" + player.item.name);
		} else {
			System.out.println("ITEM ：");
		}
		System.out.println("MONEY：\\" + player.money);
		enter_wait();

		// メソッドのおわり
	}

	// アイテムを表示するメソッド
	public void showItemInventory(Player player) throws InterruptedException,
			IOException {
		System.out.println("**************************");
		System.out.println(player.name + "が持っている道具");
		System.out.println("**************************\n");
		for (int i = 0; i < player.itemInventory.size(); i++) {
			if (i + 1 < 10) {
				System.out.print(" ");
			}
			System.out.println(i + 1 + "：" + player.itemInventory.get(i).name);
			// ループおわり
		}
		enter_wait();
		// メソッドおわり
	}

	// 武器を表示するメソッド
	public void showArmorInventory(Player player) throws InterruptedException,
			IOException {
		System.out.println("**************************");
		System.out.println(player.name + "が持っている装備");
		System.out.println("**************************\n");
		for (int i = 0; i < player.armorInventory.size(); i++) {
			if (i + 1 < 10) {
				System.out.print(" ");
			}
			System.out.println(i + 1 + "：" + player.armorInventory.get(i).name);
			// ループおわり
		}
		enter_wait();
		// メソッドおわり
	}

	// 素材を表示するメソッド
	public void showMaterialInventory(Player player)
			throws InterruptedException, IOException {
		System.out.println("**************************");
		System.out.println(player.name + "が持っている素材");
		System.out.println("**************************\n");
		for (int i = 0; i < player.materialInventory.size(); i++) {
			if (i + 1 < 10) {
				System.out.print(" ");
			}
			System.out.println(i + 1 + "："
					+ player.materialInventory.get(i).name);
			// ループおわり
		}
		enter_wait();
		// メソッドおわり
	}
	// クラスのおわり
}
