import java.io.*;
import java.util.*;

class AbcNode
{
	public String sData;			//data item (key)
	public AbcNode leftChild;
	public AbcNode rightChild;
	
	public void displayNode()
	{
		System.out.print("{" + sData + "}");
	}
}