package stellasia;

import java.io.IOException;

import object.BuildingSpace;
import object.Player;

public class CityHall extends BuildingSpace {

	public void goThere(Player player) throws InterruptedException, IOException {

		tl.showSlowMessage("てくてく・・・・\n\n\n\n" + player.name + "は市役所についた");

		inCityHall(player);
	// メソッドのおわり
	}

	private void inCityHall(Player player) throws IOException, InterruptedException {
		// TODO 自動生成されたメソッド・スタブ

		boolean goOut = false;
		tl.showPlayerInfo(player);
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("なにをしようか？");
			tl.showSlowMessage("1：ソル市長とお話する");
			tl.showSlowMessage("2：周りの人とお話をする");
			tl.showSlowMessage("0：ここから立ち去る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int chSelect = tl.command_input(0, 2);
			switch (chSelect) {

			case 1:
				talkSol();
				break;

			case 2:
				talkCityHall();
				break;

			case 0:
				goOut = tl.goOut("市役所",player);
				break;
			}
			// ループのおわり
		}

	}

	private void talkCityHall() {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void talkSol() {
		// TODO 自動生成されたメソッド・スタブ

	}


// クラスのおわり
}
