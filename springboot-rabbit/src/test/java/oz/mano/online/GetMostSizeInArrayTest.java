package oz.mano.online;

public class GetMostSizeInArrayTest {

	public static void main(String[] args) {

		int[] datas = {1,6,3,1,7,5,5,5,3};
		int findMaxNumber = FindMaxNumber(datas,9,8);
		System.out.println(findMaxNumber);
	}
	
	public static int FindMaxNumber(int[] arr,int len, int k)
	{
		int i;
		int ans=arr[0];
		int maxCnt=0;// maxCnt/k 为当前最大的重复次数
		for(i=0;i<len;i++)
		{
			arr[arr[i]%k]+=k;
	        if(maxCnt < arr[arr[i]%k])
			{			
				maxCnt = arr[arr[i]%k];			
				ans = arr[i]%k;			
			}				
		}
	    //恢复数组
		for ( i = 0; i< len; i++)
		{		
			arr[i] = arr[i] % k;		
		}
		
		return ans;
	}
	
	public static void BubbleSort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
	
	public static void print(int[] a){
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * 默认是int 数组，要求空间复杂度最低  本身无序
	 * 如果要是不能排序 就得重新考虑了
	 * @param datas
	 * @return
	 */
	public static int getMost(int[] datas){
		
		return 0;
	}
	
	public static void swap(int a,int b){
		a =a^b;
		b=a^b;
		a=a^b;
	}
	
	public static void swap1(int a,int b){
		int temp =a;
		a = b;
		b = temp;
		
	}

}
