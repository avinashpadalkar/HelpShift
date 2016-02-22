import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divider {

	public static void main(String[] args) {
		Divider sample = new Divider();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int f_no = 0, l_no = 0, multiple = 0;
		System.out.println("\n Enter Your Number Range Between : ");

		try {
			f_no = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n and  : ");

		try {
			l_no = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n Enter Multiple : ");
		try {
			multiple = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((f_no >= multiple || l_no >= multiple)&& multiple!=0) {

			if (f_no <= l_no) {

				sample.findDivider(l_no, f_no, multiple);
			} else {

				sample.findDivider(f_no, l_no, multiple);
			}

		} else {

			System.out.println("\nPlease Enter Valid Multiple !!!");

		}

	}

	void findDivider(int LA_No, int FA_No, int multiple) {
		
		System.out.println("\nReverse order of Multiples : ");

		int counter =0;
		
		for (int i = LA_No; i >= FA_No; i--) {
			if (i % multiple == 0) {
				System.out.println("\n " + i);
				counter++;
			}

		}
		System.out.println("\nTotal count of Multiples  : " +counter);
	}
	

}
