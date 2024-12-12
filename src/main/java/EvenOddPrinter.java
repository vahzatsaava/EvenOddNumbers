public class EvenOddPrinter {
    private boolean evenTurn = true;


    public void printEvenNumbers(){
        for (int i = 0; i <= 1000 ; i += 2) {
            synchronized (this){
                while (!evenTurn){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even: " + i);
                evenTurn = false;
                this.notifyAll();
            }

        }
    }

    public void printOddNumbers() {
        for (int i = 1; i <= 1000; i += 2) {
            synchronized (this) {
                while (evenTurn) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd: " + i);
                evenTurn = true;
                this.notifyAll();
            }
        }
    }
}
