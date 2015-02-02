package fcu.advse.bb;

import java.util.Random;

import net.jini.lookup.entry.Name;

public class Segmentation extends KnowledgeSourceBase
{
    private final static String SIGNATURE = Segmentation.class.getSimpleName();

    @Override
    public int execCondition()
    {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public void execAction()
    {
        try
        {
            MyEntry entry = (MyEntry) getBlackboard().take(null, null, 3000);

            if (entry == null)
            {
                MyEntry e = new MyEntry();
                e.setValue(SIGNATURE);
                getBlackboard().write(e, null, 300000);
            } else
            {
                System.out.println("Current Value is: " + entry.getValue());
                entry.setValue(entry.getValue() + "->" + SIGNATURE);
                getBlackboard().write(entry, null, 300000);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Segmentation s = new Segmentation();
        s.execAction();
    }
}
