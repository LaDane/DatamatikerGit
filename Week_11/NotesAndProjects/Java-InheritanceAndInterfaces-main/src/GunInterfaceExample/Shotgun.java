package GunInterfaceExample;

public class Shotgun implements Weapon
{
    final int maxShells = 8;
    final int buckshot = 5;
    private int currentAmmo = 0;


    @Override
    public void reload()
    {
        for (int i = 0; i < maxShells; i++)
        {
            System.out.println("Adding 1 shell to shotgun");
            currentAmmo += 1;
        }

        System.out.println("Finished reloading shotgun. Current shells in shotgun now: "+ currentAmmo);
    }

    @Override
    public void shoot()
    {
        for (int i = 0; i < buckshot; i++)
        {
            System.out.println("firing buckshot from shotgun");
        }
    }
}
