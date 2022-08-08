import javax.lang.model.util.ElementScanner6;

public class StackAsMyArrayList<E> 
{   
	MyArrayList<E> theStack;
    public StackAsMyArrayList()
    {  theStack = new MyArrayList<E>();       
    }
	
    public void push(E newElement) 
    {  
		   if (!theStack.checkSpace())
		   throw new IndexOutOfBoundsException
                    ("Stack out of bounds");
		   theStack.add(theStack.getSize(),newElement);
    }
	
	public E pop() 
    {  
		E temp = null;
		
		boolean isDone = false;
		if (theStack.getSize() > 0)
			temp=theStack.remove(theStack.getSize()-1);
		return temp; 
    }

    public E peek(){
        E temp = null;
        
        temp = theStack.get(theStack.getSize()-1);
        return temp;
    
    }

    public int getStackSize(){
        int size = 0 ;
        size = theStack.getSize();
        return size;

    }

    public boolean checkStackUniform(){

        return theStack.checkUniform();
    }
    
	public String toString()
	{
		return theStack.toString();
	}
   
}//end class
