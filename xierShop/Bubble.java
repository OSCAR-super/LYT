package xierShop;

import java.util.Calendar;

public abstract class Bubble extends lngredient {
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
        bzq=7;
        return bzq;
    }

    @Override
    public String leixing3() {
        name="珍珠奶茶";
        return name;
    }
    @Override
    public  String toString(){
        Bubble bubble=new Bubble(){};
        String m="名称："+bubble.leixing3()+"\t保质期："+bubble.leixing2()+"\t生产日期："+bubble.leixing1()+"-"+bubble.leixing();
        return m;
    }
}
