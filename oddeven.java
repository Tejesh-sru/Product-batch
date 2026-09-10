public class oddeven {
    class node{
        int sum;
        int max;
        node(int sum,int odd){
            this.odd=0;
            this.even=0;
        }
    }
    public static node[] tree;
    public static void main(String args[]){
        int n=5;
        int[] arr={1,2,3,4,5};
        tree=new node[4*n];
        build(0,0,n-1,arr);
    }
    public static void build(int index,int start,int end,int[] arr){
        tree[index]=new node(0,0);
        if(start==end){
        if(arr[index]%2==0){
            tree[index].even=1;
        }
        else{
            tree[index].odd=1;
        }
        return;
        }
        int mid=(start+end)/2;
        build(2*index+1,start,mid,arr);
        build(2*index+2,mid+1,end,arr);
        tree[index].even=tree[2*index+1].even+tree[2*index+2].even;
        tree[index].odd=tree[2*index_+1].odd+tree[2*index+2].odd;

    }
}
