package top.villion.www;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //这句话创建了一个专门用来存储 PackageInfo 对象的动态数组（ArrayList）
        ArrayList<PackageInfo> packages = new ArrayList<>();

        System.out.println("欢迎使用寝室快递管理系统");
        System.out.printf("请输入姓名:");
        String name = sc.nextLine();
        System.out.printf("请输入学号:");
        String StudentId = sc.nextLine();
        System.out.println("登录成功!你好," + name + "同学");

        while (true) {
            System.out.println("\n1. 添加快递 2. 查看快递 3. 取快递 4. 退出 ");
            System.out.print("请选择操作：");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("请输入快递公司:");
                    String company = sc.nextLine();
                    System.out.print("请输入快递单号:");
                    String trackingNumber = sc.nextLine();
        }


         }

    }
}

