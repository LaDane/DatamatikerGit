import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TurnstyleManager implements Runnable{

    private int expectedTurnstyles;
    private BlockingQueue<Spectators> spectators = new ArrayBlockingQueue<>(1);
    private BlockingQueue<ClientHandler> connectedClients;

    public TurnstyleManager(int expectedTurstyles) {
        this.expectedTurnstyles = expectedTurstyles;
        spectators.add(new Spectators());
        connectedClients = new ArrayBlockingQueue<>(expectedTurstyles);
    }

    @Override
    public void run() {
        while(true) {
            if (connectedClients.size() < expectedTurnstyles)
                continue;

        }
    }

    private Spectators getSpectatorsElement() {
        Spectators sp = null;
        try {sp = spectators.take();}
        catch (InterruptedException e) {e.printStackTrace();}
        return sp;
    }

    private void returnSpectatorsElement(Spectators sp) {
        try {spectators.put(sp);}
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public int addSpectator(int amount) {
        Spectators sp = getSpectatorsElement();
        if (sp != null) {
            sp.increaseTotalSpectators(amount);
            returnSpectatorsElement(sp);
            return sp.getTotalSpectators();
        }
        return -1;
    }

    public int getNumberOfSpectators() {
        return spectators.element().getTotalSpectators();
    }

    public void addConnectedClient(ClientHandler clientHandler) {
        try {connectedClients.put(clientHandler);}
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public void removeConnectedClient(ClientHandler clientHandler) {
        connectedClients.remove(clientHandler);
    }

    public boolean reachedExpectedTurnstyles() {
        if (connectedClients.size() >= expectedTurnstyles) {
            return true;
        }
        return false;
    }
}

class Spectators {

    private int totalSpectators = 0;

    public int increaseTotalSpectators(int amount) {
        totalSpectators += amount;
        return totalSpectators;
    }

    public int getTotalSpectators() {
        return totalSpectators;
    }
}
