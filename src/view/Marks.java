package view;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lenovo on 2/17/2015.
 */
public class Marks {
    private static int prevR;
    private static int prevG;
    private static int prevB;

    private static int curR;
    private static int curG;
    private static int curB;

    private static HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    private static void generateMark(){
        Random random = new Random();

        int willDarkColor = random.nextInt(3);

        if (willDarkColor == 0){
            curR = random.nextInt(60) + 10;
        } else {
            curR = random.nextInt(150) + 30;
        }
        if (willDarkColor == 1){
            curG = random.nextInt(60) + 10;
        } else {
            curG = random.nextInt(150) + 30;
        }
        if (willDarkColor == 2) {
            curB = random.nextInt(60) + 10;
        } else {
            curB = random.nextInt(150) + 30;
        }
    }

    private static int nextMark(){
        while (true){
            generateMark();
            if ( Math.abs(curB - prevB) < 40 ) continue;
            if ( Math.abs(curR - prevR) < 40 ) continue;
            if ( Math.abs(curG - prevG) < 40 ) continue;
            break;
        }
        prevB = curB;
        prevG = curG;
        prevR = curR;

        return ( curB + curG * 256 + curR * 256*256 );
    }

    public static int nextMark(int x){
        if ( !hashMap.containsKey(x) ) {
            hashMap.put(x, nextMark());
        }
        return hashMap.get(x);
    }
}
