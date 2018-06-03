class Problem64
{
  public static double[] sack = {11,8,7,6,5};

  public static void main(String[] args)
  {
    
     knapsack(20, 0);
  }
  
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
        System.out.println("i = " + i);
				if(!complete) complete = knapsack(targetWeight, i);
			}
		}
		if(sack[index] > targetWeight) complete = knapsack(targetWeight, index+1);
		
		
		return complete;
  }
  
  /*
  public static Boolean knapsack(int target, int index)
  {
    Boolean a = false;

    if (index == weights.length)
    {
      System.out.println("index == weights.length");
      a = false;
    }

    if(weights[index] == target)
      a = true;
    
    if (weights[index] < target)
    {
      System.out.println("Weight is Smaller than Target. TAKE.");
      target = target - weights[index]; // new target
      System.out.println("Target  = " + target);
      System.out.println(weights[index] +", ");
      a = knapsack(target, index+1);

      if(a)
      {
        System.out.print(weights[index] + " ");
      }

      for(int i=index+1; i < weights.length; i++)
      {
        if(!a)
          a = knapsack(target, i);
      }
    }
    
    if (weights[index] > target)
    {
      System.out.println("Weight is Larger than Target. IGNORE.");
      System.out.println("Target  = " + target);
      System.out.println(weights[index] +", ");
      a = knapsack(target, index+1);
    }

    return a;
  }*/

}