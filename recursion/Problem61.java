class Problem61
{
  public static void main(String[] args)
  {
    System.out.println("3 * 4 or mult(3,4) = " + mult(3,4));

    System.out.println("5 * 5 or mult(5,5) = " + mult(5,5));

  }

  public static int mult(int x, int y)
  {
    if (y==1)
      return x;
    else
      return (x + mult(x, y-1));
  }
}