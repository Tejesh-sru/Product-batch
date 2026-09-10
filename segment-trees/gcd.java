
public class gcd {
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }    
    public static int[] tree;
    public static void build(int index,int start,int end,int[] arr){
         if(start==end){
            tree[index]=arr[start];
         } 
         else{
            int mid=(start+end)/2;
            build(2*index+1,start,mid,arr);
            build(2*index+2,mid+1,end,arr);
            tree[index]=gcd(tree[2*index+1],tree[2*index+2]);
         }
    }
    public static void update(int index,int start,int end,int arrIndex,int value){
        if(start==end){
            tree[index]=value;
        }
        else{
            int mid=(start+end)/2;
            if(arrIndex>=start && arrIndex<=mid){
                update(2*index+1,start,mid,arrIndex,value);
            }
            else{
                update(2*index+2,mid+1,end,arrIndex,value);
            }
            tree[index]=gcd(tree[2*index+1],tree[2*index+2]);
        }
    }
    public static int query(int index,int start,int end,int left,int right){
        if(start>right || end<left){
            return 0;
        }
        if(start>=left && end<=right){
            return tree[index];
        }
        int mid=(start+end)/2;
        int leftGcd=query(2*index+1,start,mid,left,right);
        int rightGcd=query(2*index+2,mid+1,end,left,right);
        return gcd(leftGcd,rightGcd);
    }
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        int n=arr.length;
        tree=new int[4*n];
        build(0,0,n-1,arr);
        System.out.println(query(0,0,n-1,1,3));
        update(0,0,n-1,2,12);
        System.out.println(query(0,0,n-1,1,3));
    }
}
