package object;

import java.util.ArrayList;

import system.NoItemNameException;

public class Armor {

	public String name;

	public int buy;

	public int defUp;

	public int powUp;

	public ArrayList<Material> recipe = new ArrayList<Material>();

	public Armor(String str) throws NoItemNameException {
		name = str;

		switch(name) {
			case "ウッドパック" :
				buy = 1000;
				defUp = 5;
				powUp = 1;
				recipe.add(new Material("木の板"));
				recipe.add(new Material("ボルト"));
				break;

			case "スチールパック" :
				buy = 1000;
				defUp = 10;
				powUp = 2;
				recipe.add(new Material("木の板"));
				recipe.add(new Material("ボルト"));
				break;

			case "フレアブラスター":
				buy = 2000;
				defUp = -2;
				powUp = 6;
				Player.attackElement = 'F';
				recipe.add(new Material("炎の石"));
				recipe.add(new Material("鉄鉱石"));

				break;

			default:
				throw new NoItemNameException();
		}
	//

	}

	//クラスの終わり
}
