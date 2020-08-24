package pages.Counting_No_Backword;

public class CountingInReverseOrder {
	
	public void RevereCount() {
		
		for(int i=100;i>0;i--) {
			if((i%5==0)&&(i%3==0)) {
				System.out.println("TESTING");
				//continue;
			}else if(i%5==0) {
				System.out.println("AGILE");
				//continue;
			}else if(i%3==0) {
				System.out.println("SOFTWARE");
				//continue;
			}else {
				System.out.println("Number: "+i);
			}
		}		
	}

	
}
