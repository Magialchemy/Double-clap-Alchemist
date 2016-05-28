package system;

public class NoItemNameException extends Exception{

	//エラーメッセージを受け取るコンストラクタ
	public NoItemNameException(){

	}

	public NoItemNameException(String str){

		System.out.println(str);


	}


}
