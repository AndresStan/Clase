import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.AbstractCollection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    @DisplayName("Deberia crer la cuenta con las propiedades correctas")
    void testConstructor() {
        String custName = "Andres";
        Double balance = 0.0;

        Account account = new Account(custName);

        Assertions.assertAll("Account creation",
                () -> Assertions.assertEquals(custName, account.getCustomerName()),
                () -> Assertions.assertEquals(balance, account.getBalance())
        );

    }


    @Test
    @DisplayName("Deberia lanzar una excepción")
    void testnokConstructor() {

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new Account(null);
        });

        Assertions.assertTrue(exception.getMessage().contains("El nombre no puede ser nulo"));

    }

    @Test
    void testCredit() {
        Account account = new Account("Hector");
        account.Credit(1.00);

        Assertions.assertEquals(1.00, account.Balance);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.Credit(-1.00);
        });

        Assertions.assertTrue(exception.getMessage().contains("La cantidad debe ser mayor que cero"));
    }

    @Test
    void testDebit() {
        String custName = "Joe Brown";
        double credit = 10.00;
        double debit = 10.00;
        Account account = new Account(custName);
        account.Credit(credit);
        account.Debit(debit);
        Assertions.assertEquals(credit-debit, account.Balance);
    }

    @Test
    public void Test_Debit_Negative()
    {
        String custName = "Joe Brown";
        double debit = -100.00;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.Debit(debit);
        });
        String expectedMessage = "La cantidad debe ser mayor que cero";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void Test_Credit_Negative()
    {
        String custName = "Joe Brown";
        double credit = -100;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.Credit(credit);
        });
        String expectedMessage = "La cantidad debe ser mayor que cero";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void Test_Debit_InsufficientBalance()
    {
        String custName = "Joe Brown";
        double credit = 10.00;
        double debit = 50.00;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> { account.Credit(credit);
            account.Debit(debit);
        });
        String expectedMessage = "Saldo insuficiente";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
        void testTiempoEjecucionCreacionCuenta() {
        ArrayList<Account> cuentas = new ArrayList<>();
        assertTimeout(Duration.ofMillis(100), () -> {
            for (int i = 0; i <= 100 ; i++) {
                cuentas.add(new Account(String.valueOf(i)));
            };
        });
    }

    @Test
    void testTiempoEjecucionCreditoYDebito() {
        ArrayList<Account> cuentas = new ArrayList<>();
        assertTimeout(Duration.ofMillis(100), () -> {
            for (int i = 0; i <= 100000 ; i++) {
                Account cuenta = new Account("A");
                cuenta.Credit(i+1);
                cuenta.Debit(i+1);
            };
        });
    }





}