package com.wangjiangfei.basic1;

import java.lang.reflect.Field;

/**
 * 交换数字
 * @author wangjiangfei
 *
 */
public class SwapNumberTest {
	
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		// a、b是实参-实际参数
		swap(a,b);
		System.out.println("a=" + a + ",b=" + b);
		
		//System.out.println("************");
		//test();
	}
	
	// first、second是形参-形式参数
	public static void swap(Integer first, Integer second) {
		int tmp = first.intValue();
		try {
			Field field = Integer.class.getDeclaredField("value");
			field.setAccessible(true);
			
			//System.out.println("IntegerCache中1对应位置的数值：" + Integer.valueOf(1));
			field.set(first, second);
			//System.out.println("IntegerCache中1对应位置的数值：" + Integer.valueOf(1));
			
			// 该方法不可行
			//field.set(second, tmp);
			// 该方法可行
			field.set(second, new Integer(tmp));
			System.out.println("second:" + second);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void test() {
		Integer testA = 1;
		Integer testB = 1;
		Integer testA_new = new Integer(1);
		Integer testB_new = new Integer(1);
		Integer testC = 128;
		Integer testD = 128;
		Integer testC_new = new Integer(128);
		Integer testD_new = new Integer(128);
		System.out.println("testA=testB:" + (testA == testB));
		System.out.println("testA_new=testB_new:" + (testA_new == testB_new));
		System.out.println("testC=testD:" + (testC == testD));
		System.out.println("testC_new=testD_new:" + (testC_new == testD_new));
	}

}
