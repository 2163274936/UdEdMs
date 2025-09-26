package top.villion.www;
// 导入ArrayList集合类，用于存储多个快递信息
import java.util.ArrayList;
import java.util.Scanner;
// 导入Scanner类，用于获取用户的输入
// 主类，程序的入口
public class main {
    public static void main(String[] args) {
        // 创建Scanner对象，用于读取用户在控制台的输入
        Scanner sc = new Scanner(System.in);
        //这句话创建了一个专门用来存储 PackageInfo 对象的动态数组（ArrayList）
        ArrayList<PackageInfo> packages = new ArrayList<>();

        System.out.println("欢迎使用寝室快递管理系统");
        System.out.printf("请输入姓名:");
        String name = sc.nextLine();
        System.out.printf("请输入学号:");
        String StudentId = sc.nextLine();
        System.out.println("登录成功!你好," + name + "同学");
// 无限循环，让用户可以反复操作菜单，直到选择退出
        while (true) {
            System.out.println("\n1. 添加快递 2. 查看快递 3. 取快递 4. 退出 ");
            System.out.print("请选择操作：");
            String choice = sc.nextLine();
// 根据用户的选择执行不同的操作
            switch (choice) {
                case "1":
                    System.out.print("请输入快递公司:");
                    String company = sc.nextLine();
                    System.out.print("请输入快递单号:");
                    String trackingNumber = sc.nextLine();
                    // 创建一个新的快递信息对象，并添加到packages集合中
                    packages.add(new PackageInfo(name, StudentId, company, trackingNumber));
                    System.out.println("快递添加成功!");
                    break;
                case "2":
                    System.out.println("所以快递列表:");
                    for (PackageInfo p : packages) {
                        System.out.println(p);
                    }
                    break;
                case "3":
                    System.out.print("请输入要取的快递单号:");
                    String tnToRemove = sc.nextLine();
                    boolean found = false;
                    // 增强for循环（for-each）：遍历packages集合中的每个PackageInfo对象
                    // 每次循环将一个对象赋值给变量p，然后输出p的信息
                    for (PackageInfo p : packages) {
                        // 检查当前快递的学号是否与登录用户一致，并且快递单号匹配
                        //equals() 是 Java 中用于比较两个对象内容是否相等的方法。
                        if (p.getStudentId().equals(StudentId) && p.getTrackingNumber().equals(tnToRemove)) {
                            p.PickUp();
                            System.out.println("快递取件成功!");
                            // 标记为已找到
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("未找到匹配的快递单号或该快递不属于您。");
                        break;
                    }
                case "4":
                    System.out.printf("感谢使用寝室快递管理系统，再见!");
                    return;
                default:
                    System.out.printf("无效选择，请重新输入。");

            }


        }

    }
}

