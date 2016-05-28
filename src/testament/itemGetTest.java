package testament;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import object.Item;
import object.Player;
import system.Tools;

public class itemGetTest {

	public static Tools tl = new Tools();

	public static void main(String[] args) throws IOException{

		try {
		Player alice = new Player("アリス");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		tl.showPlayerInfo(alice);

		System.out.println("何個のアイテムをゲットしますか？");

		int grab = Integer.parseInt(reader.readLine());

		Item potion = new Item("ポーション");

		Item framePod = new Item("かえんびん");

		Item highPotion = new Item("ハイポーション");

		Item icePod = new Item("こおりのつぼ");


		for(int i = 0 ; i < grab; i++){

			int rand = new java.util.Random().nextInt(4);

			switch(rand){
			case 0:
				alice.itemInventory.add(potion);
				System.out.println(alice.name +"は" + potion.name +"を手に入れた");
				break;

			case 1:
				alice.itemInventory.add(framePod);
				System.out.println(alice.name +"は" + framePod.name +"を手に入れた");
				break;

			case 2:
				alice.itemInventory.add(highPotion);
				System.out.println(alice.name +"は" + highPotion.name +"を手に入れた");
				break;

			case 3:
				alice.itemInventory.add(icePod);
				System.out.println(alice.name +"は" + icePod.name +"を手に入れた");
				break;

			}
		}
		tl.showItemInventory(alice);



		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
