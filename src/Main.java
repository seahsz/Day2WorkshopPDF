public class Main {
    
    public static void main(String[] args) {
        
        BankAccount myAccount = new BankAccount("SZ");

        myAccount.deposit(10);
        myAccount.deposit(100);


        FixedDepositAccount myFixedAccount = new FixedDepositAccount("John", 500f);

        myFixedAccount.setInterest(10);

        System.out.println(myFixedAccount.getBal());
    }
}
