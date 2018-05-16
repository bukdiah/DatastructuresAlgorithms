class Problem52
{
    public static void main(String[] args)
    {
        DQ dq = new DQ();
        dq.insertLeft(1);
        dq.insertLeft(2);
        dq.insertLeft(3);
        //dq.insertLeft(4);
    
        dq.print();
    
        dq.insertRight(10);
        dq.insertRight(15);
    
        dq.print();
    
        dq.removeLeft();
        dq.removeRight();
    
        dq.print();
    }
}