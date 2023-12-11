public class Program {
    public static void main(String[] args) {
//        Person p = new Person("P01","Mai");
//
//        Person p1 = new Student("p02","ha", "class1");
//        p1.info();


        StaticMethod staticMethod = new StaticMethod();
        System.out.println("Diện tích hình tròng bán kính 20: "+StaticMethod.calCircleArea(20));
        System.out.println("Diện tích hình chữ nhật rông 10 dài 20: "+staticMethod.calRectangleArea(10,20));
        System.out.println("Diện tích hình tam giác có 3 canh 3,4,5 : "+staticMethod.calTriangleArea(3,4,5));
    }
}
