package com.atguigu.exam;

class Exam{
	public static void main(String[] args){
		/*
		第1题：
		int m=0,n=3;
		if(m>0)
			if(n>2)
				System.out.println("A");
			
			System.out.println("C");		
			
			else
				System.out.println("B");
		*/

		/*
		3.一个数如果恰好等于它的因子之和，这个数就称为"完数".例如6=1＋2＋3.
		编程 找出1000以内的所有完数。（因子：除去这个数本身的其它约数）
		*/
		int sum = 0;//累加因子
		for(int i = 1;i <= 1000;i++){
			
			for(int j = 1;j <= i/2 ;j++){
				if(i % j == 0){
					sum += j;
				}
			}
			
			if(i == sum){
				System.out.println(i);
			}
			//重置
			sum = 0;

		}
		
		/*				i	j
		******			1	6
		*****			2	5
		****			3	4
		***				4	3
		**				5	2
		*				6	1

		
		*/

		for(int i = 1;i <= 6;i++){
			
			for(int j = 1;j <= 7 - i;j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}