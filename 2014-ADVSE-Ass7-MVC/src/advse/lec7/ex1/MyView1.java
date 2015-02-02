package advse.lec7.ex1;

public class MyView1 extends View
{
    public MyView1(Model model)
    {
        super(model);
    }

    public void display()
    {
        String data = model.getData();
        System.out.println("MyView1: data=" + data);
    }
}
