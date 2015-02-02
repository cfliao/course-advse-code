package advse.lec7.ex1;

public class MyView2 extends View
{
    public MyView2(Model model)
    {
        super(model);
    }

    public void display()
    {
        String data = model.getData();
        System.out.println("MyView2: data=" + data);
    }
}
