public class main {
    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();

        Thread evenThread = new Thread(printer::printEvenNumbers);
        Thread oddThread = new Thread(printer::printOddNumbers);

        evenThread.start();
        oddThread.start();
    }

}
