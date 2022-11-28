package Customer;

import bank.*;
import java.util.*;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bank> log = new ArrayList<>();
        Random r = new Random();
        LocalDateTime t = LocalDateTime.now();
        ArrayList<Bank> list = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println(" ----사용자를 선택 해주세요.-----");
            System.out.println("❗  1.Bank  2.Customer  ❗");
            System.out.println(" --------------------------");
            int choseMenu = sc.nextInt();
            switch (choseMenu) {
                case 1:
                    a:
                    while (true) {
                        System.out.println();
                        System.out.println("----------------은행 선택하기--------------");
                        System.out.println("❗  1.NH농협  2.KAKAO  3.SOL  4.KB국민  ❗");
                        System.out.println("----------------------------------------");
                        System.out.print("👩🏻‍🎓은행 중 하나를 선택해주세요 :");
                        String bankName = "";
                        try {
                            int bankNum = sc.nextInt();
                            if (bankNum == 1) {
                                bankName = "NH농협";
                            } else if (bankNum == 2) {
                                bankName = "KAKAO";
                            } else if (bankNum == 3) {
                                bankName = "SOL";
                            } else if (bankNum == 4) {
                                bankName = "KB국민";
                            } else {
                                System.out.println("❗ 일치하는 은행번호가 없습니다 ❗");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("❗ ["+sc.nextLine()+"] 잘못된 입력 입니다. 해당 숫자를 입력해주세요 ❗");
                            break;
                        }
                      while (true) {
                            System.out.println();
                            System.out.println("----------------------------메뉴 선택하기------------------------------");
                            System.out.println("❗  1.계좌등록  2.계좌검색  3.전체 계좌조회  4.계좌삭제  5.계좌수정  6.뒤로가기  ❗");
                            System.out.println("-------------------------------------------------------------------");
                            System.out.print("👩🏻‍🎓메뉴 중 하나를 선택해 주세요 :");
                            try {
                                int chooseMenu = sc.nextInt();
                                if (chooseMenu == 6) {
                                    break a;
                                }
                                while (true) {
                                        if (chooseMenu == 1) {
                                        System.out.print("👩🏻‍🎓 이름을 입력하세요 :");
                                        String customerName = sc.next();
                                        System.out.print("👩🏻‍🎓 금액을 입력하세요 :");
                                        int customerBalance = 0;
                                        try {
                                            customerBalance = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("❗[" + sc.nextLine() + "] 잘못된 입력 입니다. 처음으로 돌아갑니다❗");
                                            break;
                                        }
                                        //초기 금액
                                        System.out.println("❗ 계좌를 개설합니다 ❗");
                                        //계좌번호 랜덤값 생성
                                        int accountNum;
                                        String ranNum;
                                        String customerAccount = "";
                                        for (int i = 0; i < 12; i++) {
                                            accountNum = r.nextInt(9);
                                            ranNum = Integer.toString(accountNum);
                                            customerAccount += ranNum;
                                        } //계좌번호 정규식 표현 빙밥
                                        System.out.println("👩🏻‍🎓 계좌번호는 " + customerAccount.substring(0, 4) + "-" + customerAccount.substring(4, 8) + "-" + customerAccount.substring(8, 12) + "입니다.");
                                        Bank info = new Bank(customerName, customerAccount, customerBalance, bankName, "계좌생성", t);
                                        list.add(info);
                                        System.out.println("❗ 계좌가 등록되었습니다 ❗");
                                        break;
                                    }else if (chooseMenu == 2) { //계좌번호랑 소유주를 둘다 입력해야만 검색가능 (동명이인 해결)
                                        System.out.print("👩🏻‍🎓 검색할 계좌 번호를 입력하세요 (-는 제외) :");
                                        String findCustomerAccount = sc.next();
                                        System.out.print("👩🏻‍🎓 검색할 계좌 소유주를 입력하세요 :");
                                        String findCustomerName = sc.next();
                                        boolean isFind = false;
                                        for (Bank bank : list) {
                                            if (Objects.equals(bank.getCustomerAccount(), findCustomerAccount)
                                                    && Objects.equals(bank.getCustomerName(), findCustomerName)) {
                                                System.out.println("❗ 검색한 계좌입니다 ❗");
                                                System.out.println(bank);
                                                isFind = true;
                                                break;
                                            }
                                        }
                                        if (!isFind) {
                                            System.out.println("❗ 일치하는 계좌번호가 없습니다 ❗");
                                            System.out.println();
                                        }
                                        break;
                                    } else if (chooseMenu == 3) {
                                        System.out.println("❗️ 전체 계좌 조회 ❗️");
                                        for (int i = 0; i < list.size(); i++) {
                                            System.out.println(list.get(i));
                                        }
                                        System.out.println();
                                        break;
                                    } else if (chooseMenu == 4) {
                                        System.out.print("👩🏻‍🎓삭제할 계좌 번호를 입력하세요 :");
                                        String deleteCustomerAccount = sc.next();
                                        boolean isDeleteNum = false;
                                        for (int i = 0; i < list.size(); i++) {
                                            if (list.get(i).getCustomerAccount().equals(deleteCustomerAccount)) {
                                                System.out.println(list.get(i));
                                                isDeleteNum = true;
                                                list.remove(i);
                                                System.out.println("❗ 계좌를 삭제했습니다 ❗");
                                                break;
                                            }
                                        }
                                        if (!isDeleteNum) {
                                            System.out.println();
                                            System.out.println("❗ 해당 계좌는 존재하지 않습니다 ❗");
                                        }
                                        break;
                                    } else if (chooseMenu == 5) { //계좌 정보 내 이름, 비밀번호 수정
                                        System.out.print("👩🏻‍🎓수정할 계좌의 계좌번호를 입력하세요 (-는 제외) :");
                                        String editCustomerAccount = sc.next();
                                        for (int i = 0; i < list.size(); i++) {
                                            if (list.get(i).getCustomerAccount().equals(editCustomerAccount)) {
                                                System.out.println(list.get(i));
                                                System.out.println();
                                                System.out.println("❗ 계좌 정보를 수정하겠습니다 ❗");
                                                System.out.print("👩🏻‍🎓수정할 이름을 입력하세요 :");
                                                String CustomerName2 = sc.next();
                                                list.get(i).setCustomerName(CustomerName2);
                                                System.out.println("❗ 정보 수정이 완료되었습니다 ❗");
                                                System.out.println("❗️ 수정된 계좌 정보 확인 ❗️");
                                                System.out.println(list.get(i));
                                            }
                                        }
                                        break;
                                    } else {
                                        System.out.println();
                                        System.out.println("❗ 해당하는 메뉴번호가 없습니다 ❗");
                                        break;
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println();
                                System.out.println("❗[" + sc.nextLine() + "] 잘못된 입력 입니다. 해당 숫자를 입력해주세요 ❗");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("❗️ 사용자 이름을 말씀해 해주세요 ❗️");
                    String equalsName = sc.next();
                    System.out.println("❗️ 계좌번호를 입력 해주세요 ❗️");
                    String equalsAccount = sc.next();
                    boolean isTT1 = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (Objects.equals(list.get(i).customerName, equalsName) &&
                                Objects.equals(list.get(i).customerAccount, equalsAccount)) {
                            isTT1 = true;
                            while (true) {
                                System.out.println();
                                System.out.println(" --------------계좌관리 프로그램-------------- ");
                                System.out.println("❗ 1.입금  2.출금  3.잔고확인  4.처음으로 돌아가기 ❗");
                                System.out.println(" ----------------------------------------- ");
                                System.out.print("👩🏻‍🎓메뉴 중 하나를 선택해주세요 :");
                                try {
                                    int menu = sc.nextInt();
                                    if (menu == 4) break;
                                    switch (menu) {
                                        case 1:
                                            System.out.println();
                                            System.out.println("❗️ 입금 ❗️");
                                            System.out.println("❗️ 입금 할 금액를 입력 해주세요 ❗️");
                                            int customerDeposit = sc.nextInt();
                                            System.out.println("❗ " + customerDeposit + "원 입급되었습니다 ❗");
                                            list.get(i).customerBalance += customerDeposit;
                                            Bank logList = new Bank(list.get(i).customerName, list.get(i).customerAccount, list.get(i).customerBalance, list.get(i).bankName, "입금", t);
                                            log.add(logList);
                                            System.out.println("❗ 현재 잔액은 " + list.get(i).customerBalance + "입니다 ❗");
                                            break;
                                        case 2:
                                            System.out.println();
                                            System.out.println("❗️ 출금 ❗️");
                                            System.out.println("❗ ️출금 할 금액를 입력 해주세요 ❗️");
                                            int withdrawAccount = sc.nextInt();
                                            System.out.println("❗ " + withdrawAccount + "원 출금되었습니다 ❗");
                                            list.get(i).customerBalance -= withdrawAccount;
                                            Bank logListWithdraw = new Bank(list.get(i).customerName, list.get(i).customerAccount, list.get(i).customerBalance, list.get(i).bankName, "출금", t);
                                            log.add(logListWithdraw);
                                            System.out.println("❗ 현재 잔액은" + list.get(i).customerBalance + "입니다 ❗");
                                            break;
                                        case 3:
                                            System.out.println();
                                            System.out.println("❗️ 거래내역 ❗️");
                                            for (int j = 0; j < log.size(); j++)
                                                System.out.println(log.get(j));
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("❗ [" + sc.nextLine() + "] 잘못된 입력 입니다. 해당 숫자를 입력해주세요 ❗");
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("❗️ 조회 할 계좌 / 사용자 존재하지 않습니다 ❗️");
                            break;

                        }
//                        if (!isTT) {
//                            System.out.println("❗️ 조회 할 계좌 / 사용자 존재하지 않습니다 ❗");
//                            System.out.println();
//                            break;
//                        }
                    }
            }
        }
    }
}
