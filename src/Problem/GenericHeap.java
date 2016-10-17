package Problem;
import java.util.Comparator;


public class GenericHeap {


    public  static <T> void maxHeapify(T[] a, int heapSize, Comparator<T> c, int i) { // versao generica com comparadores
        int l, r, largest;
        T key = a[i];
        for ( ;;  ) {
            l = left(i);
            r = right( i );
            //largest = ( r < heapSize && c.compare(a[r], a[l]) > 0 ) ? r : l;
            largest = ( r < heapSize && c.compare(a[r], a[l]) < 0 ) ? r : l;
            //if ( largest < heapSize && c.compare(a[largest], key) > 0) {
            if ( largest < heapSize && c.compare(a[largest], key) < 0) {
                a[i] = a[largest];
                i = largest;               // T(N/2)

            } else {
                a[i] = key;
                return;
            }
        }
    }   // T(N) = T(N/2) + O(1) = O(lg n)

    /**
     * Organizar o valores de um array de objetos de forma a que representem um heap ( O(n) )
     * @param a array de objetos
     * @param heapSize  numero de n�s do heap
     * @param c - funcao de comparacao de elementos do array
     */
    public static <T> void buildHeap(T[] a, int heapSize, Comparator<T> c) {
        int p = parent ( heapSize -1 );
        for ( ; p >= 0 ; --p )
            maxHeapify(a, heapSize,  c, p);
    }

    /**
     * Organizar os valores do array de forma a que representem um heap - O( n )
     * @param a array de objetos
     * @param c - funcao de comparacao de elementos do array
     */
    public static <T> void buildHeap( T[] a, Comparator<T> c ) { buildHeap(a, a.length, c); }

    /**
     * Obter o maximo valor - O( 1 )
     * @param v heap representado em array de objectos
     * @param hSize numero de n�s do heap
     * @return o maior valor
     */
    public static <T> T getMax( T[] v, int hSize ) {
        return v[0];
    }

    /**
     * Retira da estrura heap o maximo valor - O(lg n)
     * @param v heap representado em array de objectos
     *
     * @param hSize numero de n�s do heap
     * @param c fun�ao de compara��o de objectos do heap
     * @return o valor retirado
     */
    public static <T> T extractMax(T[] v, int hSize, Comparator<T> c) {
        T max = v[ 0 ];
        v[ 0 ] = v[hSize-1];         // O (1)
        maxHeapify(v, hSize - 1, c,  0); // O( lg n )
        return max;
    }

    /**
     * Alterar para um valor superior o valor de um n� - O( lg n )
     * @param a heap representado em array de objetos
     * @param i indice do n� cujo valor vai ser alterado para maior
     * @param v valor a inserir
     */
    public static <T> void increase(T[] a, int i, Comparator<T> c, T v ) {
        int p;
        while ( i > 0 && c.compare( a[p = parent( i )], v) < 0 ) {
            a[i] = a[p];
            i = p;
        }
        a[i] = v;
    }

    /**
     * Inserir um valor no heap - O( lg n )
     * @param a heap representado em array
     * @param heapSize n�mero de n�s do heap
     * @param v valor a inserir
     */
    public static <T> void insert(T[] a, int heapSize, Comparator<T> c, T v ) {
        increase(a, heapSize, c,  v );
    }

    /**
     * Alterar o valor de um n� - O(lg n)
     * @param a   - heap representado em array de objetos
     * @param heapSize - n�mero de n�s do heap
     * @param c - fun�ao de compara��o de elementos do array
     * @param i �ndece do n� a ser alterado
     * @param newV valor a ser colocado
     * @return o valor anterior
     */
    public static <T> T set( T[] a, int heapSize, Comparator<T> c, int i, T newV ) {
        T oldValue = a[i];
        if ( c.compare(oldValue, newV) > 0 ) {
            a[i]= newV;
            maxHeapify(a, heapSize, c, i);
        }
        else
            increase(a, i, c, newV);
        return oldValue;
    }

    /**
     * Verifica se a estrutura � um heap
     * @param a heap representado em array de objectos
     * @param heapSize n�mero de n�s do heap
     * @param i raiz do heap a testar
     * @return true se a estrutura � um heap com raiz em i
     * @return
     */
    public static <T> boolean isMaxHeap(T[] a, int heapSize, Comparator<T> c, int i) {
        if ( i > heapSize ) return true;
        int l = left( i ), r = right( i );
        if ( l < heapSize && c.compare(a[i], a[l]) < 0 ||
                r < heapSize && c.compare(a[i], a[r]) <0 ) return false;
        return isMaxHeap(a, heapSize, c, l) && isMaxHeap( a, heapSize, c, r);
    }


    /**
     * Obter o indice do ascendente de qualquer nó dum heap representado em array
     * @param i indice do nó
     * @return  o indice do ascendente do nó i
     */
    static int parent(int i ) {
        return (i-1)>>1;
    }

    /**
     * Obter o indice do descendente esquerdo de qualquer nó dum heap representado em array
     * @param i indice do nó
     * @return  o indice do descendente esquerdo do nó i
     */
    static int left(int i ) {
        return (i<<1)+1;
    }

    /**
     * Obter o indice do descendente direito de qualquer nó dum heap representado em array
     * @param i indice do nó
     * @return  o indice do descendente esquerdo do nó i
     */
    static int right(int i ) {
        return (i<<1)+2;
    }
}