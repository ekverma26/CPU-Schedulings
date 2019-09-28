public class fcfs
{
static void calWaitTime(int process[],int n,int bt[],int wt[])
{	
	int i;
	wt[0]=0;
	for(i=1;i<n;i++)
	{
	wt[i]=bt[i-1]+wt[i-1];
	}
}
static void calTurnTime(int process[],int n,int bt[],int wt[],int tat[])
{
	int i;
	for(i=0;i<n;i++)
	{
	tat[i]=bt[i]+wt[i];
	}
}
static void calAvgTime(int process[],int n,int bt[])
{
	int wt[]=new int[n];
	int tat[]=new int[n];
	int twt=0,ttat=0,i;
	calWaitTime(process,n,bt,wt);
	calTurnTime(process,n,bt,wt,tat);
	for(i=0;i<n;i++)
	{
	twt=twt+wt[i];
	ttat=ttat+tat[i];
	}
	int w,t;
	w=twt/n;
	t=ttat/n;	
	System.out.printf("Processes Burst_Time Waiting_Time Turn_around_time\n");
	for(i=0;i<n;i++)
	{
	System.out.printf("%d\t\t",i+1);
	System.out.printf("%d\t\t",bt[i]);
	System.out.printf("%d\t\t",wt[i]);
	System.out.printf("%d\n",tat[i]);
	}
	System.out.printf("Average Waiting Time:%d",w);
	System.out.printf("\n");
	System.out.printf("Average Turn Around Time:%d",t);
	
}

public static void main(String args[])
{
int process[]={1,2,3};
int bt[]={10,5,8};
int n=process.length;
calAvgTime(process,n,bt);
}
}
