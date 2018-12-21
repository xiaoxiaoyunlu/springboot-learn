package oz.mano.online;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;

public class TestGuvaCache {

	public static void main(String[] args) {

		
//		CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(30L, TimeUnit.MILLISECONDS);
		
			System.out.println(random());
		
	}

	
	public static int random(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for(int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        return result;
    }
}
