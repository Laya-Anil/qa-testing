
import org.junit.Before;
import org.junit.Test;
import bankinfo.BankAccount;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100); 
    }
    
    /**
     * This test case checks that the initial balance of the account is 100.
     */
    @Test
    public void testInitialBalance() {
        assertEquals(100.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that depositing 50 into the account increases the balance to 150.
     */
    @Test
    public void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that depositing a negative amount into the account throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-50.0);  
    }
    
    /**
     * This test case checks that depositing 0 into the account throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDepositZeroAmount() {
        account.deposit(0.0);  
    }
    
    /**
     * This test case checks that withdrawing 50 from the account decreases the balance to 50.
     */
    @Test
    public void testWithdraw() {
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that withdrawing more than the available balance throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.withdraw(150.0);      
    }
    
    /**
     * This test case checks that withdrawing a negative amount throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-50.0);  
    }
    
    /**
     * This test case checks that withdrawing 0 throws an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawZeroAmount() {
        account.withdraw(0.0);  
    }
    
   
    /**
     * This test case checks that multiple transactions (deposits and withdrawals) are handled correctly.
     */

    @Test
    public void testMultipleTransactions() {
        account.deposit(100.0);   
        account.withdraw(50.0);   
        account.deposit(25.0);    
        assertEquals(175.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that multiple withdrawals are handled correctly.
     */
    @Test
    public void testMultipleWithdrawals() {
        account.withdraw(20.0);
        account.withdraw(30.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that multiple deposits are handled correctly.
     */
    @Test
    public void testMultipleDeposits() {
        account.deposit(20.0);
        account.deposit(30.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }
    
    /**
     * This test case checks that the account balance does not change when no transactions are made.
     */
    @Test
    public void testNoTransactions() {
        assertEquals(100.0, account.getBalance(), 0.001);
    }
}

