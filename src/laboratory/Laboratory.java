package laboratory;

import java.io.IOException;

import object.BuildingSpace;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;

public class Laboratory extends BuildingSpace {

	public static MakeItems makeitem = new MakeItems();

	public static MakeArms makearm = new MakeArms();

	public void goThere(Player player) throws InterruptedException, IOException,
			NumberFormatException, NoMonsterNameException, NoItemNameException {

		tl.showSlowMessage("てくてく・・・・\n\n\n\n" + player.name + "は自分の研究所についた");

		boolean goOut = false;
		tl.showPlayerInfo(player);
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("なにをしようか？");
			tl.showSlowMessage("1：すこし休む");
			tl.showSlowMessage("2：アイテムを練成する");
			tl.showSlowMessage("3：武器パーツを練成する");
			tl.showSlowMessage("0：ここから立ち去る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int labSelect = tl.command_input(0, 1);
			switch (labSelect) {

			case 1:
				rest(player);
				break;

			case 2:
				makeitem.startMaking(player);
				break;

			case 3:
				makearm.startMaking(player);
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
					tl.showSlowMessage(player.name + "は研究所をあとにした\nてくてく・・・・\n\n\n\n");
				} else {
					continue;
				}
				break;
			}
			// ループのおわり
		}

		// メソッドのおわり
	}

	// 休憩するメソッド
	void rest(Player player) throws InterruptedException, IOException {
		tl.showSlowMessage(player.name + "は少し休んだ");
		player.hp += 50;
		if (player.hp > player.maxhp) {
			player.hp = player.maxhp;

			Thread.sleep(800);
			tl.showPlayerInfo(player);
		}

		// メソッドのおわり
	}

	// クラスのおわり
}
