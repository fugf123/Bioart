package com.xiaowa.bioart.util;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator {

    //接口，必须实现的方法
    public int compare(Object o1, Object o2) {
        Map p1 = (Map) o1;
        Map p2 = (Map) o2;
        if ((Double) p1.get("distance") < (Double) p2.get("distance"))
            return -1;
        else if ((Double) p1.get("distance") > (Double) p2.get("distance"))
            return 1;
        else
            return 0;
    }
}
