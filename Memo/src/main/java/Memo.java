import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;


class Memo {

    public int Num;
    public  String Name;
    public  int Password;
    public  String Content;
    public  LocalDateTime Time;

    public LocalDateTime getTime() {
        return Time;
    }

    public Memo(int Num, String Name, int Password, String Content) {
        this.Num = Num;
        this.Name = Name;
        this.Password = Password;
        this.Content = Content;
        this.Time = LocalDateTime.now();
    }
    public int getNum() {
        return Num;
    }
    public void  setNum(int num) {
        Num = num;
    }
    public  String getName(){
        return Name;
    }
    public void  setName(String name) {
        Name = name;
    }
    public int getPassword() {
        return Password;
    }
    public void setPassword(int password) {
        Password = password;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "메모{" + "번호 : " + Num + ", 이름 : " + Name + ", 내용 :" + Content + '}';
    }
}
class MemoInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Memo> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int count = 0;

        while (true) {
            System.out.println(" --------------------------------메모작성 프로그램--------------------------------- ");
            System.out.println("|    1. 입력    2. 메모보기    3. 메모검색    4. 메모삭제    5. 메모수정    6. 종료    |");
            System.out.println(" ------------------------------------------------------------------------------ ");

            System.out.print("👩🏻‍🎓메뉴 중 하나를 선택해주세요👩🏻‍🎓 : ");
            int menu = sc.nextInt();

            if (menu == 6) break;

            switch (menu) {
                case 1:
                     count += 1;
                     int Num = count;
                    System.out.print(" - 이름을 입력하세요 : ");
                    String Name = sc.next();
                    System.out.print(" - 비밀번호를 입력하세요 : ");
                    int Password = sc.nextInt();
                    System.out.print(" - 내용을 입력하세요 : ");
                    String Content = sc.next();

                    Memo info = new Memo(Num, Name, Password, Content);
                    list.add(info);
                    info.getTime();
                    System.out.println("메모가 추가되었습니다");
                    break;

                case 2:
                    System.out.println("❗️ 메모 조회 ❗️");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getTime());
                        System.out.println(list.get(i));
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print(" - 검색할 메모의 번호를 입력하세요 : ");
                    int findNum = Integer.parseInt(sc.next());
                    boolean isFind = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getNum()==findNum){
                            System.out.println("검색한 메모입니다.");
                            System.out.println(list.get(i));
                            isFind = true;
                            System.out.println();
                        }
                    }
                    if (!isFind) System.out.println("일치하는 메모가 없습니다");
                    break;
                case 4:
                    System.out.print(" - 삭제할 메모 번호를 입력하세요 : ");
                    int deleteNum = Integer.parseInt(sc.next());
                    boolean isDeleteNum = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getNum()== deleteNum) {
                            System.out.println(list.get(i));
                            System.out.println("비밀번호를 입력해주세요");
                            isDeleteNum = true;
                            int delete = Integer.parseInt(sc.next());
                            boolean isDelete = false;
                            if (list.get(i).getPassword()==delete) {
                                list.remove(i);
                                System.out.println("메모를 삭제했습니다");
                                isDelete = true;
                            } else {
                                System.out.println("잘못된 비밀번호 입니다.");
                                break;
                            }
                        }
                    }
                    if (!isDeleteNum) System.out.println("해당 메모는 존재하지 않습니다");
                    break;


                case 5:
                    System.out.print(" - 수정할 메모의 번호를 입력하세요 : ");
                    int editNum = Integer.parseInt(sc.next());
                    boolean isEditNum = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getNum()==editNum) {
                            System.out.println(list.get(i));
                            System.out.println("비밀번호를 입력해주세요");
                            isEditNum = true;
                            int edit = Integer.parseInt(sc.next());
                            boolean isEdit = false;

                            if (list.get(i).getPassword() == edit) {
                                System.out.println("메모를 수정하겠습니다");


                                System.out.print(" - 수정할 메모 내용을 입력하세요 : ");
                                String Content2 = sc.next();
                                list.get(i).setContent(Content2);

                                System.out.println("메모 수정이 완료되었습니다");
                                isEdit = true;

                                System.out.println("❗️수정된 메모 확인❗️");
                                System.out.println(list.get(i));
                                System.out.println();
                            } else {
                                System.out.println("잘못된 비밀번호 입니다.");
                                break;
                            }
                        }
                    }
                    if (!isEditNum) System.out.println("등록된 메모가 없습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        }
        System.out.println("프로그램을 종료합니다");
    }
}