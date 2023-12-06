

public class NhapTyPhu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] getMaxTyPhu = getMax();
        System.out.print("\nTỷ phú giàu nhất có tài sản: " + getMaxTyPhu[0]);
        System.out.print("\nVị trí trang mảng: " + getMaxTyPhu[1] +1);

        System.out.print("\nNhập chiều ma trận vuông: ");
        int size = Integer.parseInt(sc.nextLine());
        double sumMatrixLine = tinhDuongCheoChinhMaTranVuong(size);
        System.out.print("\nTổng đường chéo chính ma trận vuông là: " + sumMatrixLine);
    }

    //    Ứng dụng cho phép người dùng lần lượt nhập vào giá trị tài sản của các tỷ phú thế
//    giới (đơn vị tỉ đô), tối đa cho phép nhập 20 giá trị, sau đó hiển thị giá trị tài sản lớn
//    nhất và vị trí của nó trong danh sách.
    static int[] getMax() {
        Scanner sc = new Scanner(System.in);
        int[] listTaiSan = new int[20];
        int max = 0;
        int idMax = 0;
        for (int i = 0; i < 20; i++) {
            System.out.print("Nhập giá trị tài sản thứ " + (i + 1) + ":");
            listTaiSan[i] = Integer.parseInt(sc.nextLine());
            if (listTaiSan[i] > max) {
                max = listTaiSan[i];
                idMax = i;
            }
        }
        return new int[]{max, idMax};
    }


    //    Viết một ứng dụng cho phép người dùng nhập vào một ma trận vuông của các số
//    thực, sau đó tính ra cho người dùng tổng của các số ở đường chéo chính.
//    Ma trận vuông là một ma trận có chiều cao và chiều rộng bằng nhau.
//    Đường chéo chính là tập hợp các phần tử được định vị bằng tọa độ [i][i].
    static double tinhDuongCheoChinhMaTranVuong(int size) {
        Scanner sc = new Scanner(System.in);
        double[][] matrix = new double[size][size];
        double result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("\nNhập phần tử[" + i + "][" + j + "]:");
                matrix[i][j] = Double.parseDouble(sc.nextLine());
                if(i == j){
                    result += matrix[i][j];
                }
            }
        }
        return result;
    }
}
