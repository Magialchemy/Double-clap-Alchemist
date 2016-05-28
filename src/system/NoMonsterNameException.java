package system;

public class NoMonsterNameException extends Exception{

	//エラーメッセージを受け取るコンストラクタ
	public NoMonsterNameException(){

	}

	public NoMonsterNameException(String str){

		System.out.println(str);

	}


	//クラスのおわり
}
