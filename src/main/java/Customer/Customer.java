package Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
        String bankName;
        String customerName;
        int customerAccount;
        int customerBalance;
        String check;
        LocalDateTime time ;

    public Customer() {

    }



        public Customer(String bankName,String customerName, int customerAccount, int customerBalance, String check) {
            this.bankName = bankName;
            this.customerName = customerName;
            this.customerAccount = customerAccount;
            this.customerBalance = customerBalance;
            this.check = check;
            this.time = LocalDateTime.now();
        }

        public String toString() {
            return "{" + "은행명" + bankName + "성 명 : " + customerName + ", 계좌번호 : " + customerAccount + ", 잔 고 :" + customerBalance + ", " + check + "시간 :" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초")) + '}';
        }

    }

