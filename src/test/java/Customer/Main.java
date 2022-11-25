package Customer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Log> log = new ArrayList<>();
        while (true) {
            System.out.println(" -----------사용자를 선택 해주세요.---------------- ");
            System.out.println("|       1.Customer          2.Bank           ㅣ");
            System.out.println(" ------------------------------------------- ");
            //ㅡㅡ
            Customer n = new Customer("KA","홍길동",232,2223,"입금");
            customerList.add(n);
            Customer b = new Customer("NH","김이박",323,1112,"입금");
            customerList.add(b);

            //ㅡㅡ
            int choseMenu = sc.nextInt();
            switch (choseMenu) {
                    case 1:
                        while (true) {
                            System.out.println(" -----------메모작성 프로그램---------------- ");
                            System.out.println("| 1.입금   2.출금  3.잔고확인  4.처음으로 돌아가기ㅣ");
                            System.out.println(" --------------------------------------- ");
                            System.out.print("👩🏻‍🎓메뉴 중 하나를 선택해주세요👩🏻‍🎓 : ");

                            int menu = sc.nextInt();
                            if (menu == 4) break;
                            switch (menu) {
                                case 1:
                                    System.out.println("❗️ 입금 ❗️");
                                    System.out.println(" -----------은행명을 선택 해주세요.---------------- ");
                                    System.out.println("|   1.KA      2.NH      3.KB      4.SH      | ");
                                    System.out.println(" -------------------------------------------- ");
                                    String DepositbankName = sc.next();
                                    System.out.println("❗️ 사용자 이름을 말씀해 해주세요.❗️");
                                    String DepositequalsName = sc.next();
                                    System.out.println("❗️ 입금 할 계좌를 선택해 해주세요.❗️");
                                    int DepositequalsAccount = sc.nextInt();
                                    boolean isTrue = false;
                                    for (int i = 0; i < customerList.size(); i++) {
                                        if (Objects.equals(customerList.get(i).bankName, DepositbankName)&&
                                                Objects.equals(customerList.get(i).customerName, DepositequalsName)&&
                                                Objects.equals(customerList.get(i).customerAccount, DepositequalsAccount)) {
                                            System.out.println("❗️ 입금 할 금액를 입력 해주세요.❗️");
                                            int customerDeposit = sc.nextInt();
                                            System.out.println(customerDeposit + "원 입급되었습니다");
                                            customerList.get(i).customerTotal += customerDeposit;
                                            customerList.get(i).check = "입금";
//                                            log.add(customerList.get(i));  ====오류
                                            System.out.println("로그"+log);
//                                            System.out.println("❗️현재 계좌 정보 ❗️");
//                                            System.out.println(customerList.get(i));

                                            System.out.println("현재 잔액은" + customerList.get(i).customerTotal + "입니다");
                                            isTrue = true;
                                            break;
                                        }
                                    } if (!isTrue) System.out.println("❗️ 입금 할 계좌가 존재하지 않습니다.❗️");
                                    break;
                                case 2:
                                    System.out.println("❗️ 출금 ❗️");
                                    System.out.println(" -----------은행명을 선택 해주세요.---------------- ");
                                    System.out.println("|   1.KA      2.NH      3.KB      4.SH      | ");
                                    System.out.println(" -------------------------------------------- ");
                                    String bankNamewithdraw = sc.next();
                                    System.out.println("❗️ 사용자 이름을 말씀해 해주세요.❗");
                                    String equalsNamewithdraw = sc.next();
                                    System.out.println("❗️ 출금 할 계좌를 선택해 해주세요.❗️");
                                    int equalsAccountwithdraw = sc.nextInt();
                                    boolean isTrue1 = false;
                                    for (int i = 0; i < customerList.size(); i++) {
                                        if (Objects.equals(customerList.get(i).bankName, bankNamewithdraw)&&
                                                Objects.equals(customerList.get(i).customerName, equalsNamewithdraw)&&
                                                Objects.equals(customerList.get(i).customerAccount, equalsAccountwithdraw)){
                                            System.out.println("❗️ 출금 할 금액를 입력 해주세요.❗️");
                                            int withdrawAccount = sc.nextInt();
                                            customerList.get(i).check = "출금";
                                            customerList.get(i).customerTotal -= withdrawAccount;

//                                            System.out.println("❗️현재 계좌 정보 ❗️");
//                                            System.out.println(customerList.get(i));
//                                            log.add(customerList.get(i));
                                            System.out.println("로그"+log);
                                            System.out.println();
                                            isTrue1 = true;

                                        }
                                    }
                                    if (!isTrue1) System.out.println("❗️ 출금 할 계좌가 존재하지 않습니다.❗️");
                                    break;
                                case 3:
                                    System.out.println("❗️ 조회 ❗️");
                                    System.out.println(" -----------은행명을 선택 해주세요.---------------- ");
                                    System.out.println("|   1.KA      2.NH      3.KB      4.SH      | ");
                                    System.out.println(" -------------------------------------------- ");
                                    String searchbankName = sc.next();
                                    System.out.println("❗️ 사용자 이름을 말씀해 해주세요.❗");
                                    String searchequalsName = sc.next();
                                    System.out.println("❗️ 출금 할 계좌를 선택해 해주세요.❗️");
                                    int searchequalsAccount = sc.nextInt();
                                    boolean isTrue2 = false;
                                    for (int i = 0; i < customerList.size(); i++) {
                                        if (Objects.equals(customerList.get(i).bankName, searchbankName)&&
                                                Objects.equals(customerList.get(i).customerName, searchequalsName)&&
                                                Objects.equals(customerList.get(i).customerAccount, searchequalsAccount)){
                                            System.out.println(log.get(i));
                                            System.out.println();
                                            isTrue2 = true;
                                        }
                                    }
                                    if (!isTrue2) System.out.println("❗️ 조회 할 계좌가 존재하지 않습니다.❗️");
                            }
                        }
                    case 2:  //ㅡㅡㅡㅡ은행붙여넣기
                        break;
                    }
                }
            }
    }

