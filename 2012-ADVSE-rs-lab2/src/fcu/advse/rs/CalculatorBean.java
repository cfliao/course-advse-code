package fcu.advse.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/adder")
@Produces("application/xml")
public class CalculatorBean
{

    @GET
    @Path("/add/{i}/{j}")
    public Answer add(@PathParam("i") int i, @PathParam("j") int j)
    {
        Answer answer = new Answer();
        answer.setResult(i + j);
        return answer;
    }

}
