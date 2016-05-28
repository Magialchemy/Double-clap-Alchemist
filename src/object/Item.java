package object;

import java.util.ArrayList;

import system.NoItemNameException;
import system.Tools;

public class Item{

	public String name;

	public int buy;

	public ArrayList<Material> recipe = new ArrayList<Material>();

	public static Tools util = new Tools();

	public Item(String str) throws NoItemNameException{
		this.name = str;

		switch(name) {
		case "ポーション" :
			buy = 800;
			recipe.add(("やくそう"));
			recipe.add(new("からのびん"));
			break;

		case "ハイポーション" :
			buy = 2000;
			break;

		case "かえんびん":
			buy = 3000;
			break;

		case "こおりのつぼ":
			buy = 3000;
			break;

		default:
			throw new NoItemNameException();


		}
	//コンストラクタのおわり
	}

	public boolean equals(Object o){
		if(this == o){return true;}
		if(o instanceof Item){
			Item m = (Item) o;
			if (this.name.equals(m.name)){
				return true;
			}
		}
		return false;
	}

	//メソッドのおわり
	//useItem(itemname);で使用
	public void useItem(Player player,Enemy enemy,Item item) throws InterruptedException, NoItemNameException{

		switch(this.name){

		case "ポーション" :
			potion(player);
			break;

		case "ハイポーション" :
			high_potion(player);
			break;

		case "かえんびん":
			fire_pod(player,enemy);
			break;

		case "こおりのつぼ":
			ice_pod(player,enemy);
			break;
		}
	}


	//炎系攻撃アイテム
	private void fire_pod(Player player, Enemy enemy) throws InterruptedException {
		int attack = 20;
		int damage;
		util.showSlowMessage(player.name + "は" + this.name +"を投げつけた！");

		//属性処理
		if(enemy.element == 'L'){
			util.showSlowMessage("効果はばつぐんだ！");
			attack = attack * 2;
		}else if(enemy.element == 'W'){
			util.showSlowMessage("あまり効果がなさそうだ・・・");
			attack = attack / 2;
		}
		//防御力の分引いてみる
		damage = attack - enemy.defence;
		enemy.hp -= damage ;
		util.showSlowMessage(enemy.name + "に" + damage + "の爆炎ダメージ！");

		//アイテム行動処理
		player.isGuarding = false;
		player.isCharging = false;
		player.isAttacking = false;
		//ひるませる
		enemy.isStanned = true;

	}

	//炎系攻撃アイテム
		private void ice_pod(Player player, Enemy enemy) throws InterruptedException {
			int attack = 20;
			int damage;
			util.showSlowMessage(player.name + "は" + this.name +"を投げつけた！");

			//属性処理
			if(enemy.element == 'F'){
				util.showSlowMessage("効果はばつぐんだ！");
				attack = attack * 2;
			}else if(enemy.element == 'R'){
				util.showSlowMessage("あまり効果がなさそうだ・・・");
				attack = attack / 2;
			}
			//防御力の分引いてみる
			damage = attack - enemy.defence;
			enemy.hp -= damage ;
			util.showSlowMessage(enemy.name + "に" + damage + "の爆炎ダメージ！");

			//アイテム行動処理
			player.isGuarding = false;
			player.isCharging = false;
			player.isAttacking = false;
			//ひるませる
			enemy.isStanned = true;

		}

	//回復系アイテム
	private void potion(Player player) throws InterruptedException{
		int potion_life = 30;
		util.showSlowMessage(player.name + "は" + this.name + "を飲んだ！");
		util.showSlowMessage("ごくごく・・・・");
		player.hp += potion_life;
		int actual;
		if(player.hp > player.maxhp){
			//補正をかける
			actual = potion_life - (player.hp - player.maxhp);
			player.hp = player.maxhp;
		}else{
			actual = potion_life;
		}
		util.showSlowMessage(player.name + "のHPが" + actual + "回復した！");

		//アイテム行動処理
		player.isAttacking = false;
		player.isGuarding = false;
		player.isCharging = false;
	}

	//回復系アイテム
		private void high_potion(Player player) throws InterruptedException{
			int potion_life = 70;
			util.showSlowMessage(player.name + "は" + this.name + "を飲んだ！");
			util.showSlowMessage("ごくごく・・・・");
			player.hp += potion_life;
			int actual;
			if(player.hp > player.maxhp){
				//補正をかける
				actual = potion_life - (player.hp - player.maxhp);
				player.hp = player.maxhp;
			}else{
				actual = potion_life;
			}
			util.showSlowMessage(player.name + "のHPが" + actual + "回復した！");

			//アイテム行動処理
			player.isAttacking = false;
			player.isGuarding = false;
			player.isCharging = false;
		}
}
