package xierShop;

import java.util.Calendar;

public class Coconut extends lngredient {
    Calendar a=Calendar.getInstance();
    @Override
    public int leixing() {



        day=a.get(Calendar.DAY_OF_MONTH);

        return day;
    }

    @Override
    public int leixing1() {
        mouth=a.get(Calendar.MONTH)+1;
        return mouth;
    }

    @Override
    public int leixing2() {
        bzq=5;
        return bzq;
    }

    @Override
    public String leixing3() {
        name="椰果奶茶";
        return name;
    }
    @Override
    public String toString(){
        Coconut coconut=new Coconut(){};
        String m="名称："+coconut.leixing3()+"\t保质期："+coconut.leixing2()+"\t生产日期："+coconut.leixing1()+"-"+coconut.leixing();
        return m;
    }
}
