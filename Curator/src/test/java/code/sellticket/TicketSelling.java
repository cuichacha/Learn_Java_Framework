package code.sellticket;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

public class TicketSelling implements Runnable {
    private Integer tickets = 10;
    private InterProcessMutex lock;

    @Override
    public void run() {
        while (true) {

            try {
                lock.acquire(3, TimeUnit.SECONDS);
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + tickets);
                    Thread.sleep(100);
                    tickets--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
