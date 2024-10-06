package md.hajji.practicalactivity1.exceptions;

public class NegativeBalanceException extends RuntimeException{

    public NegativeBalanceException(Double balance){
        super("Negative balance: " + balance);
    }
}
