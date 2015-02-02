package fcu.advse.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import fcu.advse.reflection.annotation.ExecuteThisMethod;

public class UniversalContainer
{

    public static void main(String[] args)
    {
        InputStream is = UniversalContainer.class.getResourceAsStream("plugin.properties");

        Properties prop = new Properties();
        try
        {
            prop.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String className = prop.getProperty("component.class.name");
        System.out.println("Loading component: " + className);

        try
        {
            Object object = Class.forName(className).newInstance();

            Method[] methods = object.getClass().getMethods();

            for (Method method : methods)
            {
                if (method.isAnnotationPresent(ExecuteThisMethod.class))
                {
                    try
                    {
                        method.invoke(object);
                    }
                    catch (IllegalArgumentException e)
                    {
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
