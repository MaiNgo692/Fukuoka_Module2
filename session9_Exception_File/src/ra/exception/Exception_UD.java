package ra.exception;

import java.util.Scanner;

public class Exception_UD {
    public static void main(String[] args) {
        /*
        *
        *
        *
         */

        Scanner scanner = new Scanner(System.in);
        float mark;
        int age;
        System.out.println("Nhập vào điểm sinh viên:");
        do{
            try{
                mark = Float.parseFloat(scanner.nextLine());
                if(mark >=0 && mark <=10){
                    break;
                }else {
                    System.err.println("Điểm có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            }catch (NumberFormatException nf){
                System.err.println("Điểm có định dạng số thực, vui lòng nhập lại");
            }
        }while (true);

        System.out.println("Nhập vào tuổi của sinh viên:");
        do{
            try{
                age = Integer.parseInt(scanner.nextLine());
                if(age >=18){
                    break;
                }else {
                    System.err.println("Tuổi có giá trị lớn hơn hoặc bằng 18, vui lòng nhập lại");
                }
            }catch (NumberFormatException nf){
                System.err.println("Tuổi có định dạng số nguyên, vui lòng nhập lại");
            }
        }while (true);
    }
}
