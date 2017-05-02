import java.util.*;
class AI{
    public static void main(String[] args)
    {

	Scanner a = new Scanner(System.in);
	int T = a.nextInt();
	for(int i=1;i<=T;i++)
	    {
		int N = a.nextInt();
		int K = a.nextInt();
		float U = a.nextFloat();
		float[] arr = new float[N];
		for(int j=0;j<N;j++)
		    {
			arr[j] = a.nextFloat();
		    }
		System.out.println("Case #"+i+": "+solve(U,K,arr));;
			/*for(int o=0;o<N;o++)
		    {
			System.out.println(solve(U,K,arr)[o]);
		    }*/

	  
		    
	    }
				   

    }
    static float getNum(float a)
    {
	String aa = Float.toString(a);
	int index = 0;
	String neww = "";
	float ans = 0;
	for(int i=0;i<aa.length();i++)
	    {
		if(aa.charAt(i)=='.')
		    {
		    index=i;
		    break;
		    }
	    }
		if((aa.length()-index-1)<4)
	    ans = Float.parseFloat(aa);
		else
	    ans = Float.parseFloat(aa.substring(0,index+5));

	return ans;
    }
		
    /* static float[] solveTest(float U, int K, float[] a)
    {
	float left = 0;
         
	if(tsbe(a,K)!=0)
	left = U - ((U/tsbe(a,K))*tsbe(a,K));
	else
	    left = U;
	  
        
	float[] sorted = sorte(enableAll(U,K,a));
	int i=0;
	while(left!=0)
	    {
		if(sorted[i]!=1)
		    {
			if(left>(1-sorted[i]))
			    {
			left = left-1+sorted[i];
			sorted[i] = 1;
			i++;
			if(i==a.length)
			    break;
			    }
			else{
			    sorted[i]+= left;
			break;
			}
			
		    }
	
	    }

	return sorted;
        float ans = 0;
	float product =1;
	for(int k = 0; k<sorted.length;k++)
	    {
		product = product * sorted[k];
	    }
	
	float prod = 1;
	
		for(int e = 0; e<sorted.length;e++)
	    {
		prod= prod * (1-sorted[e]);
	    }
		if((1-prod)>product)
		    ans = 1-prod;
		else
		    ans = product;
		return product;
		}*/
    
    static float solve(float U, int K, float[] a)
    {
	float left = 0;
         
	if(tsbe(a,K)!=0)
	left = U - ((U/tsbe(a,K))*tsbe(a,K));
	else
	    left = U;
	  
        
	float[] sorted = sorte(enableAll(U,K,a));
	int i=0;
	while(left!=0)
	    {
		if(sorted[i]!=1)
		    {
			if(left>(1-sorted[i]))
			    {
			left = left-1+sorted[i];
			sorted[i] = 1;
			i++;
			if(i==a.length)
			    break;
			    }
			else{
			    sorted[i]+= left;
			break;
			}
			
		    }
	
	    }

        
	float ans = 0;
	float product =1;
	for(int k = 0; k<sorted.length;k++)
	    {
		product = product * sorted[k];
	    }
	
	float prod = 1;
	
		for(int e = 0; e<sorted.length;e++)
	    {
		prod= prod * (1-sorted[e]);
	    }
		if((1-prod)>product)
		    ans = 1-prod;
		else
		    ans = product;
		return product;
    }
    static float[] sorte(float[] a)
    {
	int n = a.length;
	float temp = 0;
	        for (int i = 0; i < n; i++) 

        {

            for (int j = i + 1; j < n; j++) 

            {

                if (a[i] < a[j]) 

                {

                    temp = a[i];

                    a[i] = a[j];

                    a[j] = temp;

                }

            }

        }
		return a;
    }
	




    
  
    static float[] enableAll(float U,int K, float[] a)
    {
	int count = 0;
	float thres = 0;
	if(tsbe(a,K)==0)
	    thres = 0;
	else
	    thres = U/tsbe(a,K);

	for(int i=0; i<K;i++)
	    {
		//	if(a[i]==0 && count<tsbe(a,K))
		// {
		    a[i]=a[i]+thres;
		    // count++;
		    // }
		
	    }
	return a;
    }
    
    // that should be enabled
    static float tsbe(float[] a, int K)
    {
	float zeros = 0;
	float ans = 0;
	for(int i=0;i<a.length;i++)
	    {
		if(a[i]==0)
		    zeros=zeros+1;
	    }
	if(zeros>K)
	   ans=K;
	else
	    ans = zeros;
	return ans;
    }
}
