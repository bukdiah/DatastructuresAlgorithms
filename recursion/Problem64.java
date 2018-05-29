class Problem64
{
  public static int[] weights = {11,8,7,6,5};
  public static double[] sack;

  public static void main(String[] args)
  {
    sack = new double[]{11, 8, 7, 6, 5};
    if(!knapsack(37, 0)) System.out.println("No valid combinations");
    
     knapsack(20, 0);
  }
  
  public static Boolean knapsack(int target, int index)
  {
    Boolean a = false;

    if (index == weights.length)
      a = false;
    
    if(weights[index] == target)
      a = true;
    else if (weights[index] < target)
    {
      System.out.println("Weight is Smaller than Target. TAKE.");
      target = target - weights[index]; // new target
      System.out.println("Target  = " + target);
      System.out.println(weights[index] +", ");
      a = knapsack(target, index+1);

      if(a)
      {
        System.out.println(weights[index]);
      }

      for(int i = index+1; i<weights.length; i++)
      {
        if(!a)
          a = knapsack(target, i);
      }
    }
    else if (weights[index] > target)
    {
      System.out.println("Weight is Larger than Target. IGNORE.");
      System.out.println("Target  = " + target);
      System.out.println(weights[index] +", ");
      a = knapsack(target, index+1);
    }

    return a;
  }

  /*
  public static Boolean knapsack(double targetWeight, int index)
	{
		Boolean complete = false;
		
		if(index == sack.length) return false;
		if(sack[index] == targetWeight)
		{
			System.out.print("Answer: " + sack[index] + " ");
			complete = true;
		}; //DONE
		if(sack[index] < targetWeight) 
		{
			complete = knapsack(targetWeight-sack[index], index+1); //keep going
			if(complete) System.out.print(sack[index] + " ");
			for(int i = index+1; i < sack.length; i++) 
			{
				if(!complete) complete = knapsack(targetWeight, i);
			}
		}
		if(sack[index] > targetWeight) complete = knapsack(targetWeight, index+1);
		
		
		return complete;
	}*/
}