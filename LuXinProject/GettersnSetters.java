
public class GettersnSetters {
	String Name, DoB, Height, Hair, Eyes, Sex, Nationality, Scars, Crime;
	int Weight, Reward;
	
	public GettersnSetters(){
		
	}
	
	public GettersnSetters(String name, String doB, String height, String hair, String eyes, String sex, String nationality, String scars, String crime, int weight, int reward) {
		super();
		// TODO Auto-generated constructor stub
		Name = name;
		DoB = doB;
		Height = height;
		Hair = hair;
		Eyes = eyes;
		Sex = sex;
		Nationality = nationality;
		Scars = scars;
		Crime = crime;
		Weight = weight;
		Reward = reward;
	}
	
	public String getCrime() {
		return Crime;
	}
	
	public void setCrime(String crime) {
		Crime = crime;
	}
	
	public String getDoB() {
		return DoB;
	}
	
	public void setDoB(String doB) {
		DoB = doB;
	}
	
	public String getEyes() {
		return Eyes;
	}
	
	public void setEyes(String eyes) {
		Eyes = eyes;
	}
	
	public String getHair() {
		return Hair;
	}
	
	public void setHair(String hair) {
		Hair = hair;
	}
	
	public String getHeight() {
		return Height;
	}
	
	public void setHeight(String height) {
		Height = height;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getNationality() {
		return Nationality;
	}
	
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	
	public int getReward() {
		return Reward;
	}
	
	public void setReward(int reward) {
		Reward = reward;
	}
	
	public String getScars() {
		return Scars;
	}
	
	public void setScars(String scars) {
		Scars = scars;
	}
	
	public String getSex() {
		return Sex;
	}
	
	public void setSex(String sex) {
		Sex = sex;
	}
	
	public int getWeight() {
		return Weight;
	}
	
	public void setWeight(int weight) {
		Weight = weight;
	}
	
}
