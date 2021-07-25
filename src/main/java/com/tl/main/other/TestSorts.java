package com.tl.main.other;


public class TestSorts {
//	private static  int []list= {0,3,1,4,2,5};//下标零用作哨兵
//	private static  int []list= {0,50,10,90,30,70,40,80,60,20,54,4,56,446,565,909,78,89,100};//下标零用作哨兵
//private static  int []list= {0,50,10,90,30,70,40,80,60,20,54,4,56,446,565,909,78,12};//下标零用作哨兵
//49 ， 81 ， 55 ， 36 ， 44 ， 88
private static  int []list={0,49 , 81 , 55 , 36 , 44 , 88};


	private static int []listswitch=new int[list.length];
	public static void swap(int i,int j) {
		int temp=list[i];
		list[i]=list[j];
		list[j]=temp;
	}
	public static void display() {
		for(int sort:list) {
			System.out.print(sort+"\t");
		}
	}
	public static void display2() {
		for(int sort:listswitch) {
			System.out.print(sort+"\t");
		}
	}
	public static void  bubblesorts() {//最简单的冒泡排序初级
		int i,j;
		for( i=1;i<list.length-1;i++) {
			for(j=i+1;j<list.length;j++) {
				if(list[i]>list[j]) {
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
	}
	public static void bubblesorts1() {//效率剧中的冒泡排序
		int i,j;
		for(i=1;i<list.length-1;i++) {
			for(j=list.length-2;j>=i;j--) {
				if(list[j]>list[j+1]) {
					System.out.println("list["+(j+1)+"]="+list[j+1]+"与"+"list["+j+"]="+list[j]+"交换了");
					swap(j, j+1);
					System.out.println("交换之后---"+"list["+(j+1)+"]="+list[j+1]+"\t"+"list["+j+"]="+list[j]);
				}
			}
		}
	} 
	public static void bubblesorts2() {//优化冒泡查询
		int i,j;
		boolean flag=true;
		for(i=1;i<list.length-1&&flag;i++) {
			flag=false;
			for(j=list.length-2;j>=i;j--) {
				if(list[j+1]<list[j]) {
					swap(j, j+1);
					flag=true;
				}
			}
		}
	}
	public static void selectsorts() {//简单选择排序
		int i,j,min;
		for(i=1;i<list.length-1;i++) {
			min=i;
			for(j=i+1;j<list.length;j++) {
				if(list[min]>list[j]) {
					min=j;//暂存记录最小的那一条下标
				}
			}
			if(min!=i) {
				swap(i, min);
			}
		}
	}
	public static void insertsorts() {//简单插入排序
		int i,j;
		for( i=2;i<list.length;i++) {//从第二位开始  默认第一条记录是正确的排序  向第一条左右插入
			if(list[i-1]>list[i]) {
				list[0]=list[i];//暂存要插入的list【i】
				for(j=i-1;list[j]>list[0];j--) {
					list[j+1]=list[j];
				}
				list[j+1]=list[0];//插入
			}
		}
	}

	public static void sheelsorts() {//希尔排序   相较于简单插入排序  多了一个增量 increment 比较的时候是跳跃性的  所以较不稳定
		int i,j,increment;
		increment=list.length-1;
		do {
			increment=increment/3+1;//不唯一  
			for(i=increment+1;i<=list.length-1;i++) {
				if(list[i]<list[i-increment]) {//i-increment=1  第i条记录小于第一条记录  将第一条记录插入相应位置
					list[0]=list[i];
					for(j=i-increment;j>0&&list[j]>list[0];j-=increment) {
						list[j+increment]=list[j];
					}
					list[j+increment]=list[0];
				}
			}
		} while (increment>1);
	}
	public static void heapsort() {//堆排序  主函数
		int i;
		for(i=(list.length-1)/2;i>0;i--) {//构造大顶堆  
			heapadjust(i, list.length-1);
		}
		display();
		System.out.println();
		for(i=list.length-1;i>1;i--) {//交换后  再次构造大顶堆
			swap(1, i);
			heapadjust(1, i-1);
		}
	}
	
	public static void heapadjust(int s,int length) {//堆排序  从函数  只负责将第s个节点与其左右子树比较  切换位置
		int i,temp;
		temp=list[s];
		//完全二叉树的性质    最多循坏两遍  基于完全二叉树的性质  i<且=length 原因是当交换构造大顶堆的时候  此时权为20的节点是根节点  权为10的为左子树  length=2
		for(i=s*2;i<=length;i*=2) {
			if(i<length&&list[i]<list[i+1]) {//有右子树  且左子树小于右子树
				i++;
			}
			if(temp>=list[i]) {//大于左子树  或者大于左子树和右子树中最大的那一个
				break;
			}
			list[s]=list[i];
			s=i;
		}
		list[s]=temp;
	}



	public static void megersort() {//归并排序非递归实现
		int  k=1;
		while(k<list.length-1) {
			megerpass(list,listswitch,k, list.length-1);//将list归并到listswitch  
			k*=2;//子序列长度加倍
			megerpass(listswitch, list, k, list.length-1);//将listswitch归并到list中去  k为一个子序列的长度
			k*=2;
		} 
	}
	public static void megerpass(int sr[],int tr[],int s,int n) {
		int i=1;
		int j;
		/**
		 * 选取两组进行归并，单位为 s
		 */
		while(i<=n-2*s+1) {//i小于总长度减去两组子序列长度加一  也就是说不管最后剩下的是一组子序列  还是单独的一个记录  都按剩下时一组子序列的情况来处理
			meger(sr,tr,i, i+s-1, i+2*s-1);
			i=i+2*s;//每次循环前进两个已经归并好的两个子序列长度的下标
		}
		/**
		 * 剩下一个单位 s 让他与之前已经归并好的进行归并
		 */
		if(i<n-s+1) {//说明最后未归并的序列还有两组
			System.out.println("归并单位为---->"+s);
//			System.out.println(""+i+" "+s+" "+n);
			meger(sr,tr,i, i+s-1, n);
		}
		/**
		 *
		 */
		else {
			System.out.println("归并单位为:"+s);
			for( j=i;j<=n;j++) {//最后不管归并到哪个数组里都把归并好的数组赋给另一个数组
				tr[j]=sr[j];
			}
		}
	}
/*	public static void meger(int sr[],int tr[],int i,int m,int n) {//将有序的list[i...m]和list[m+1...n]合并成有序的listswitch  同有序链表的合并
		int j ,k,l;
		for(k=m+1,j=i;i<=m&&k<=n;j++) {
			if(sr[i]<sr[k]) {
				tr[j]=sr[i++];
			}else {
				tr[j]=sr[k++];
			}
		}
		if(k<=n) {
			for(int temp=k;temp<=n;temp++) {
				tr[temp]=sr[temp];
			}
		}if(j<=m) {
			for(int temp=j;temp<=m;temp++) {
				tr[temp]=sr[temp];
			}
		}
	}*/
//	public static void meger(int sr[],int tr[],int i,int m,int n) {//将有序的list[i...m]和list[m+1...n]合并成有序的listswitch  同有序链表的合并
//	int j ,k;
//	for(j=m+1,k=i;i<=m&&j<=n;k++) {
//		if(sr[i]<sr[j]) {
//			tr[k]=sr[i++];
//		}else {
//			tr[k]=sr[j++];
//		}
//	}
//	if(i<=m) {
//		for(int l=i;l<=m;l++) {
//			tr[k++]=sr[l];
//		}
//	}if(j<=n) {
//		for(int l=j;l<=n;l++) {
//			tr[k++]=sr[l];
//		}
//	}
//}CONSTRAINT

	//将有序的list[i...m]和 list [m+1...n]合并成有序的listswitch[i....n]  同有序链表的合并
	public static void meger(int list[], int listswitch[], int i, int m, int n) {
		//将 i...m与m+1 ...n比较大小并插入
		int j, k;
		int index=i;
		for (j = i, k = m+1 ; j <= m && k <=n;index++ ) {
			if (list[j] <= list[k])
				listswitch[index] = list[j++];
			else if (list[j] > list[k])
				listswitch[index] = list[k++];
		}

		//i...m中有剩余
		if (j <= m) {
			for (int r=j;r<=m;r++){
				listswitch[index++]=list[r];
			}
		}

		//m+1 ....n中有剩余
		if(k<=n){
			for (int r=k;r<=n;r++){
				listswitch[index++]=list[r];
			}
		}

	}
	public static void quicksort() {//快速排序
		qsort(1, list.length-1);
	}


	public static void qsort(int low,int high) {
		int pkey;
		while(low<high) {
			pkey=partition(low, high);
			qsort(low, pkey);
			low=pkey+1;
		}
	}
	//private static  int []list={0,49 , 81 , 55 , 36 , 44 , 88};

	public static int partition(int low,int high ) {//返回枢轴下标
		int pkey;
//        三数取中操做  数组第一个必须为关键字  且比最后一个元素小  
		/*int m=low+(high-low)/2;

		if(list[low]>list[high]) {
			swap(low, high);
		}
		if(list[m]>list[high]) {
			swap(m, high);
		}
		if(list[m]>list[low]) {
			swap(m, low);
		}*/
		pkey=list[low];
		list[0]=list[low];
		while(low<high) {
			while(low<high&&list[high]>=pkey) {
				high--;
			}
			list[low]=list[high];//替换
			while(low<high&&list[low]<=pkey) {
				low++;
			}
			list[high]=list[low];
		}
		list[low]=list[0];
//		display();
		return low;
	}




	public static void main(String[] args) {
//		TestSorts testSorts=new TestSorts();
//		TestSorts.bubblesorts1();//效率剧中的冒泡排序
//		TestSorts.insertsorts();//简单插入排序
//		TestSorts.display();
//		TestSorts.bubblesorts2();//优化冒泡查询
//		TestSorts.selectsorts();//简单选择查询
//		TestSorts.bubblesorts();
//		TestSorts.sheelsorts();//希尔排序
//		TestSorts.heapsort();//堆排序
//		TestSorts.megersort();//归并排序
		TestSorts.quicksort();
//		TestSorts.display();
		System.out.println();
		display();
//		System.out.println();
//		TestSorts.display2();;

	}
}