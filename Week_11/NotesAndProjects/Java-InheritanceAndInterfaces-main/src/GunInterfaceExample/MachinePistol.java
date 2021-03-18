package GunInterfaceExample;

public class MachinePistol implements Weapon
{
    @Override
    public void reload()
    {
        System.out.println("Reloading machinepistol. replacing clip with new one with 30 rounds in it. ");
    }

    @Override
    public void shoot()
    {
        System.out.println("ratatatatatatatatatatatatatatata");
    }
}
