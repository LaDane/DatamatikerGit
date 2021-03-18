package GunInterfaceExample;

public class Handgun implements Weapon
{
    @Override
    public void reload()
    {
        System.out.println("Reloading a handgun - emptying clip, putting new clip in.");
    }

    @Override
    public void shoot()
    {
        System.out.println("Shooting a handgun - one bullet at a time - e.g. on button down");
    }
}
