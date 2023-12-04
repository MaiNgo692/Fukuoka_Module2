import java.util.Scanner;

public class TinhDienTich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều hinh vuông:");
        int hight = Integer.parseInt(sc.nextLine());
        int dientich = hight*hight;
        int chuvi = hight*4;
        System.out.printf("\nDiện tích là: %s",dientich);
        System.out.printf("\nChu vi là: %s",chuvi);
    }
}
