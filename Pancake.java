import java.util.Scanner;
class Pancake{
	double radius = 0;
	double height = 0;
	public Pancake(int radius, int height)
	{
		this.radius = radius;
		this.height = height;
	}
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		int T = a.nextInt();
		for(int i=1;i<=T;i++)
		{
			int N = a.nextInt();
			int K = a.nextInt();
			Pancake[] pancake_array = new Pancake[N];
			for(int u=0;u<N;u++)
			{
				pancake_array[u] = new Pancake(0,0);
			}
			for(int k=0;k<N;k++)
			{
				pancake_array[k].radius = a.nextDouble();
				pancake_array[k].height = a.nextDouble();
			}
			//double ans1 = solvemain(pancake_array, N,K);
			//double ans2 = solvemain2(pancake_array, N,K);
			//double ans = 0;
			//if(ans1>ans2)
			//	ans = ans1;
			//else
//ans = ans2;

			System.out.println("Case #" + i + ": " + solvemain(pancake_array, N,K));
			//System.out.println("Case #" + i + ": " + ans);
			

		}
	}
	static int[] len_arr(int a)
	{
		int[] arr = new int[a];
		for(int i=0;i<a;i++)
		{
			arr[i]=i;
		}
		return arr;
	}
	static int[] one_zero(int N,int K)
	{
		int[] arr = new int[N];
		for(int i=0;i<K;i++)
		{
			arr[i]=0;
		}
		for(int j=K;j<N;j++)
		{
			arr[j]=1;
		}
		return arr;

	}
	static double solvemain(Pancake[] p, int N, int K)
	{
		Pancake[] p1 = p;
		double temp = -1;
		int[] arr = new int[p.length];
		for(int i=0;i<p.length*p.length;i++)
		{
			arr = swap(one_zero(N,K), i);
			for(int t=0;t<N;t++)
			{
				if(arr[t]==0)
				{
					p[t].radius = 0;
					p[t].height = 0;
				}
			}
			if((solve(p,p.length))>temp)
				temp = solve(p,p.length);
		}
		// extra method, not used to get the first 3 cases
		/*for(int s=0;s<p1.length*p1.length;s++)
		{
			arr = swap2(len_arr(p1.length), s);
			for(int yi=0;yi<N-K;yi++)
			{
				arr[yi]=0;
			}
			for(int q=0;q<p1.length;q++)
			{
				if(arr[q]==0)
				{
					p1[q].radius = 0;
					p1[q].height = 0;
				}
			}
			if((solve(p1,p.length))>temp)
				temp = solve(p,p.length);
		}*/
		return temp;
	}
	static double solvemain2(Pancake[] p, int N, int K)
	{
		Pancake[] p1 = p;
		double temp = -1;
		int[] arr = new int[p.length];
		for(int i=0;i<p.length*p.length;i++)
		{
			arr = swap(len_arr(N-K), i);
			for(int y=0;y<N-K;y++)
			{
				arr[y]=0;
			}
			for(int t=0;t<N-K;t++)
			{
				if(arr[t]==0)
				{
					p[t].radius = 0;
					p[t].height = 0;
				}
			}
			if((solve(p,p.length))>temp)
				temp = solve(p,p.length);
		}
		// extra method, not used to get the first 3 cases
		/*for(int s=0;s<p1.length*p1.length;s++)
		{
			arr = swap2(len_arr(p1.length), s);
			for(int yi=0;yi<N-K;yi++)
			{
				arr[yi]=0;
			}
			for(int q=0;q<p1.length;q++)
			{
				if(arr[q]==0)
				{
					p1[q].radius = 0;
					p1[q].height = 0;
				}
			}
			if((solve(p1,p.length))>temp)
				temp = solve(p,p.length);
		}*/
		return temp;
	}
	static double solve(Pancake[] p, int K)
	{
		p = sortDescending_on_Radius(p);
		double lateral_Surface_Area = 0;
		for(int i=0;i<K;i++)
		{
			lateral_Surface_Area+=2*Math.PI*p[i].height*p[i].radius;
		}
		double total_Area = lateral_Surface_Area + (Math.PI*p[0].radius*p[0].radius);
		return total_Area;
	}
	static int[] swap(int[] arr, int a)
{
	int temp = 0;
	int[] ret = new int[arr.length];
	for(int i=0; i<arr.length;i++)
	{
		for(int j=0;j<arr.length-1;j++)
		{
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			if(i+j==a){
				ret = arr;
				break;
			}


		}
	}
return arr;
}
static int[] swap2(int[] arr, int a)
{
	int temp = 0;
	int[] ret = new int[arr.length];
	for(int i=0; i<arr.length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			if(i*j==a){
				ret = arr;
				break;
			}


		}
	}
return arr;
}
	static Pancake[] sortDescending_on_Radius(Pancake[] p)
	{
		int n = p.length;
		Pancake temp = new Pancake(0,0);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(p[i].radius>p[j].radius)
				{
					temp = p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
		}
		return p;
	}

}