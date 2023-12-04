import java.util.Scanner;

public class TinhDiemTrungBinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập điểm môn Toán:");
        double mathPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm môn Lý:");
        double phisycalPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm môn Hóa:");
        double chermisPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm môn Ván:");
        double vanPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm môn tiếng anh:");
        double anhPoint = Double.parseDouble(sc.nextLine());

        double dtb = (mathPoint + phisycalPoint+ chermisPoint + vanPoint+ anhPoint)/5;

        if(0<=dtb && dtb <5){
            System.out.println("Xếp loại yếu" );
        }else if(dtb>= 5 && dtb< 6.5){
            System.out.println("Xếp loại trung bình" );
        }else if(dtb>= 6.5 && dtb< 8 ){
            System.out.println("Xếp loại khá" );
        }else if(dtb>= 8 && dtb< 9 ){
            System.out.println("Xếp loại giỏi" );
        }else if(dtb>= 9 && dtb< 10 ){
            System.out.println("Xếp loại xuất sắc" );
        }

    }
}
