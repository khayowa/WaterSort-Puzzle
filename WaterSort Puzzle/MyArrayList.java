 
public class MyArrayList<E> 
{
  private int size;
  private E[] data;
  private int MAXELEMENTS = 100;
  
  public MyArrayList() {
	   data = (E[])new Object[MAXELEMENTS];
       size = 0;
  }
  
  public int getMAXELEMENTS(){
	  return MAXELEMENTS;
  }
	  
   
  
  public boolean checkSpace()
  {
	  if (size+1<MAXELEMENTS)
		  return true;
	  else
		  return false;
  }
  
  public void add(int index, E e) {   
    
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size); 
    
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];
    
    data[index] = e;
    
    size++;
  }

  public boolean contains(Object e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i])) return true;
    return false;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    return data[index];
  }
  
  public E remove(int index) {
	if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    E e = data[index];
   
    for (int j = index; j < size - 1; j++)
      data[j] = data[j + 1];
    data[size - 1] = null; 
    
    size--;
    return e;
  }
  
  public void clear()
  {
     size = 0;
  }
 
  public MyArrayList<E> merge(MyArrayList<E> param)
  {
	  int i=0;
	  int j=0; 
	  int k=0; 
	  MyArrayList<E> returnArray = new MyArrayList();
	  
	  if (this.getSize() ==0)
		  return param;
	  if (param.getSize()==0)
		  return this;
	  if ((this.getSize()+ param.getSize()) > MAXELEMENTS)
		   throw new IndexOutOfBoundsException
        ("Combined list out of bounds");
		
	 
	  while (i<this.getSize() && j<param.getSize())
	  {
		  
		  if (((Comparable)data[i]).compareTo(param.data[j]) <0)
		  {
			returnArray.data[k]= this.data[i];
			k++;
			i++;	
		  }
		  else
		  {
			returnArray.data[k]=param.data[j];
			k++;
			j++;
		  }
	  }
	  
	 
	  if (i < this.getSize())
	  {
		  for (i=i;i<getSize();i++) 
		  {
			returnArray.data[k]= this.data[i];
			k++;
		  }
	  }
	  if (j < param.getSize())
	  {
		  for (j=j;j<param.getSize();j++)
		  {
			returnArray.data[k]=param.data[j];
			k++;
		  }
	  }
	  returnArray.size = k; 
	  return returnArray;
  }		  
		  
	  
  public String toString() {
    String result="[";
    for (int i = 0; i < size; i++) {
      result+= data[i];
      if (i < size - 1) result+=", ";
    }
    return result.toString() + "]";
  }

  public boolean checkUniform(){
      E value = null;
      boolean result = true;

      if(getSize() != 0){
          value = get(0);
      }

      for(int i = 0; i < getSize()-1; i++){
          if(((Comparable)value).compareTo(data[i+1]) !=0 ){
              result = false;
              if(!result){
                  break;
              }
          }
      }

      return result;


  }

  
  public int getSize() {
    return size;
  }
  
 public boolean sortList() {
    E hold;
	for (int i = 0; i < size-1; i++)
	 {
	   for (int j = 0; j<size-1; j++)
	    {  	 
	     if(((Comparable)data[j]).compareTo(data[j+1])>0)
	      {
	       hold= data[j+1];
	       data[j+1]=data[j];
	       data[j]=hold;
	      }       
	   }
     } 
	 return true;	  	
  }


 
}