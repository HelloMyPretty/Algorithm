package µÚÆß½ì;

public class Test {
	public static void main(String[] args) {
		label:
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=5;j++) {
					System.out.println(j);
					if(j==3)
						continue label;
				}
			}
	}
}
