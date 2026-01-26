public class Account {
    public String CustomerName;
    public double Balance;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public double getBalance() {
        return Balance;
    }

    private void setBalance(double balance) {
        Balance = balance;
    }

    public Account(String customerName) {

        if (customerName == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }

        CustomerName = customerName;
        Balance = 0;
    }

    public void Credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        Balance += amount;
    }

    public void Debit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if (Balance - amount >= 0) {
            Balance += amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }


    }
}