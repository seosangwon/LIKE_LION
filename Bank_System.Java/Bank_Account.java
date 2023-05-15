import java.util.*;


public class Bank_Account{

    int account_num;
    String name;

    int payment;


    public Bank_Account(int account_num, String name, int payment){
        this.account_num = account_num;
        this.name=name;
        this.payment=payment;
    }

// Getter
    public int getAccount_num() {
        return account_num;
    }

    public String getName() {
        return name;
    }

    public int getPayment() {
        return payment;
    }

//Seter
public void setAccount_num(int account_num) {
    this.account_num = account_num;
}

    public void setName(String name) {
        this.name = name;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
