package xierShop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Miketea implements Ishop {
    ArrayList<String> arrayList1 = new ArrayList<>();
    ArrayList<Integer> arrayList2 = new ArrayList<>();
    ArrayList<Integer> arrayList3 = new ArrayList<>();
    @Override
    public void by() {
        System.out.println("欢迎进货！\n请输入进货类型：");
        System.out.println("1.珍珠\t2.椰果");
        Scanner p=new Scanner(System.in);
        int peii=p.nextInt();
        String pei = null;
        if (peii==1){
            pei="珍珠";
        }else if (peii==2){
            pei="椰果";
        }else {
            System.out.println("错误！");
        }
        System.out.println("要进多少货？");
        int ci=p.nextInt();
        for (int i=0;i<ci;i++){
            if (pei.equals("珍珠")){
                arrayList1.add(pei);
                Bubble bubble=new Bubble(){};
                int mouth1=bubble.leixing1();
                int day1=bubble.leixing();
                arrayList2.add(day1);
                arrayList3.add(mouth1);

            }else if (pei.equals("椰果")){
                arrayList1.add(pei);
                Coconut coconut=new Coconut(){};
                int mouth2=coconut.leixing1();
                int day2=coconut.leixing();
                arrayList2.add(day2);
                arrayList3.add(mouth2);

            }else {
                System.out.println("进货失败！");
            }

        }System.out.println("进"+pei+"货"+ci+"份成功!");
        }


    @Override
    public void sold() throws SoldOutException {
    Miketea miketea=new Miketea(){};
    System.out.println("欢迎光临西二奶茶店！\n您想要什么奶茶：");
    System.out.println("1.珍珠\t2.椰果");
    Scanner m=new Scanner(System.in);
    int peiii=m.nextInt();
    String pe = null;
    if (peiii==1){
        pe="珍珠";
    }else if (peiii==2){
        pe="椰果";
    }else {
        System.out.println("错误！");
    }
    System.out.println("要几份呢？");
    int fen=m.nextInt();
    Calendar n=Calendar.getInstance();
    int d=n.get(Calendar.DAY_OF_MONTH);
    int mo=n.get(Calendar.MONTH)+1;
    int last=n.getActualMaximum(Calendar.DAY_OF_MONTH);
    for(int ii=0;ii<fen;ii++){
        if (arrayList1.size()==0){
            throw new SoldOutException("卖完了") ;

        }
        for (int i = 0; i<=arrayList1.size(); i++){
            if (arrayList1.get(i).equals(pe)){
                if (pe.equals("珍珠")){
                    Bubble bubble=new Bubble(){};


                    if ((arrayList2.get(i)<d+bubble.leixing2()&&arrayList3.get(i)==mo)||(arrayList3.get(i)==mo-1&&last-arrayList2.get(i)+d<bubble.leixing2())){
                        System.out.println(bubble.toString());
                        int x=1;
                        miketea.add(x);
                        arrayList1.remove(i);
                        arrayList2.remove(i);
                        arrayList3.remove(i);
                        System.out.println("印上了“"+bubble.leixing3()+"”");
                        System.out.println("请拿好您的珍珠奶茶，欢迎下次光临！");

                        break;
                    }else {
                        arrayList1.remove(i);
                        arrayList2.remove(i);
                        arrayList3.remove(i);
                        if (i==arrayList1.size()){
                            throw new SoldOutException(pe+"卖完了") ;
                        }
                        continue;
                    }
                }else if (pe.equals("椰果")){
                    Coconut coconut=new Coconut(){};
                    if (arrayList1.size()==0){
                        throw new SoldOutException("卖完了") ;

                    }
                    if ((arrayList2.get(i)<d+coconut.leixing2()&&arrayList3.get(i)==mo)||(arrayList3.get(i)==mo-1&&last-arrayList2.get(i)+d<coconut.leixing2())){
                        System.out.println(coconut.toString());
                        double y=2;
                        miketea.add(y);
                        arrayList1.remove(i);
                        arrayList2.remove(i);
                        arrayList3.remove(i);
                        System.out.println("印上了“"+coconut.leixing3()+"”");
                        System.out.println("请拿好您的椰果奶茶，欢迎下次光临！");
                        break;
                    }else {
                        arrayList1.remove(i);
                        arrayList2.remove(i);
                        arrayList3.remove(i);
                        if (i==arrayList1.size()){
                            throw new SoldOutException(pe+"卖完了") ;
                        }
                        continue;
                    }
                }


            }
        }
    }



    }

    @Override
    public void add(int x) {
        System.out.println("加入了珍珠配料！");
    }
    @Override
    public void add(double y) {
        System.out.println("加入了椰果配料！");
    }
    public static void run(){
        Miketea lll=new Miketea(){};
        Scanner s=new Scanner(System.in);
        int sis;
        int u;
        do {
            System.out.println("欢迎来到西二奶茶店！\n请问您是来送货还是来消费？\n1.送货\t2.消费");
            u=s.nextInt();
            if(u == 1){
                lll.by();
            }else if (u==2){
                try {
                    lll.sold();
                } catch (SoldOutException e) {
                    System.out.println("卖完了");
                }
            }else {
                System.out.println("错误！");
            }
            System.out.println("是否闭店休息？\n1.是\t2.否");
            sis=s.nextInt();
        }while (sis==2);
        System.out.println("营业结束，休息中。");



    }

}
