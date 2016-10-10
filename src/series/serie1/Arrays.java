package series.serie1;

/**
 * Created by Snitram on 10/10/2016.
 */
public class Arrays {

    public	static	int	countEquals(int[]	v1,	int	l1,	int	r1,	int[]	v2,	int	l2,	int	r2){
        int	count=0;
        while(l1<=r1	&&	l2<=r2){
            if(v1[l1]>v2[l2])	l2++;
            else
            if(v1[l1]<v2[l2])	l1++;
            else	{	count++;	l1++;	l2++;}
        }
        return	count;
    }
}
