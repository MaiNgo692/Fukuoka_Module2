import java.util.Scanner;

public class BTVN {
    public static void main(String[] args) {
        /**
         * Viết chương trình java, nhập vào danh sách email của 10 bạn trong lớp.
         * Có kiểm tra định dạng email.
         * Hiển thị email của các bạn trong lớp theo thứ tự A-Z, định dạng bảng giống như sau:
         *  +----------------------+
         *  |   Danh sách email    |
         *  +----------------------+
         *  | trunghv@gmail.com    |
         *  | trunghv.lsd@gmail.com|
         *  | trung.abc@gmail.com  |
         *  | trunghv@gmail.com    |
         *  +----------------------+
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng học sinh trong lớp:");
        int studentQuantity = Integer.parseInt(sc.nextLine());
        String[] emailList =  enterStudentEmailList(sc,studentQuantity);
        printEmailList(emailList);
    }
    static String[] enterStudentEmailList(Scanner scanner, int size){
        String[] emailList = new String[size];
        String email = "";
        for (int i = 0; i< size;i++){
            do{
                System.out.print("\n Nhập địa chỉ email học sinh thứ "+ (i+1)+": ");
                email = scanner.nextLine();
            }while (!email.matches("^(.+)@(.+)$"));
            emailList[i] = email;
        }
        return emailList;
    }
    static void printEmailList(String[] emailList){
        int maxString =20;
        for (int i =0; i< emailList.length; i++){
            if(maxString < emailList[i].length()){
                maxString = emailList[i].length();
            }
        }
        System.out.print("+");
        for (int i =0; i< maxString; i++){
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();
        System.out.printf("|%s|", centerString (maxString, "Danh sách email"));
        System.out.println();
        System.out.print("+");
        for (int i =0; i< maxString; i++){
            System.out.print("-");
        }
        System.out.print("+");
        for (int i =0; i< emailList.length; i++){
            System.out.printf("\n|%s|", centerString (maxString, emailList[i])); //viết căn giữa bảng
//            System.out.printf("\n|%"+(-maxString)+"s|", emailList[i]);         //viết bên trái
        }
        System.out.println();
        System.out.print("+");
        for (int i =0; i< maxString; i++){
            System.out.print("-");
        }
        System.out.print("+");
    }
    public static String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}
