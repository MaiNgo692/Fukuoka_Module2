public class Program {
    public static void main(String[] args) {
        // Khai báo mảng
        int[] numbers;
        String names[];

        // Khởi tạo giá trị
        numbers = new int[3];
        // Gán giá trị cho phần tử
        numbers[0] = 3;
        numbers[1] = 2;
        numbers[2] = 1;
        // Duyệt mảng
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "]: " + numbers[i]);
        }

        //Khai báo, khỏi tạo, gán giá trị
        String name[] = new String[]{"Mai", "Hoa", "Đào"};

        //for-each
        for (String item : name) {
            System.out.println(item);
        }

        //for-in
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4, 5};
        matrix[1] = new int[]{1, 2, 3};
        matrix[2] = new int[]{1, 2};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // Gọi hàm
        sayHello();
        System.out.println(sum(3,6));
    }
    // Định nghĩa phương thức, hàm
    static void sayHello(){
        System.out.println("Xin chào các bạn!");

    }

    static int sum(int a, int b){
        int c = a+b;
        return c;
    }
}
