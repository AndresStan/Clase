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



    public Account(String customerName, double balance) {

        if (customerName == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }

        CustomerName = customerName;
        Balance = 0;
    }
}