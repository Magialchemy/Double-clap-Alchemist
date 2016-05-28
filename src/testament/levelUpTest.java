package testament;

import java.io.IOException;

import object.Item;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.Tools;
import dungeon.Dungeon;

public class levelUpTest {

	public static Tools tl = new Tools();

	public static void main(String[] X) {

		try {
			Player alice = new Player("アリス");

			for (int i = 1; i <= 4; i++) {
				alice.exp = alice.neededEXP - 1;

				tl.showPlayerInfo(alice);

				alice.item = new Item("ポーション");



				switch (i) {
				case 1:
					alice.item = new Item("ポーション");
					Dungeon.battle(alice,alice.item, "スライム");
					break;
				case 2:
					alice.item = new Item("かえんびん");
					Dungeon.battle(alice,alice.item, "ポイズンマッシュ");
					break;
				case 3:
					alice.item = new Item("ポーション");
					Dungeon.battle(alice,alice.item, "メガスライム");
					break;
				case 4:
					alice.item = new Item("かえんびん");
					Dungeon.battle(alice,alice.item, "ゴーレム");
					break;
				}
				System.out.println("\n補正をかけました");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (NoMonsterNameException e) {

			e.printStackTrace();
		} catch (NoItemNameException e) {

			e.printStackTrace();
		}
		// メインメソッドのおわり
	}
}
