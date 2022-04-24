//목표 : 공급가 + vat(10%) 합한 금액을 판매하여 공급가의 일부를 비용(30%), 나머지를 수익으로 거둠, 
// 수익이 10000 이상일 경우 수익을 일정 비율(5:3:2)에 따라 배당함/ 그 아래일 경우 1에게만 모두 배당  	 




import java.util.Scanner;

public class boostcourse_accountingapp_Method {
	public static double vatrate; // 모든메서드에서 사용가능한 전역변수로 선언됨
	public static double vos;

	// method 생성코드
	private static double getVat() { // 전역변수선언없이 간다면 getVat(vos, vatrate)
		return vos * vatrate; // main method에서 vos값을 받고 전역변수로 선언된 vatrate값을 활용
	}

	public static void main(String[] args) { // main method(해당 메서드에서 선언된 변수는 해당 안에서만 사용가능(지역변수))

		// my try
		System.out.println("공급가를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		vos = scanner.nextDouble(); // 전역변수로 선언되더라도 값자체는 안에서 지정할 수 있음

//		double vos = Double.parseDouble(args[0]);  //run configuration 통한 입력(string to double변환)

		double vatrate = 0.1; // 전역변수로 선언되더라도 값자체는 안에서 지정할 수 있음
		double vat = getVat(); // method 호출코드(입력값)(vos만 넣고 vatrate 넣을필요 없는 이유는 vatrate가 main method 바깥에서 전역변수로
								// 선언되었기때문)
		// if 전역변수선언없이 간다면 getVat(vos, vatrate) 넣을값을 지정해주어야

		double total = vos + vat;
		double expenserate = 0.3;
		double expense = vos * expenserate;
		double income = vos - expense;

		// Dividend
		double[] Dividendrate = new double[3]; // !FAIL! if 안에서 선언하는게 아니라 그전에 미리 선언되어야
		double[] Dividend = new double[3];

		if (income > 10000) {
			Dividendrate[0] = 0.5;
			Dividendrate[1] = 0.3;
			Dividendrate[2] = 0.2;
		} else {
			Dividendrate[0] = 1;
			Dividendrate[1] = 0;
			Dividendrate[2] = 0;
		}

		for (int i = 0; i < 3; i++) {
			Dividend[i] = income * Dividendrate[i];
		}

		// print
		System.out.println("공급가는 " + vos);
		System.out.println("부가세는 " + vat);
		System.out.println("판매가는 " + total);
		System.out.println("수익은 " + income);
		System.out.println("비용은 " + expense);

		for (int d = 0; d < 3; d++) { // 소숫점 아래 2자리까지 표현
			System.out.printf("배당 %d의 배당금은 %.2f이다%n", d + 1, Dividend[d]); // !FAIL! d+1을 변환없이 %f로 지정했다가 오류발생 (int에서
																			// double은 손실없어서 괜찮으나)
		} // double to int일 경우 손실이 일어날 수 있기 때문에 사전에 변환이 필요

		// while 사용례
//		int d = 0;
//		while(d<Dividend.length) {
//			System.out.printf("배당 %d의 배당금은 %.2f이다%n", d+1, Dividend[d] );
//			d = d+1;
//			}

	}

}
