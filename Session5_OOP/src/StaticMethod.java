public class StaticMethod {
//    Trong bài này, chúng ta sẽ xây dựng 1 class tên là StaticMethod có 1 thuộc tính static là PI với giá trị = 3.14, các phương thức static như:
//    calCircleArea(double R) để tính diện tích hình tròn.
//
//    calRectangleArea(double width,double height) để tính diện tích hình chữ nhật.
//
//    calTriangleArea(double a, double b, double c) để tính diện tích của tam giác
    static final double PI = 3.14;

    public static double calCircleArea(double R){
        return PI*R*R;
    }

    public double calRectangleArea(double width,double height){
        return width*height;
    }

    public double calTriangleArea(double a, double b, double c){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
