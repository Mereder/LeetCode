/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class theDateDiff {
    public static class Mydate{
        public int year;
        public int mon;
        public int day;

        public Mydate(int year, int mon, int day) {
            this.year = year;
            this.mon = mon;
            this.day = day;
        }
    }
    public static  final int daysOfMon[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int beforeMon_com[] = new int[13];
    public static int beforeMon_leap[] = new int[13];

    public static int total(Mydate mydate){
        int total  = beforeYear(mydate) + beforeMon(mydate) + mydate.day;
        return total;
    }
    // 这一年之前一共多少天
    public static int beforeYear(Mydate date){
        int year = date.year;
        // 被四整除的年份  减去 被100 整除的 （其中也减去了 被400 整除的  再加回来）
        int total = (year-1)*365 + (year-1) / 4 - (year-1) / 100 + (year-1) / 400;
        return  total;
    }
    public static int beforeMon(Mydate mydate){
        if (isLeapYear(mydate)){
            return beforeMon_leap[mydate.mon];
        }
        else return beforeMon_com[mydate.mon];
    }
    public static boolean isLeapYear(Mydate mydate){
        int year = mydate.year;
        if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) return true;
        else return false;
    }
    public static void main(String[] args) {
        // 总体思路： 以2019年4月24日为例
        // 2019年之前总共有多少天：(2019-1)*365+闰年个数
        // 4月前 总共有多少天：平年4月前多少天 or 闰年四月前多少天
        // 前两项+24日 = 总共天数。
        // 输入转换
        String date1 = "2019-04-24";
        String date2 = "2019-04-22";
        int n = 0;
        // 初始化 月前总天数数组  含义:2月1日前总共多少天......12月1日前总共多少天
        for (int i = 1; i < 13; i++) {
            beforeMon_com[i] = n;
            if (i > 2){
                beforeMon_leap[i] = n +1;
            }
            else beforeMon_leap[i] = n;

            n += daysOfMon[i];
        }
        int year1 = Integer.parseInt(date1.split("-")[0]);
        int mon1 = Integer.parseInt(date1.split("-")[1]);
        int day1 = Integer.parseInt(date1.split("-")[2]);
        Mydate first = new Mydate(year1,mon1,day1);
        int year2 = Integer.parseInt(date2.split("-")[0]);
        int mon2 = Integer.parseInt(date2.split("-")[1]);
        int day2 = Integer.parseInt(date2.split("-")[2]);
        Mydate second = new Mydate(year2,mon2,day2);

        System.out.printf("相差 %d 天",(total(first)-total(second)));
    }
}
