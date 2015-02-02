package advse.lec7.ex2;

public abstract class MasterStudentTemplate {

	private String name;

	public MasterStudentTemplate(String name) {
		this.name = name;
	}

	public void graduate() {

		readPaper();
		identifyContextAndProblem();
		findSolution();
		evaluateSolution();
		writeProposal();
		oralDefence();
	}

	abstract protected void readPaper();

	abstract protected void identifyContextAndProblem();

	abstract protected void findSolution();

	abstract protected void evaluateSolution();

	private void writeProposal() {
		System.out.println(name + " write a proposal.");
	}

	private void oralDefence() {
		System.out.println(name + " has passed oral exam.");
	}

	public String getName() {
		return name;
	}

}
