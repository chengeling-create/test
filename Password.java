import javax.swing.*;
import java.security.SecureRandom;
import java.util.*;

public class Password extends JFrame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        exit();

        while (isRunning) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1://加密
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");

                        System.out.print("请输入要加密的数字密码：");
                        String input = scanner.nextLine();
                        char[] c = input.toCharArray();
                        char temp;
                        ArrayList m = new ArrayList();
                        int num = 0;
                        for (int i = 0; i < c.length; i++) {
                            if (c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z' || c[i] >= '0' && c[i] <= '9') {
                                num++;
                            }
                        }
                        if (num == c.length &&c.length<=16) {
                            //每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
                            for (int j = 0; j < c.length; j++) {
                                temp = (char) (c[j] + (j + 1) + 3);
                                m.add(temp);
                            }

                            //将字符串的第一位和最后一位调换顺序
                            Collections.swap(m, 0, m.toArray().length - 1);
                            //将字符串反转
                            Collections.reverse(m);
                            System.out.print("加密后的结果是： ");
                            for (int z = 0; z < m.size(); z++) {
                                System.out.print(m.get(z));
                            }
                        }

                    else if (num != c.length){
                        System.out.println("密码错误：密码输入有非法字符");
                    }
                    else if (c.length>16||c.length<1){
                        System.out.println("密码错误：密码长度大于16或小于1");
                    }
                        System.out.println("");

                    break;


                case 2://解密
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("请输入要解密的密码：");
                    String input1 = scanner.nextLine();
                    char[] d = input1.toCharArray();
                    char temp1;
                    int _num = 0;
                    for (int i = 0; i < d.length; i++) {
                        if (d[i] >= 'a' && d[i] <= 'z' || d[i] >= 'A' && d[i] <= 'Z' || d[i] >= '0' && d[i] <= '9') {
                            _num++;
                        }
                    }
                    if (_num == d.length &&d.length<=16) {
                        //将字符串反转
                        for (int i = 0; i < d.length / 2; i++) {
                            temp1 = d[i];
                            d[i] = d[d.length - 1 - i];
                            d[d.length - 1 - i] = temp1;
                        }
                        char temp2;
                        //将字符串的第一位和最后一位调换顺序
                        temp2 = d[0];
                        d[0] = d[d.length - 1];
                        d[d.length - 1] = temp2;
                        ArrayList n = new ArrayList();
                        //将每个字符的ASCII码减去它在字符串中的位置(1开始)和偏移值3
                        for (int i = 0; i < d.length; i++) {
                            temp1 = (char) (d[i] - (i + 1) - 3);
                            n.add(temp1);
                        }
                        for (int i = 0; i < n.size(); i++) {
                            System.out.print(n.get(i));
                        }
                    }
                    else if (_num != d.length){
                        System.out.println("密码错误：密码输入有非法字符");
                    }
                    else if (d.length>16||d.length<1){
                        System.out.println("密码错误：密码长度大于16或小于1");
                    }
                    System.out.println("");
                    break;

                case 3://判断密码强度
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("请输入要判断强度的密码：");
                    String pass = scanner.next();
                    //使用正则表达式判断密码强度
                    String regexA = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{1,7}$";
                    String regexB = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
                    String regexC = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
                    String regexD = "^[0-9]{8,}$";
                    String regexE = "^[a-z]{8,}$";
                    String regexF = "^[A-Z]{8,}$";
                    if (pass.matches(regexA) || pass.matches(regexD)|| pass.matches(regexE)|| pass.matches(regexF)) {
                        System.out.println("密码强度为弱强度");
                    }
                    else if (pass.matches(regexB)) {
                        if (pass.matches(regexC)) {
                            System.out.println("密码强度为强强度");
                        } else
                            System.out.println("密码强度为中强度");
                    }
                    else
                        System.out.println("密码输入错误！");

                    System.out.println("");
                    break;

                case 4://密码生成
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("密码生成长度（大于等于8）：");
                    int num1 = scanner.nextInt();
                    String passwords = PasswordGenerator.generatePassword(num1);
                    System.out.println("生成的密码: " + passwords);

                case 5://退出
                    System.exit(0);
            }

            scanner = new Scanner(System.in);
            System.out.println("按任意键返回");
            String input = scanner.nextLine();
            if (input.length() > 0) {
                System.exit(0);
            }
            exit();
        }
    }

    public static void exit() {
        System.out.println("==============================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("==============================");
        System.out.println("请选择操作：");
        System.out.println("1. 加密");
        System.out.println("2. 解密");
        System.out.println("3. 判断密码强度");
        System.out.println("4. 密码生成");
        System.out.println("5. 退出");
        System.out.println(" ");
        System.out.print("请输入选项序号：");
    }
}

class PasswordGenerator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    public  static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        // 添加至少一个小写字母、一个大写字母和一个数字
        password.append(getRandomChar(LOWER_CASE));
        password.append(getRandomChar(UPPER_CASE));
        password.append(getRandomChar(DIGITS));

        // 添加随机字符，直到达到所需的长度
        while (password.length() < length) {
            String charSet = getRandomCharSet();
            password.append(getRandomChar(charSet));
        }

        // 打乱密码中的字符顺序
        shuffle(password);

        return password.toString();
    }

    private  static char getRandomChar(String charSet) {
        Random random = new Random();
        int index = random.nextInt(charSet.length());
        return charSet.charAt(index);
    }

    private  static String getRandomCharSet() {
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        switch (randomIndex) {
            case 0:
                return LOWER_CASE;
            case 1:
                return UPPER_CASE;
            case 2:
                return DIGITS;
            default:
                return "";
        }
    }

    private static void shuffle(StringBuilder password) {
        Random random = new Random();
        for (int i = password.length() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = password.charAt(index);
            password.setCharAt(index, password.charAt(i));
            password.setCharAt(i, temp);
        }
    }
}