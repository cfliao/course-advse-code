package fcu.advse.layer;

import java.util.Scanner;

public class PresentationLayer
{
    private LogicLayer logiclayer = new LogicLayer();

    public void execute()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID:");
        String inputId = scanner.nextLine();

        System.out.print("Password:");
        String inputPassword = scanner.nextLine();

        boolean isLegal = logiclayer.auth(inputId, inputPassword);

        if (isLegal)
        {
            System.out.println("Logic success!");
        } else
        {
            System.out.println("Login failed!");
        }

    }

    public static void main(String[] args)
    {
        new PresentationLayer().execute();
    }
}
