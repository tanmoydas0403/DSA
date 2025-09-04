package com.theory.first;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];

            //copy all previous items in new data
            System.arraycopy(data, 0, temp, 0, data.length);

            data = temp;
        }

        //at this point know that array is not full
        //insert item
        return super.push(item);
    }
}
