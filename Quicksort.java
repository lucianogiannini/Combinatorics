public class Quicksort
{
    public static int partition( int lo, int hi, Comparable[] x)
    {
        Comparable pivot = x[lo];
        int left = lo;
        int right = hi;
        while (left < right)
        {
            while (pivot.compareTo(x[right])< 0) //pivot < x[right]
                right--;


            while (left < right && x[left].compareTo(pivot)<=0)// x[left]<= pivot)
                left++;
            if (left < right)
            {
                Comparable temp = x[left];
                x[left] = x[right];
                x[right] = temp;
            }
        }
        int position = right;
        x[lo] = x[position];
        x[position] = pivot;
        return position;
    }


    public static void quicksort(int lo, int hi, Comparable[] x)
    {
        int position;
        if ( hi > lo)
        {
            position = partition(lo,hi, x);
            quicksort(lo, position-1, x);
            quicksort(position+1, hi, x);
        }
    }

    public static void sort( Comparable x[], int size)
    {
        quicksort(0, size-1, x);
    }

}

