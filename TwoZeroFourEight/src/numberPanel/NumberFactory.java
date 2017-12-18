package numberPanel;

import javax.swing.JPanel;
public class NumberFactory {
	public static JPanel createNumber(int type){
		switch(type){
		case 2:
			return new Number2();
		case 4:
			return new Number4();
		case 8:
			return new Number8();
		case 16:
			return new Number16();
		case 32:
			return new Number32();
		case 64:
			return new Number64();
		case 128:
			return new Number128();
		case 256:
			return new Number256();
		case 512:
			return new Number512();
		case 1024:
			return new Number1024();
		case 2048:
			return new Number2048();
		}
		return null;
		
	}
}
