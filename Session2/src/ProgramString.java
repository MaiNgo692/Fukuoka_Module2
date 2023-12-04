import java.util.Scanner;
import java.util.regex.Pattern;

public class ProgramString {
    public static void main(String[] args) {
//        String str = " Ngo Thi Mai ";
//        System.out.println("lenght(): " + str.length());
//        System.out.println("charAt(): " + str.charAt(0));
//        System.out.println("concat(): " + str.concat("xin chào"));
//        System.out.println("strim(): " + str.trim());
        enterInf();
    }
    //    Viết chương trình java, Nhập thông tin người dùng từ bàn phím gồm: Tên, SĐT, Email.
//    Yêu cầu SĐT đúng định dạng SĐT Việt Nam, Email đúng định dạng email.
//    Nếu nhập sai yêu cầu nhập lại. Hiển thị lại thông tin vừa nhập
    static void enterInf(){

        Scanner sc = new Scanner(System.in);
        String name,email,phone;
        Pattern validPhone = Pattern.compile("0[98763]\\d{8}");
        Pattern validEmail = Pattern.compile("^(.+)@(.+)$");

        System.out.println("Nhập tên người dùng:");
        name = sc.nextLine();
        do{
            System.out.println("Nhập số điện thoại:");
            phone = sc.nextLine();
        }while (!phone.matches("0[98763]\\d{8}"));
        do{
            System.out.println("Nhập địa chỉ email:");
            email = sc.nextLine();
        }while (!email.matches("^(.+)@(.+)$"));
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);
    }
}
