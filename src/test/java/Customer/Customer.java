package Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    String bankName;
    String customerName;
    int customerAccount;
    int customerTotal = 0;
    String check;
    LocalDateTime time;
    public LocalDateTime getTime() {
        return time;
    } // 시간기록

    public String getCustomerName() {
        return customerName; //소유주명
    }
    public int getCustomerAccount() {
        return customerAccount; // 계좌번호
    }
    public int getCustomerTotal() {
        return customerTotal; // 잔고
    }
    public String getBankName() {return bankName; }
    public String getcheck() {return check;}

    public Customer(String customerName, int customerAccount, int customerTotal, String check) {
        this.customerName = customerName;
        this.customerAccount = customerAccount;
        this.customerTotal = customerTotal;
        this.check = check;
        this.time = LocalDateTime.now();
    }
    public Customer(String bankName,String customerName,LocalDateTime time) {
        this.customerName = customerName;
        this.bankName = bankName;
        this.time = time;
    }


    public String toString() {

        return "{" +"은행명"+ bankName + "성 명 : " + customerName + ", 계좌번호 : " + customerAccount + ", 잔 고 :" + customerTotal +", "+ check +" 시간 :"+time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초"))+ '}';
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Customer> nameArr = new ArrayList<>();
        LocalDateTime t = LocalDateTime.now();
        System.out.println(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH시mm분ss초")));
        ArrayList<Customer> log = new ArrayList<>();

        roop : while (true) {
            System.out.println(" -----------사용자를 선택 해주세요.---------------- ");
            System.out.println("|       1.Customer          2.Bank           ㅣ");
            System.out.println(" ------------------------------------------- ");
            int chose = sc.nextInt();
            while (true) {
                switch (chose) {
                    case 1:
                        System.out.println(" -----------은행명을 선택 해주세요.---------------- ");
                        System.out.println("|   1.Ka      2.Nh      3.Kb      4.Sh     |  ");
                        System.out.println(" ------------------------------------------- ");
                        int s = sc.nextInt();
                        String bankName = s == 1 ? "Ka" : s == 2 ? "Nh" : s == 3 ? "Kb" : s == 4 ? "Sh" : "올바른 숫자를 입력 해주세요";
                        System.out.println(" -----------사용자 이름을 말씀해 해주세요.---------------- ");
                        String customerName = sc.next();
                        Customer sumname = new Customer(bankName, customerName,t);
                        nameArr.add(sumname);
                        System.out.println(nameArr);
                                    while (true) {
                                        System.out.println(" -----------메모작성 프로그램---------------- ");
                                        System.out.println("| 1.입금   2.출금  3.잔고확인  4.처음으로 돌아가기ㅣ");
                                        System.out.println(" --------------------------------------- ");
                                        System.out.print("👩🏻‍🎓메뉴 중 하나를 선택해주세요👩🏻‍🎓 : ");

                                        int menu = sc.nextInt();
                                        if (menu == 4) break roop;
                                        //ㅡㅡ
                                        Customer n = new Customer("홍길동", 232, 222923, "입금");
                                        customer.add(n);
                                        // ㅡㅡ


                                        switch (menu) {
                                            case 1:
                                                break;

                                            case 2:
                                                System.out.println("❗️ 출금 ❗️");
                                                System.out.println("❗️ 출금 할 계좌를 선택해 해주세요.❗️");
                                                int accountNumber = sc.nextInt();
                                                for (int i = 0; i < customer.size(); i++) {
                                                    if (accountNumber == customer.get(i).customerAccount){
                                                        System.out.println("❗️ 출금 할 금액를 입력 해주세요.❗️");
                                                        int withdrawAccount = sc.nextInt();
                                                        customer.get(i).customerTotal -= withdrawAccount;
                                                        System.out.println("❗️현재 계좌 정보 ❗️");
                                                        System.out.println(customer.get(i));
                                                        nameArr.add(customer.get(i));
                                                        System.out.println();
                                                    }
                                                    else {
                                                        System.out.println("❗️ 출금 할 계좌가 존재하지 않습니다.❗️");
                                                    }
                                                }
    //
                                            break;

                                            case 3:
                                                break;
                                        }
                                        break;
                                    }

                    case 2:  //ㅡㅡㅡㅡ은행
                        break;
                        }
                }
            }
        }

    }
