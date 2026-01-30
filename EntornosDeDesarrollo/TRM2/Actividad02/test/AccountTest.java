import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    }

}