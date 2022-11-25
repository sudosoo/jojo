package Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
        String bankName;
        String customerName;
        int customerAccount;
        int customerTotal;
        String check;
        LocalDateTime time ;

    public Customer() {

    }

    public int getCustomerAccount() {
            return customerAccount; // 계좌번호
        }
        public String getBankName() {
            return bankName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getCustomerTotal() {
            return this.customerTotal;
        }

        public String getCheck() {
            return check;
        }

        public LocalDateTime getTime() {
            return time;
        }

        public Customer(String bankName,String customerName, int customerAccount, int customerTotal, String check) {
            this.bankName = bankName;
            this.customerName = customerName;
            this.customerAccount = customerAccount;
            this.customerTotal = customerTotal;
            this.check = check;
            this.time = LocalDateTime.now();
        }

        public Customer(String customerName, int customerAccount) {
            this.customerName = customerName;
            this.customerAccount = customerAccount;

        }

        public String toString() {
            return "{" + "은행명" + bankName + "성 명 : " + customerName + ", 계좌번호 : " + customerAccount + ", 잔 고 :" + customerTotal + ", " + check + "시간 :" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초")) + '}';
        }
    }

