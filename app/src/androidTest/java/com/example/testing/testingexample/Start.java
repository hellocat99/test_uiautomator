package com.example.testing.testingexample;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.test.InstrumentationTestCase;
import android.view.KeyEvent;

public class Start extends InstrumentationTestCase {

    private String appPackage = "com.example.testing.testingexample";

    public void testA() {
        UiDevice uiDevice = UiDevice.getInstance(getInstrumentation());
        uiDevice.pressHome();

        // 获取上下文
        Context context = getInstrumentation().getContext();

        // 启动测试App
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackage);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        try {
            //点击"测试服"
            clickViewById(uiDevice, "tv_test");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testLogin() {
        UiDevice uiDevice = UiDevice.getInstance(getInstrumentation());
        uiDevice.pressHome();

        // 获取上下文
        Context context = getInstrumentation().getContext();

        // 启动测试App
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackage);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        try {
            //点击"测试服"
            clickViewById(uiDevice, "tv_test");
            Thread.sleep(1000);

            //点击"我的"
            uiDevice.findObject(new UiSelector().text("我的")).click();

            Thread.sleep(1000);
            UiObject uiObject = uiDevice.findObject(new UiSelector().text("登录/注册"));
            //如果没有登录，调起登录界面
            if (uiObject.exists()) {
                uiObject.click();
                inputAccountName(uiDevice);
                uiDevice.pressEnter();
                inputAccountPassword(uiDevice);
                Thread.sleep(1000);
                clickViewById(uiDevice, "tv_login");
            }

            Thread.sleep(1000);
            uiDevice.findObject(new UiSelector().text("推荐")).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clickViewById(UiDevice uiDevice, String id) throws Exception {
        String resourceId = appPackage + ":id/" + id;
        UiObject uiObject = uiDevice.findObject(new UiSelector().resourceId(resourceId));
        uiObject.click();
    }

    private int getKeyCode(char number) {
        switch (number) {
            case '0':
                return KeyEvent.KEYCODE_0;
            case '1':
                return KeyEvent.KEYCODE_1;
            case '2':
                return KeyEvent.KEYCODE_2;
            case '3':
                return KeyEvent.KEYCODE_3;
            case '4':
                return KeyEvent.KEYCODE_4;
            case '5':
                return KeyEvent.KEYCODE_5;
            case '6':
                return KeyEvent.KEYCODE_6;
            case '7':
                return KeyEvent.KEYCODE_7;
            case '8':
                return KeyEvent.KEYCODE_8;
            case '9':
                return KeyEvent.KEYCODE_9;
            default:
                return -1;
        }
    }

    private int[] getKeyCodeList(String nums) {
        int[] keyCodeList = new int[nums.length()];
        for (int i = 0; i < nums.length(); i++) {
            keyCodeList[i] = getKeyCode(nums.charAt(i));
        }
        return keyCodeList;
    }

    private void inputAccountPassword(UiDevice uiDevice) throws Exception {
        int[] myAccountPassword = getKeyCodeList("123456");
        for (int key : myAccountPassword) {
            Thread.sleep(500);
            uiDevice.pressKeyCode(key);
        }
    }

    private void inputAccountName(UiDevice uiDevice) throws Exception {
        String resourceId = appPackage + ":id/et_account";
        UiObject uiObject = uiDevice.findObject(new UiSelector().resourceId(resourceId));
        uiObject.click();
        int[] myAccountName = getKeyCodeList("13552458805");
        for (int key : myAccountName) {
            Thread.sleep(500);
            uiDevice.pressKeyCode(key);
        }
    }
}