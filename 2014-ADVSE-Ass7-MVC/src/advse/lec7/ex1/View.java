package advse.lec7.ex1;

public abstract class View implements Observer
{
    protected Model model;

    protected Controller controller;

    public View(Model model)
    {
        this.model = model;
        model.attach(this);
        controller = makeController(model, this);
    }

    private static Controller makeController(Model m, View v)
    {
        return new Controller(m, v);
    }

    public void activate(String input)
    {
        controller.handelEvent(new Event(input));
    }

    abstract public void display();
    

    public void update(Event event)
    {
    }

}
