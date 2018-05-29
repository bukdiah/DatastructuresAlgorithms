
class Problem63
{
  public static void main(String[] args)
  {
    // System.out.println("2^9 = 512");
    // System.out.println("power(2,9) = " + power(2,9) );
    // System.out.println("");
     System.out.println("2^8 = 256");
     System.out.println("power(2,8) = " + pow(2,8));
     System.out.println("");
    
     //System.out.println("3^18 = 43046721");
     System.out.println("power(3,18) = " + pow(3,18));

   

  }

  public static int power(int x, int y)
  {
    System.out.println("x = " + x + "  y = " + y);
    if (y==1)
    {
      return x;
    }
    else if (y%2 == 0) // even
      return power(x*x, y/2);
    else // odd
      return x * power(x*x, y/2);
  }

}