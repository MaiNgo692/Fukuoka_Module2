package com.ra;

import com.ra.model.Computer;
import com.ra.service.ComputerService;

import java.util.Scanner;

public class GamingNet {
    /*
    * Viết chương trình quản lý phòng net
    * có các tính năng
    * 1. Mở máy(Không chọn máy có người đang sử dụng)
    * 2. Tắt máy, tính tiền theo giờ
    * 3. Hiển thị danh sách máy trong tiệm, có kèm trạng thái On/Off
    * */
    public static void main(String[] args) {
        ComputerService service = new ComputerService();
        Computer c1 = new Computer("cp01","nomal",20000,false);
        Computer c2 = new Computer("cp02","nomal",20000,false);
        Computer c3 = new Computer("cp03","nomal",20000,false);
        Computer c4 = new Computer("cp04","nomal",20000,false);
        service.add(c1);
        service.add(c2);
        service.add(c3);
        service.add(c4);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************** MENU ********************");
            System.out.println("1. Mỏ Máy");
            System.out.println("2. Tắt máy, tính tiền");
            System.out.println("3. Hiển thị danh sách máy trong tiệm có kèm trạng thái ON/Off");
            System.out.println("Chọn chức năng:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.print("Nhập Id máy muốn mở: ");
                    String id = scanner.nextLine();
                    service.turnOn(id);
                    break;
                case 2:
                    System.out.print("Nhập Id máy muốn tắt: ");
                    String idToOff = scanner.nextLine();
                    service.turnOffPay(idToOff);
                    break;
                case 3:
                    System.out.println("Danh sách máy trong tiệm:");
                    service.displayAll();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn từng 1 đến 4");
                    break;
            }
        }while (true);
    }


}
