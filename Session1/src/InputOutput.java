import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        String name ="Mai", email="m@gmail.com";
        System.out.println("In xong xuong dong");
        System.out.println("In xong xuong dong");
        System.out.print("In khong xuong dong");
        System.out.print("In khong xuong dong");

        // %[x]s : chuỗi
        // %[x.y]d  : byte, short, int, long
        // %[x]f   : float, double
        // %b   : boolean
        // [x]  : x số khoảng trống in ra giá trị
        // [x,y]: x số khoảng trống in ra giá trị, y là số chữ số sau dấy phảy động
        double money = 345.13456;
        System.out.printf("Mony: %.2f", money);
        System.out.printf("\nTên tôi là: " + name + " | Email: " + email);
        System.out.printf("\nTên tôi là: %-20s | Email : %-20s", name,email);

        // tạo đối tượng nhập
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập họ tên:");
        name = sc.nextLine();
        System.out.print("\nNhập tuổi:");
        int age = sc.nextInt(28);

    }
}
