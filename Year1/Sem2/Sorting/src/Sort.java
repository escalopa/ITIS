public class Sort {

    int MIN_VALUE = 64;

    public int  minValueLength(int n) {
        int r = 0;
        while (n >= MIN_VALUE) {
            r = (n % 2 ==0) ?0 :1;
            n /= 2;
        }
        return n+r;
    }

    public void timSort(int arr[], int n) {

    }

    public void insertion(int arr[], int l, int r) {

        for (int i = l; i < r; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j>l && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp ;
        }
    }

    public void merge(int arr[], int l, int m, int r) {

        // 1 2 3 5 76 8 9 5
        int l1 = m-l+1;
        int l2 = r-m;

        int arrL1[] = new int[l1];
        int arrL2[] = new int[l2];

        for (int i = 0; i <l ; i++) {
            arrL1[i] = arr[l+i];
        }

        for (int i = 0; i <r ; i++) {
            arrL2[i] = arr[m+1+i];
        }

        int i =0;
        int j=0;
        int k=l;
        while(i<l1 && j<l2){
            if (arrL1[i]>arrL2[j]){
                arr[k] = arrL2[j];
                j++;
            }else{
                arr[k] = arrL1[i];
                i++;

            }
            k++;
        }
        while (i<l1){
            arr[k] = arrL1[i];
            i++;
        }
        while (j<l2){
            arr[k] = arrL2[j];
            j++;
        }
    }

}
