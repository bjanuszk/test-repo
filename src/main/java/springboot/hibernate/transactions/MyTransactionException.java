package springboot.hibernate.transactions;

public class MyTransactionException extends RuntimeException {
    public MyTransactionException(final String s) {
        super(s);
    }
}
