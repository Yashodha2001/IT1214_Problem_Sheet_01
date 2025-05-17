
class Students{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks){
		if (marks<=100 && marks>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	Students(String na,int e1, int e2,int e3){
		name=na;
		
		if(validateMarks(e1)&&validateMarks(e2)&&validateMarks(e3)){
			exam1=e1;
		    exam2=e2;
		    exam3=e3;
		}
	else{
		System.out.println("invalid marks");
	}
	}
	
	String getname(){
		return name;
	}
	
	int getexam1(){
		return exam1;
	}
	int getexam2(){
		return exam2;
	}
	int getexam3(){
		return exam3;
	}
	



	public static void main(String[] args){
		
		
		Students s1=new Students("Adam",99,102,-55);
		Students s2=new Students("Eve",99,98,75);
		
		
		System.out.println("Name of the student 1 is "+s1.getname());
		System.out.println("Marks of the student1 for exam 1 is "+s1.getexam1);
		System.out.println("Marks of the student1 for exam 2 is"+s1.getexam2);
		System.out.println("Marks of the student1 for exam 3 is "+s1.getexam3);
		
		
		System.out.println("Name of the student 2 is "+s2.getname());
		System.out.println("Marks of the student2 for exam 1 is "+s2.getexam1);
		System.out.println("Marks of the student2 for exam 2 is "+s2.getexam2);
		System.out.println("Marks of the student2 for exam 3 is"+s2.getexam3);
		
	}

}