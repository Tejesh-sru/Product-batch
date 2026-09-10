class segment{
    int[] tree;
    public static void build(int index,int start,int end,int[] arr){
        if(start==end){
            tree[index]=arr[start];
        }
        else{
            int mid=(start+end)/2;
            build(2*index+1,start,mid,arr);
            build(2*index+2,mid+1,end,arr);
            tree[index]=tree[2*index+1]+tree[2*index+2];
        }
    }
    public static void update(int index,int start,int end,int[] arr,int idx,int val){
        if(start==end){
            arr[idx]=val;
            tree[index]=val;
            return;
        }
        int mid=(start+end)/2;
        if(idx<=mid){
            update(2*index+1,start,mid,arr,idx,val);
        }
        else{
            update(2*index+2,mid+1,end,arr,idx,val);
        }
        tree[index]=tree[2*index+1]+tree[2*index+2];
    }
    public static int query(int index,int start,int end,int l,int r){
        if(r<start || end<l){
            return 0;
        }
        if(l<=start && end<=r){
            return tree[index];
        }
        int mid=(start+end)/2;
        int left=query(2*index+1,start,mid,l,r);
        int right=query(2*index+2,mid+1,end,l,r);
        return left+right;
    }
}