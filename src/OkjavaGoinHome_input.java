

import javax.swing.JOptionPane;

import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.DimmingLights;

public class OkjavaGoinHome_input {
									//args = parameter or 매개변수라고 불리우며 일종이 변수로 인식/배열형태이며 
									// run configuration에서 arguments 값을 받아다 넣음(변수가 배열형이기에 다수 값 받을 수)
	public static void main(String[] args) {
		//org라는 패키지 안에있는 java application 활용하여 
	
//		String id  = JOptionPane.showInputDialog("Enter a ID"); //CTRL SHIFT M
//		String bright  = JOptionPane.showInputDialog("Enter a bright"); //CTRL SHIFT M
		String id = args[0];
		String bright = args[1];
		
		//Elevator call
		Elevator myElevator = new Elevator(id);
		//데이터타입 //변수명				//데이터타입에 맞는 데이터만 받을수 있음
		myElevator.callForUp(1);
				//.으로 시작해서 ()로 끝나는 명령어는 '메서드'라고 명명
		
		//Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		//Light on
		Lighting hallLamp = new Lighting(id + " / Hall Lamp");
		hallLamp.on();

		Lighting floorLamp = new Lighting(id + " / floor Lamp");
		floorLamp.on();
		//디버거에서 step over - 한줄한줄 내려가면서 실행
		// step into - 메서드사용하고 있다면 해당 메서드로 들어가기  되돌아가려면 step return 
	
		DimmingLights moodLamp = new DimmingLights(id + " / moodLamp");
		moodLamp.setBright(Double.parseDouble(bright)); //위에서 입력받은 값은 string이기에 입력칸에서 double로 전환 
		moodLamp.on();
	
	}

}


