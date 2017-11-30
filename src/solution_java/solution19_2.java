package solution_java;


class Business implements Cloneable{
	private String company;
	private String work;
	
	public Business(String company, String work){
		this.company=company;
		this.work=work;
	}
	public void showBusinessInfo(){
		System.out.println("Company : " + company);
		System.out.println("Work : " + work);
	}
	public void changeWork(String work){
		this.work=work;
	}
	/*
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	*/
}

class PersonalInfo implements Cloneable{
	private String name;
	private int age;
	private Business bness;
	
	public PersonalInfo(String name, int age, String company, String work){
		this.name=name;
		this.age=age;
		bness=new Business(company, work);
	}
	public void showPersonalInfo(){
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		bness.showBusinessInfo();
		System.out.println("");
	}
	public void changeWork(String work){
		bness.changeWork(work);
	}
	public Object clone() throws CloneNotSupportedException{
		PersonalInfo copy = (PersonalInfo) super.clone();	
		// copy.bness = (Business) bness.clone();
		return copy;
	}
}

public class solution19_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			PersonalInfo pInfo=
					new PersonalInfo("James", 22, "Himedia", "encoding");
			PersonalInfo pCopy = (PersonalInfo)pInfo.clone();
			pCopy.changeWork("decoding"); 	// Shallow copied
			
			pInfo.showPersonalInfo();
			pCopy.showPersonalInfo();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
	}
}
