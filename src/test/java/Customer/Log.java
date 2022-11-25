package Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    String bankName;
    String customerName;
    int customerAccount;
    int customerTotal;
    String check;
    LocalDateTime time;

    public Log(String bankName, String customerName, int customerAccount, int customerTotal, String check,LocalDateTime time) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.customerAccount = customerAccount;
        this.customerTotal = customerTotal;
        this.check = check;
        this.time = LocalDateTime.now();
    }

    public Log() {

    }

    public String toString() {
        return "{" + "은행명" + bankName + "성 명 : " + customerName + ", 계좌번호 : " + customerAccount +", 잔 고 :" + customerTotal + ", " + check + "시간 :" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초")) + '}';
    }
}
