package com.ra.practive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGift {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int select;
        List<GiftConfig> giftConfigs = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        List<GiftHistory> giftHistories = new ArrayList<>();
        do{
            System.out.println("Nhập tính năng:");
            System.out.println("1. Nhập mã người chơi để nhận quà:");
            System.out.println("2. Nhập mã người chơi để xem danh sách quà đã nhận:");
            System.out.println("3. Thoát");
            select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Bạn đã thoát chương trình!");
                    break;
                default:
                    System.out.println("Hãy chọn từ 1 đến 3!");
            }
        }while (select !=3);
    }
}
