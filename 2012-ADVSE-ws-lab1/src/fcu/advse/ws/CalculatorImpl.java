package fcu.advse.ws;

import javax.jws.WebService;
 
@WebService
public class CalculatorImpl implements Calculator
{
    @Override
    public int add(int i, int j)
    {
        return i + j;
    }

}
