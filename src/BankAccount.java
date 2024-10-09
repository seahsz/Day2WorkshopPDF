import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.lang.IllegalArgumentException;

public class BankAccount {
    
    // Members
    private final String name;
    private final String accNum;
    private float bal;
    private List<String> transaction = new ArrayList<>();
    private boolean isClosed;
    private LocalDate createDate;
    private LocalDate closeDate;

    // Constructor chaining - overloading
    public BankAccount(String name) {
        this(name, 0);
    }

    public BankAccount(String name, float bal) {
        this.name = name;
        Random rand = new Random();
        this.accNum = Integer.toString(rand.nextInt(89999999) + 10000000);
        this.bal = bal;
        this.createDate = LocalDate.now();
    }

    // Getters and Setters

    public String getName() { return name; }

    public String getAccNum() { return accNum; }

    public float getBal() { return bal; }
    public void setBal(float bal) { this.bal = bal; }

    public List<String> getTransaction() { return transaction; }
    public void setTransaction(List<String> transaction) { this.transaction = transaction; }

    public boolean isClosed() { return isClosed; }
    public void setClosed(boolean isClosed) { this.isClosed = isClosed; }

    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }

    public LocalDate getCloseDate() { return closeDate; }
    public void setCloseDate(LocalDate closeDate) { this.closeDate = closeDate; }

    // Deposit method
    public void deposit(float d) {
        // the exceptions automatically breaks the current method
        if (d <= 0)
            throw new IllegalArgumentException("Unable to deposit: incorrect amount");
        if (this.isClosed)
            throw new IllegalArgumentException("Unable to deposit: account closed");
        this.bal += d;
        transaction.add("deposit $%.3f at %s".formatted(d, LocalDateTime.now()));
    }

    // Withdraw method
    public void withdraw(float w) {
        if (w <= 0)
            throw new IllegalArgumentException("Unable to withdraw: incorrect amount");
        if (this.isClosed)
            throw new IllegalArgumentException("Unable to withdraw: account closed");
        if (w > this.bal) {
            throw new IllegalArgumentException("Unable to withdraw: insufficient balance");
        }
        this.bal -= w;
        transaction.add("withdraw $%.3f at %s".formatted(w, LocalDateTime.now()));
    }

    

    


}
