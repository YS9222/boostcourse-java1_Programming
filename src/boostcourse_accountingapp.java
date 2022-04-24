import java.util.Scanner;

public class boostcourse_accountingapp {

	public static void main(String[] args) {
		//목표 : 공급가 + vat(10%) 합한 금액을 판매하여 공급가의 일부를 비용(30%), 나머지를 수익으로 거둠, 
		// 수익이 10000 이상일 경우 수익을 일정 비율(5:3:2)에 따라 배당함/ 그 아래일 경우 1에게만 모두 배당  	 

		//my try
		System.out.println("공급가를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		double vos = scanner.nextDouble();
//		double vos = Double.parseDouble(args[0]);  //run configuration 통한 입력(string to double변환)
		
		double vatrate = 0.1;
		double vat = vos*vatrate;
		double total = vos+vat;
		double expenserate = 0.3;
		double expense = vos*expenserate;
		double income = vos-expense;
		
		
		//Dividend 
		double[] Dividendrate = new double[3]; //!FAIL! if 안에서 선언하는게 아니라 그전에 미리 선언되어야
		double[] Dividend = new double [3];
		
		if(income>10000) {
			Dividendrate[0] = 0.5;
			Dividendrate[1] = 0.3;	
			Dividendrate[2] = 0.2;	
		}else {
			Dividendrate[0] = 1;	
			Dividendrate[1] = 0;	
			Dividendrate[2] = 0;	
		}
		
		for(int i = 0; i<3; i++) {
			Dividend[i] = income * Dividendrate[i];
		}
		
		//print
		System.out.println("공급가는 " + vos);
		System.out.println("부가세는 " + vat);
		System.out.println("판매가는 " + total);
		System.out.println("수익은 " + income); 
		System.out.println("비용은 " + expense);
		
		for(int d = 0; d<3; d++) {		     //소숫점 아래 2자리까지 표현
			System.out.printf("배당 %d의 배당금은 %.2f이다%n", d+1, Dividend[d] ); //!FAIL! d+1을 변환없이 %f로 지정했다가 오류발생 (int에서 double은 손실없어서 괜찮으나)
		}																	//double to int일 경우 손실이 일어날 수 있기 때문에 사전에 변환이 필요

		//while 사용례
//		int d = 0;
//		while(d<Dividend.length) {
//			System.out.printf("배당 %d의 배당금은 %.2f이다%n", d+1, Dividend[d] );
//			d = d+1;
//			}
		
		}


	}


