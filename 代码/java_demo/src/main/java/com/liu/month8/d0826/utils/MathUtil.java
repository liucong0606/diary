package com.liu.month8.d0826.utils;

import java.math.BigDecimal;

/**
 * @author liucong
 * @ClassName: MathUtil
 * @Description: 数学统计
 * @date: 2020/8/26 9:39
 */
public class MathUtil {
    private MathUtil() {
    }

    /**
     * @Description: 加法
     * @auther: liucong
     * @date: 2020/8/26 9:40
     * @return:
     */
    public static Double add(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(var1);
        BigDecimal b2 = new BigDecimal(var2);
        return b1.add(b2).doubleValue();
    }

    /**
     * @Description: 减法
     * @auther: liucong
     * @date: 2020/8/26 9:42
     * @return:
     */
    public static Double sub(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(var1);
        BigDecimal b2 = new BigDecimal(var2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * @Description: 乘法
     * @auther: liucong
     * @date: 2020/8/26 9:43
     * @return:
     */
    public static Double mul(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(var1);
        BigDecimal b2 = new BigDecimal(var2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * @Description: 除法
     * @auther: liucong
     * @date: 2020/8/26 9:44
     * @return:
     */
    public static Double div(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(var1);
        BigDecimal b2 = new BigDecimal(var2);
        return b1.divide(b2, 4, 4).doubleValue();
    }

    /**
     * 数组
     *
     * @param arr       数组
     * @param sum       总数
     * @param idx       索引
     * @param precision 精度
     * @return
     */
    public static double getPercentValue(int[] arr, double sum, int idx, int precision) {
        if ((arr.length - 1) < idx) {
            return 0;
        }
        //求和
        if (sum <= 0) {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
        }
        //10的2次幂是100，用于计算精度。
        double digits = Math.pow(10, precision);
        //扩大比例100
        double[] votesPerQuota = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double val = arr[i] / sum * digits * 100;
            votesPerQuota[i] = val;
        }
        //总数,扩大比例意味的总数要扩大
        double targetSeats = digits * 100;
        //再向下取值，组成数组
        double[] seats = new double[arr.length];
        for (int i = 0; i < votesPerQuota.length; i++) {
            seats[i] = Math.floor(votesPerQuota[i]);
        }
        //再新计算合计，用于判断与总数量是否相同,相同则占比会100%
        double currentSum = 0;
        for (int i = 0; i < seats.length; i++) {
            currentSum += seats[i];
        }
        //余数部分的数组:原先数组减去向下取值的数组,得到余数部分的数组
        double[] remainder = new double[arr.length];
        for (int i = 0; i < seats.length; i++) {
            remainder[i] = votesPerQuota[i] - seats[i];
        }
        while (currentSum < targetSeats) {
            double max = 0;
            int maxId = 0;
            int len = 0;
            for (int i = 0; i < remainder.length; ++i) {
                if (remainder[i] > max) {
                    max = remainder[i];
                    maxId = i;
                }
            }
            //对最大项余额加1
            ++seats[maxId];
            //已经增加最大余数加1,则下次判断就可以不需要再判断这个余额数。
            remainder[maxId] = 0;
            //总的也要加1,为了判断是否总数是否相同,跳出循环。
            ++currentSum;
        }
        // 这时候的seats就会总数占比会100%
        return seats[idx] / digits;
    }

    /**
     * @Description: 求百分比
     * @auther: liucong
     * @date: 2020/8/26 10:06
     * @return:
     */
    public static String getPercent(int[] arr, double total, int index, int precision) {
        if (index > arr.length - 1 || index < 0) {
            return "索引越界";
        }
        // 10的 n 次幂，用于计算精度
        double pow = Math.pow(10, precision);

        double[] brr = new double[arr.length];

        // 扩大 100 倍
        for (int i = 0; i < arr.length; i++) {
            Double n = div(arr[i], total) * pow * 100;  // 0.123
            brr[i] = n;
        }

        // 总数扩大 100 倍，用于计算比例是否 100%
        total = mul(total, 100);

        // 向下取整
        double[] crr = new double[arr.length];
        for (int i = 0; i < brr.length; i++) {
            crr[i] = Math.floor(brr[i]);
        }

        // 得到余数部分
        double[] drr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            drr[0] = sub(brr[i], crr[i]);
        }

        // 计算比例是否 100%
        double sum = 0;
        for (double v : crr) {
            sum = add(sum, v);
        }

        while (sum < total) {
            double max = 0;
            int maxIndex = 0;
            for (int i = 0; i < drr.length; i++) {
                if (drr[0] > max) {
                    max = drr[0];
                    maxIndex = i;
                }
            }

            crr[maxIndex]++;
            drr[maxIndex] = 0;
            sum++;
        }

        return crr[index] / pow + "%";
    }
}
