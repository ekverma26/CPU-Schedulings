import java.util.*;
public class SJF
{
public static void main(String args[])
{ 	
Scanner sc=new Scanner(System.in);
System.out.print("\n Enter the number of process: ");
int i,j,temp,temp1;
int n=sc.nextInt();
int bt[]=new int[n];			
int tat[]=new int[n];		 
int wt[]=new int[n];		
int p[]=new int[n];

for(i=0;i<n;i++)
{
System.out.print("\n Enter process " + (i+1) + " burst time: ");
p[i]=i+1;
bt[i]=sc.nextInt();
}

for(i=0;i<n;i++)
	{
	for(j=i+1;j<n;j++)
		{		
		if(bt[i]>bt[j])
			{
			temp=bt[i];
			bt[i]=bt[j];
			bt[j]=temp;
				
			temp1=p[i];
			p[i]=p[j];
			p[j]=temp1;
			}
		}	
	}

wt[0]=0;
for(i=1;i<n;i++)
{
wt[i]=bt[i-1] + wt[i-1];
}

for(i=0;i<n;i++)
{
tat[i]=wt[i] + bt[i];
}
int sum=0,sum1=0,avg,avg1;	
for(i=0;i<n;i++)
{
sum=sum + wt[i];
sum1=sum1 + tat[i];
}
avg=sum/n;
avg1=sum1/n;
System.out.println("\n\tProcess\t\t" + "Burst Time\t" + "Waiting time\t");
for(i=0;i<n;i++)
{
System.out.println("\t");
System.out.println("\t" + p[i] + "\t\t" +  bt[i] + "\t\t" + wt[i]);
}
System.out.println("\n Average of all waiting time: " + avg);
System.out.println("\n Average of all turn around time: " + avg1);
}
}
