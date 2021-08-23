package GunInterfaceExample;

import java.util.Scanner;

public class WeaponHandler
{
    int inputNumber = 0;
    Weapon equippedWeapon = null;

    public WeaponHandler()
    {
        scanForInput();
    }

    private void scanForInput()
    {
        Scanner scanner = new Scanner(System.in);

        while (inputNumber != -1)
        {

            System.out.println("Input a number to change weapon, \"shoot\" for shooting, \"reload\" for reloading or -1 for termination");
            String input = scanner.next();
            inputNumber = 0;

            try
            {
                inputNumber = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                HandleNonNumericInput(input);
                continue;
            }

            if (inputNumber != 0)
            {
                changeWeapon(inputNumber);
            }
        }
    }

    private void HandleNonNumericInput(String input)
    {
        if (input.toLowerCase().equals("shoot"))
        {
            equippedWeapon.shoot();
        }
        else if (input.toLowerCase().equals("reload"))
        {
            equippedWeapon.reload();
        }
    }

    private void changeWeapon(int inputNumber)
    {
        switch(inputNumber)
        {
            case 1:
                equippedWeapon = new Handgun();
                break;
            case 2:
                equippedWeapon = new MachinePistol();
                break;
            case 3:
                equippedWeapon = new Shotgun();
                break;
            default:
                System.out.println("No available weapons at: "+inputNumber);
                break;
        }

        System.out.println("weapon equipped = "+equippedWeapon.toString());

//        Weapon equippedWeapon = new Handgun();
//        equippedWeapon.reload();
//        equippedWeapon.shoot();
//
//        System.out.println("Pressing 1, Machine pistol now equipped");
//        equippedWeapon = new MachinePistol();
//        equippedWeapon.reload();
//        equippedWeapon.shoot();
//
//        System.out.println("Pressing 4, Æ' pumpgun i æ' hænde' mæ æ' finge' å æ trægge'.");
//        equippedWeapon = new Shotgun();
//        equippedWeapon.reload();
//        equippedWeapon.shoot();
//
//        System.out.println("Please remember to mention that this is actually what is called " +
//                "\"Polymorphism\" (it is capable of taking multiple shapes).");

    }
}
