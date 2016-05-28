package object;


public class Character {

	//それぞれのキャラクターが持つもの
	public int hp;
	public int maxhp;
	public int power;
	public int defence;
	public String name;
	public char element;
	public int charge_pow;

	//全キャラクター共通の初期設定
	public int chargecounter = 0;
	public boolean isAlive = true;

	//攻撃、防御の判定に使う(初期値はfalse)
	public boolean isAttacking;
	public boolean isGuarding;
	public boolean isCharging;

	public void attack(){
		System.out.println(name + "は攻撃しようとした！");
		this.isGuarding = false;
		this.isCharging = false;
		this.isAttacking = true;
	}

	public void guard(){
		System.out.println(name + "は防御体制をとった！");
		this.isAttacking = false;
		this.isCharging = false;
		this.isGuarding = true;
	}

	public void charge(){
		System.out.println(name + "は魔力をためている・・・");
		this.isGuarding = false;
		this.isAttacking = false;
		this.isCharging = true;
		chargecounter++;
	}


}
