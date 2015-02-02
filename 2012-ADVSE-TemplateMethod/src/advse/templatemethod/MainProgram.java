package advse.templatemethod;

public class MainProgram {

	public static void main(String[] args) {
	    
		MasterStudentTemplate tom = new NetworkSubjectMasterStudent("Tom");
		tom.graduate();
		
		MasterStudentTemplate mary = new SoftwareEngineeringSubjectMasterStudent("Mary");
        mary.graduate();
        
	}

}
