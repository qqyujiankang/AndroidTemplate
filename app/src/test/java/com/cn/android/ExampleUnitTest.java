package com.cn.android;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);

    }

    private static String str = "616d5c07-dc3f-43e2-a9c4-4e1ca4ab45a3";

    public static void main(String[] args) {
//        //  String string=str.substring(str.length()-12,str.length());
//
//        int i = 0;
//        i++;
//        System.out.println(i);
//        i++;
//        System.out.println(i);
        String val = "AAA,BBB,CCC";
        String[] splitVal = val.split("\\,");//转数组
        List<String> asList = Arrays.asList(splitVal);//转集合
        System.out.println(asList.get( 0 ));

    }
}