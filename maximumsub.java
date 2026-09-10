public class maximumsub {
    static class node{
        int sum;
        int max;
        node(int sum,int max){
            this.sum=sum;
            this.max=max;
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
            tree[index].sum=arr[start];
            tree[index].max=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build(2*index+1,start,mid,arr);
        build(2*index+2,mid+1,end,arr);
        int left=tree[2*index+1].sum;
        int right=tree[2*index+2].sum;
        if(left+right<0){
            tree[index].sum=0;
        }
        else{
            tree[index].sum=left+right;
            tree[index].max=Math.max(tree[index].max,tree[index].sum);
        }
    } 
}
