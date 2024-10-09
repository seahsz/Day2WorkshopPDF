import java.lang.IllegalArgumentException;

public class FixedDepositAccount extends BankAccount {

    // Additional members
    private float interest = 3;
    private int duration = 6;
    private final float bal;

    private boolean intChanged = false;
    private boolean durChanged = false;

    public FixedDepositAccount(String name, Float balance) {
        this(name, balance, 3f, 6);
    }

    public FixedDepositAccount(String name, Float balance, Float interest) {
        this(name, balance, interest, 6);
    }

    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration) {
        super(name, balance);
        if (this.duration != duration)
            durChanged = true;
        if (this.interest != interest)
            intChanged = true;
        this.duration = duration;
        this.interest = interest;
        this.bal = balance;         // so that it will become final
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        if (intChanged)
            throw new IllegalArgumentException("Interest can only be changed once");
        if (this.interest != interest)
            intChanged = true;
        this.interest = interest;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (durChanged)
            throw new IllegalArgumentException("Duration can only be changed once");
        if (this.duration != duration)
            durChanged = true;
        this.duration = duration;
    }

    public float getBal() {
        return this.bal + this.interest;
    }

    @Override
    public void deposit(float d) {
        return;
    }

    @Override
    public void withdraw(float w) {
        return;
    }

    
}
