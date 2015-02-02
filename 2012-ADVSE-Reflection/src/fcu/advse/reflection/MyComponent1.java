package fcu.advse.reflection;

import fcu.advse.reflection.annotation.ExecuteThisMethod;

public class MyComponent1
{
    @ExecuteThisMethod
    public void perform()
    {
        System.out.println("Hello World from perform 1");
    }

    public void perform2()
    {
        System.out.println("Hello World from perform 2");
    }

}
