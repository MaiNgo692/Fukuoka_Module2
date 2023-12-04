import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number;
        do {
            System.out.print("Nhập vào số:");
            number = sc.nextLine();
        }while (number.length() <= 3);

        String[] readNumber = {"","một","hai","ba","bốn","năm","sáu","bảy","tám","chín"};
        String result = "";
        if(number.length()==1){
            result += readNumber[Integer.parseInt(number)];
        }else if (number.length() ==2){
            result += readNumber[Integer.parseInt(String.valueOf(number.charAt(0)))] + " mươi " + readNumber[Integer.parseInt(String.valueOf(number.charAt(1)))];
        }else if(number.length() == 3){
            String hangChuc;
            String hangTram = readNumber[Integer.parseInt(String.valueOf(number.charAt(0)))] + " trăm ";
            if(readNumber[Integer.parseInt(String.valueOf(number.charAt(1)))] ==""){
                hangChuc =  " linh ";
            }else {
                hangChuc =  readNumber[Integer.parseInt(String.valueOf(number.charAt(1)))] + " mươi ";
            }
            String hangDonvi = readNumber[Integer.parseInt(String.valueOf(number.charAt(2)))];
            result = hangTram + hangChuc + hangDonvi ;
        }
        System.out.println("\n Số đã nhập là: " + result);
    }
}
