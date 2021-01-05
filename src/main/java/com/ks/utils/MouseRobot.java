package com.ks.utils;

import java.awt.*;

public class MouseRobot {


    public MouseRobot() throws AWTException {

    }

    public static void main(String[] args) throws AWTException, InterruptedException {


        Robot robot = new Robot();

        int i = 100;
        while (i >= 10) {
            Thread.sleep(60000);
            robot.mouseMove(i, 100);
            i -= 10;
            if (i == 10) {
                i = 100;
            }
        }
    }
}
