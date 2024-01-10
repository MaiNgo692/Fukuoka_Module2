package com.ra;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println( (d.getTime() / 1000 / 60 / 60) % 24 + ":" + (d.getTime() / 1000 / 60) % 60 + ":" + (d.getTime() / 1000) % 60 );
    }
}
