import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println(Math.PI);
		//1회용 작업의 경우 인스턴스필요없으나 (생성자-constructor가 없는 경우)
		
		PrintWriter p1 = new PrintWriter("result1.exe");
	   //데이터타입  변수명   클래스명에 new 를 붙임으로써 인스턴스생성 
		p1.write("Hello 1"); //인스턴스.쓰고자하는기능 (PrintWriter 클래스의 write 기능)
		p1.close();

		PrintWriter p2 = new PrintWriter("result2.exe");
		p2.write("Hello 2");
		p2.close();
		
		//다수파일작업이나 수정이 필요한 작업의 경우 new를 붙여 클래스를 복제하여 각기 다른 상태를 가진 인스턴스로 만들어 사용하는 것이 효율적 
		//예시
		Scanner apk = new Scanner(System.in);
		String a = apk.nextLine();
		System.out.println(a);
		
		
	}

}
