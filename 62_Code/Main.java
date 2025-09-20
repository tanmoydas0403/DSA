public class Main {
    public static void main(String[] args) {
        int[] arr = {1 , 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        //build a blocks array
        int sqrt = (int)Math.sqrt(n);
        
        int blocks_id = -1;

        int[] blocks = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            //new block is started
            if(i % sqrt == 0){
                blocks_id++;
            }
            blocks[blocks_id] += arr[i];
        } 

        System.out.println(query(blocks, arr, 2, 6, 3));
    }

    //query
    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt){
        int ans = 0;

        //left part
        while (l % sqrt != 0 && l < r && l != 0) {
            ans += arr[l];
            l++;        
        }

        //middle part
        while (l + sqrt <= r) {
            ans += blocks[l / sqrt];
            l += sqrt;
        }

        //right part
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public void update(int[] blocks, int[] arr, int index, int val, int sqrt){
        int block_id = index / sqrt;
        blocks[block_id] += val - arr[index];
        arr[index] = val;
    }
    

}