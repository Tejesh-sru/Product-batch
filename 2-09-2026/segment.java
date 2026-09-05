public class segment{
    int[] arr;
    int start;
    int end;
    public segment(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        build(0,0,arr.length-1); 
    }
    public int build(int index,int start,int end){
        if(start==end){
            return arr[start];
        }
        int mid=(start+end)/2;
        int left=new segment(arr,start,mid).build();
        int right=new segment(arr,mid+1,end).build();
        arr[index]=left+right;
        return arr[index];
}