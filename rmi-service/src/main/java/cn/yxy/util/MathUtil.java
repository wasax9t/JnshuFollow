package cn.yxy.util;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/11.
 *
 */
public class MathUtil {
    public static String getRandomNumber(int dig){
        StringBuffer num=new StringBuffer();
        Random random = new Random();
        while(dig>0){
            int n=random.nextInt(9);
            num.append(n);
            dig--;
        }
        return num.toString();
    }

}
