
public class Alg {

	public static void main(String[] args) {
		int first = 86897;
		int snd = 58873;
		int remainder = 1;
		
		do{
		remainder = first % snd;
		System.out.println (remainder);
		first = snd;
		snd = remainder;
		}while (remainder != 0);
		
	}

}
