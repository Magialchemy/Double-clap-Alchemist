package testament;

import java.io.IOException;

import dungeon.Dungeon;
import object.Armor;
import object.Enemy;
import object.Item;
import object.Material;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.OverProbabilityException;
import system.Tools;

public class TreasureTest {

	public static Tools tl = new Tools();

	public static void main(String[] args) throws IllegalArgumentException, OverProbabilityException,
			InterruptedException, IOException, NoMonsterNameException, NoItemNameException {
		// TODO 自動生成されたメソッド・スタブ

		Player alice = new Player("アリス");

		tl.showPlayerInfo(alice);

		Dungeon.treasure(1.0, alice, 0.30, new Armor("ウッドパック"), 0.1, new Material("木の板"), 0.1, new Item("ポーション"), 0.25,
				new Enemy("メガスライム"), 0.25, 1000);

	}

}
