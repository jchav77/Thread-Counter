
public class CounterThreads {

    public static void main(String[] args) {
        // Thread 1 to count up to 20
        Thread countUpThread = new Thread(new CountUp());
        // Thread 2 to count down from 20 to 0
        Thread countDownThread = new Thread(new CountDown());

        // Start count-up thread
        countUpThread.start();

        try {
            // Wait for count-up thread to complete
            countUpThread.join();  
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        // Start count-down thread after first thread finishes
        countDownThread.start();
    }
}

// Thread class for counting up to 20
class CountUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Thread 1 counting up: " + i);
            try {
                Thread.sleep(500); // Pause to simulate processing time
            } catch (InterruptedException e) {
                System.err.println("CountUp interrupted: " + e.getMessage());
            }
        }
    }
}

// Thread class for counting down from 20 to 0
class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Thread 2 counting down: " + i);
            try {
                Thread.sleep(500); // Pause to simulate processing time
            } catch (InterruptedException e) {
                System.err.println("CountDown interrupted: " + e.getMessage());
            }
        }
    }
}
