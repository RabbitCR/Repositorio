package musicbox;

public class ArrayList {
    private int size;
    private int maxSize;
    private Object [] array;
    private final int max_Size = 10;
    
    public ArrayList (){
        this.size = 0;
        this.maxSize = max_Size;
        this.array = new Object [this.maxSize];
    }
    
    public ArrayList (int max){
        this.size = 0;
        this.maxSize = max;
        this.array = new Object [max];
    }
    
    public void add (Object element){
        if (this.size < this.maxSize){
            this.array [this.size] = element;
            this.size ++;
        }
        else{
            System.out.println("Error");
        }
    }
    
    public int getSize (){
        //System.out.println(this.size);
        return this.size;
    }
    
    public Object getElement (int index){
        if (index >= this.size || index < 0){
            return -1;
        }
        else{
            return array [index];
        }      
    }
    
    public String toString(){
        String list = "";
        for (int counter = 0; counter < this.size; counter++ ){
            list = list + this.array [counter] + "\n";
        }
        System.out.println(list);
        return list;
}
    
    public String find (Object element, ArrayList array){
        String positions = "";
        for (int counter = 0; counter < array.getSize(); counter++){
            if (array.getElement(counter) == element){
                positions = positions + counter + " ";
            }
        }
        System.out.println(positions);
        return positions;
    }
    
}
