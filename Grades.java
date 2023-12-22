import java.util.Scanner;
public class Grades {
	static Scanner sn =new Scanner(System.in);
	
	public static double homework(int hwWeight) {
		System.out.println("Homework:");
		System.out.print("Number of Assignments? (Type 0 if N/A) ");
		int numAssignments=sn.nextInt();
		System.out.print("Average Homework Grade? ");
		double avgHwGrade=sn.nextDouble();
		System.out.print("Number of Late Days Used? ");
		int lateDays=sn.nextInt();
		System.out.print("Labs Attended? ");
		int labsAtt=sn.nextInt();
		if (numAssignments<=0) {
			numAssignments=10;
			avgHwGrade=10;
			labsAtt=10;
		}
		if (avgHwGrade>10) {
			avgHwGrade=10;
		}else if (avgHwGrade<0) {
			avgHwGrade=0;
		}
		int maxHwPoints=(numAssignments*10)+(numAssignments*4);
		double userHwPoints=(numAssignments*avgHwGrade)+(labsAtt*4);
		if (lateDays>(numAssignments/2)){
			userHwPoints=(userHwPoints*.9);
		}
		else if (lateDays==0) {
			if (userHwPoints+5<=maxHwPoints) {
				userHwPoints+=5;
			}else if (userHwPoints+5>maxHwPoints) {
				userHwPoints=maxHwPoints;
			}
		}
		System.out.println("Total Points: "+userHwPoints+" / "+maxHwPoints);
		double hwWeightScore=hwWeight*(userHwPoints/maxHwPoints);
		System.out.printf("Weighted Score: %.2f\n",hwWeightScore);
		spacing();
		return(hwWeightScore);
	}
	
	public static double exam1(int exam1Weight) {
		System.out.println("Exam 1:");
		System.out.print("Score? ");
		int exam1Score=sn.nextInt();
		if (exam1Score<0) {
			exam1Score=0;
		}
		System.out.print("Curve? ");
		int exam1Curve=sn.nextInt();
		double exam1Points=0;
		if (exam1Score+exam1Curve<=100) {
			exam1Points=exam1Score+exam1Curve;
		}else if (exam1Score+exam1Curve>100) {
			exam1Points=100;
		}
		System.out.println("Total Points: "+exam1Points+" / 100");
		double exam1WeightScore=exam1Weight*(exam1Points/100);
		System.out.printf("Weighted Score: %.2f\n",exam1WeightScore);
		spacing();
		return(exam1WeightScore);
	}
	
	public static double exam2(int exam2Weight) {
		System.out.println("Exam 2:");
		System.out.print("Score? ");
		int exam2Score=sn.nextInt();
		if (exam2Score<0) {
			exam2Score=0;
		}
		System.out.print("Curve? ");
		int exam2Curve=sn.nextInt();
		double exam2Points=0;
		if (exam2Score+exam2Curve<=100) {
			exam2Points=exam2Score+exam2Curve;
		}else if (exam2Score+exam2Curve>100) {
			exam2Points=100;
		}
		System.out.println("Total Points: "+exam2Points+" / 100");
		double exam2WeightScore=exam2Weight*(exam2Points/100);
		System.out.printf("Weighted Score: %.2f\n",exam2WeightScore);
		spacing();
		return(exam2WeightScore);
	}
	
	public static void spacing() {
		for (int i=0; i<3; i++) {
		System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This program accepts your homework and two exam scores as input and computes your grade in the course");
		System.out.println();
		System.out.print("Homework Weight? ");
		int hwWeight=sn.nextInt();
		System.out.print("Exam 1 Weight? ");
		int exam1Weight=sn.nextInt();
		int exam2Weight=100-hwWeight-exam1Weight;
		System.out.println("Using Weights of "+hwWeight+" "+exam1Weight+" "+exam2Weight);
		spacing();
		double hwWeightScore=homework(hwWeight);
		double exam1WeightScore=exam1(exam1Weight);
		double exam2WeightScore=exam2(exam2Weight);
		double courseGrade=(hwWeightScore+exam1WeightScore+exam2WeightScore);
		System.out.printf("Course Grade: %.2f\n",courseGrade);
		sn.close();

	}

}
