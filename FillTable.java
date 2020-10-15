import java.util.*;
public class FillTable
{
public static void main(String[]args)
{
Scanner input = new Scanner(System.in);
System.out.println("Enter n for n choose m");
int n = input.nextInt();
System.out.println("Enter m of n choose m");
int m = input.nextInt();
int counter = 0;
int size = (n*(n-1)*(n-2))/(3*2*1);
int [] array = new int[size];

for(int i = 1; i <= n; i++)
{
for(int j = i+1; j<=n;j++)
{
for(int k = j+1; k<=n;k++)
{

int d = (i*100)+(j*10)+k;
array[counter] = d;
counter++;

}
}
}
for(int i = 0; i < array.length;i++)
System.out.println(array[i]);
}//end main
public static int[] createTable(int n)
{
int counter = 0;
int size = (n*(n-1)*(n-2))/(3*2*1);
int [] array = new int[size];

for(int i = 1; i <= n; i++)
{
for(int j = i+1; j<=n;j++)
{
for(int k = j+1; k<=n;k++)
{

int d = (i*100)+(j*10)+k;
array[counter] = d;
counter++;

}
}
}
return array;
}
}//end class