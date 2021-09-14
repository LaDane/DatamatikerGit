package turnstile;

public class Turnstile implements Runnable{
    private final TurnstileCounter sharedCounter;

    final int COUNT_MAX = 1000;

    Turnstile(TurnstileCounter c) {
        this.sharedCounter = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_MAX; i++) {
            this.sharedCounter.incr();
        }
    }

}

