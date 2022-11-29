package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bank {
    public LocalDateTime time;
    public String customerName;
    public String customerAccount;
    public int customerBalance;
    public String bankName;
    public String check;


    public Bank(String customerName, String customerTotal, int customerBalance, String bankName,String check,LocalDateTime time) {
        this.customerName = customerName;
        this.customerAccount = customerTotal;
        this.customerBalance = customerBalance;
        this.bankName = bankName;
        this.check= check;
        this.time = LocalDateTime.now();
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAccount() {
        return customerAccount;
    }


    @Override
    public String toString() {
        return "계좌 - { 은행명: " + bankName+ ", 이름: " + customerName
                + ", 계좌번호: " + customerAccount.substring(0, 4) + "-" + customerAccount.substring(4, 8) + "-" + customerAccount.substring(8, 12)
                + ", 계좌잔고: " + customerBalance +" "+ check +"시간: "+time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초"))+" }";
    }
}


