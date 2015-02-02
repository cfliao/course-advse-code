package advse.templatemethod;

public class SoftwareEngineeringSubjectMasterStudent extends MasterStudentTemplate
{

    public SoftwareEngineeringSubjectMasterStudent(String name)
    {
        super(name);
    }

    @Override
    protected void readPaper()
    {
        System.out.println(getName() + " first read software engineering papers");
    }

    @Override
    protected void identifyContextAndProblem()
    {
        System.out.println(getName() + " find a reusability problem");
    }

    @Override
    protected void findSolution()
    {
        System.out.println(getName() + " enhance reusability by an architecture");
    }

    @Override
    protected void evaluateSolution()
    {
        System.out.println("Based on the evaluation, " + getName() + " observed that the reusability has been improved");
    }

}
