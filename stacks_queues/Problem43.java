class Problem43
{
    public static void main(String[] args)
    {
        StackDeque sd = new StackDeque(5);

        sd.insertLeft(1);
        sd.insertLeft(2);
        sd.insertLeft(3);
        sd.insertLeft(4);
        sd.insertLeft(5);

        while(!sd.isEmpty())
        {
            long value = sd.removeLeft();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }

}