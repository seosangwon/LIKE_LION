import java.util.*;

public class BankSystem {


    Scanner sc = new Scanner(System.in);
    Map<Integer, Bank_Account> accounts = new HashMap<>();



    public  void menu(){

        int num=0;
        do {
            System.out.println("=======Bank Menu=====");
            System.out.println("1. 계좌개설");
            System.out.println("2. 입금하기");
            System.out.println("3. 출금하기");
            System.out.println("4. 전체조회");
            System.out.println("5. 프로그램 종료");
            System.out.println("==================");
            System.out.print("입력 : ");
            num = sc.nextInt();

            switch (num) {
                case 1: {
                    System.out.print("계좌 번호 : ");
                    int account_num = sc.nextInt();
                    sc.nextLine(); // 버퍼에 있는 개행 없애주기
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    System.out.print("예금 : ");
                    int payment = sc.nextInt();
                    sc.nextLine(); // 버퍼에 있는 개행 없애주기

                    Bank_Account ac = new Bank_Account(account_num, name, payment);
                    accounts.put(account_num, ac); // hash에다가 넣어주기
                    System.out.println("계좌가 개설되었습니다");
                    break;

                }
                case 2: {
                    int deposit=0;
                    int result_money=0;

                    System.out.println("=====입금하기======");
                    System.out.print("입금하실 계좌번호를 입력해주세요 : ");
                    int acc_num = sc.nextInt();
                    if (accounts.containsKey(acc_num)) {
                        Bank_Account ac = accounts.get(acc_num); // 계좌번호로 hash에서 data 꺼내오기

                        System.out.printf("계좌이름 :  %s", ac.getName());
                        System.out.println('\n');
                        System.out.printf("계좌이름 :  %s", ac.getPayment());
                        System.out.println('\n');
                        System.out.print("입급할 금액을 입력해주세요 : ");
                        deposit = sc.nextInt();
                        sc.nextLine();

                        // 입금할 금액을 입력받아 , getter로 원금을 불러와서 더해주고 다시 setter
                        deposit += ac.getPayment();

                        ac.setPayment(deposit);

                        System.out.printf("계좌잔고 : %d", deposit);
                        System.out.println('\n');
                    }
                    else{
                        System.out.println("입력하신 계좌는 없습니다");
                    }

                    break;


                }
                case 3: {

                    int acc_money=0; // 계좌에 있는 금액
                    int money=0; // 출금 금액

                    System.out.println("=====출금하기====");

                    System.out.print("출금하실 계좌번호를 입력해주세요 : ");
                    int acc_num = sc.nextInt();
                    if (accounts.containsKey(acc_num)) {
                        Bank_Account ac = accounts.get(acc_num); // 계좌번호로 hash에서 data 꺼내오기

                        System.out.printf("계좌이름 :  %s", ac.getName());
                        System.out.println('\n');
                        System.out.printf("계좌이름 :  %s", ac.getPayment());
                        System.out.println('\n');
                        System.out.print("출금할 금액을 입력해주세요 : ");
                        money = sc.nextInt();
                        acc_money = ac.getPayment();

                        if (money > acc_money) {
                            System.out.println("출금 하시려는 금액은 현재 잔고 보다 초과 금액입니다");
                            System.out.println();
                        } else {
                            acc_money -= money;
                            System.out.printf("출금 후 남은 금액은 :%d 입니다 ", acc_money);
                            ac.setPayment(acc_money);
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("입력하신 계좌는 없는 계좌 입니다");
                    }

                }
                case 4: {
                    System.out.println("=====전체조회=====");
                    for (Bank_Account ac : accounts.values()) {
                        System.out.printf("계좌 번호: %d\n", ac.getAccount_num());
                        System.out.printf("이름: %s\n", ac.getName());
                        System.out.printf("잔고: %d\n", ac.getPayment());
                        System.out.println("------------------");
                    }
                    break;

                }

                case 5: {
                    System.out.println("프로그램 종료");
                    break;
                }


            }
        }while(num !=5);
    }





}
