class BracketChecker
{
    private String input;       // input string

    public BracketChecker(String in)
    {
        input = in;
    }

    public void check()
    {
        int stackSize = input.length(); // get max stack size
        StackX theStack = new StackX(stackSize);

        for(int j=0; j<input.length(); j++) // get chars in turn
        {
            char ch = input.charAt(j);  // get char
            switch(ch)
            {
                case '{':   // opening symbols
                case '[':
                case '(':
                    theStack.push(ch);  // push them
                    break;
                case '}':       // closing symbols
                case ']':
                case ')':
                    if (!theStack.isEmpty())    // if stack isn't empty
                    {
                        char chx = theStack.pop(); // pop and check
                        if((ch=='}' && chx !='{') ||
                            (ch==']' && chx !='[') ||
                            (ch==')' && chx !='('))
                            System.out.println("Error: " +ch+" at "+j);
                        
                    }
                    else            // prematurely empty
                    {
                        System.out.println("Error: "+ch+" at "+j);
                    }
                    break;
            }
        }
    }
}