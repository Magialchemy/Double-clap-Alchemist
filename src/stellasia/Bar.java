package stellasia;

import java.io.IOException;

import object.BuildingSpace;
import object.Player;

public class Bar extends BuildingSpace {

	public void goThere(Player player) throws InterruptedException, IOException {

		tl.showSlowMessage("てくてく・・・・\n\n\n\n" + player.name + "は\"星の酒場\"についた");

		tl.showSlowMessage("多くの冒険者がお話をしている");
		boolean goOut = false;
		tl.showPlayerInfo(player);
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("なにをしようか？");
			tl.showSlowMessage("1：マスターに話しかける");
			tl.showSlowMessage("2：冒険者に話を聞く");
			tl.showSlowMessage("3：ガチャポンを回す");
			tl.showSlowMessage("0：ここから立ち去る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int barSelect = tl.command_input(0, 3);
			switch (barSelect) {
			case 1:
				master();
				break;
			case 2:
				otherAdventurer();
				break;
			case 3:
				vendingSlot();
				break;
			case 0:
				System.out.println("**************************");
				System.out.println("ここからでますか？");
				tl.showSlowMessage("1：でる");
				tl.showSlowMessage("2：でない");
				System.out.println("**************************");
				System.out.println("▽【数字を入力してください】");

				// コマンド選択
				int outSelect = tl.command_input(1, 2);

				Thread.sleep(800);
				if (outSelect == 1) {
					goOut = true;
					tl.showSlowMessage(player.name + "は酒場をあとにした\nてくてく・・・・\n\n\n\n");
				} else {
					continue;
				}
				break;
			}
			// ループのおわり
		}
		// メソッドのおわり
	}

	// 他の冒険者とお話をする
	private void otherAdventurer() {

	}

	// ガチャポンを回す
	private void vendingSlot() {

	}

	// マスターと話す
	private void master() {

	}

}
