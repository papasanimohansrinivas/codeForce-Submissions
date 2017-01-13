import java.util.*;
public final class Bulbbasaur{
	String line;
	char middleEarth[];
	ArrayList array;
	int size1;
	String word = "Bulbasaur";
	public Bulbbasaur(String input){
		this.line=input;
		array = new ArrayList();
		//middleEarth = new char[100000];
	}
	public void stripping(){
		this.size1=0;
		for (int l=0;l<line.length() ;l++ ) {
			if (contains(line.charAt(l))) {
				array.add(line.charAt(l));
			}
		}

	}
	public int solution(){
		stripping();
		Queue sample = new Queue();
		for (int k=0;k<word.length() ;k++ ) {
			sample.enque(word.charAt(k));
		}
		int count=0;
		boolean flag = false;
		while(true){
			char searching  = sample.deque();
			//System.out.println(searching);
			for (int v=0;v<array.len ;v++ ) {
				if (searching==array.get(v)) {
					//System.out.println(count+"count");
					//middleEarth[v]='\0';
					array.set(v,'\0');
					flag=true;
					break;
				}
			}
			if (flag==true) {
				sample.enque(searching);
				count++;
				flag=false;
			}
			else{
				break;
			}
			
		}

		return count/word.length();

	}
	public  boolean contains(char letter){

		word = "Bulbasaur";
		for (int q=0;q<word.length() ;q++ ) {
			if (word.charAt(q)==letter) {
				return true;
			}
		}
		return false;
	}
	public static class Queue{
		char letters[];
		int size;
		public Queue(){
			letters=new char[100000];
			this.size=0;
		}
		public  void enque(char letter){
			letters[size]=letter;
			size++;
		}
		public  char deque(){

			char temp = letters[0];
			for (int a=0;a<letters.length-1 ;a++ ) {
				letters[a]=letters[a+1];
			}
			this.size--;
			return temp;
		}
		
	}
	public static class ArrayList{
		char arr[];
		int len;
		public ArrayList(){
			arr=new char[2];
			len=0;
		}
		public void add(char ele){
			if (len==arr.length) {
				grow();
			}
			arr[len]=ele;
			len++;
		}
		public char get(int index){

			return arr[index];
		}
		public void set(int index,char chr){

			arr[index]=chr;
		}
		public void grow(){
			char temporary[] = new char[2*arr.length];
			for (int y=0;y<arr.length ;y++ ) {
				temporary[y]=arr[y];
			}
			arr=temporary;
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		Bulbbasaur work = new Bulbbasaur(line);
		//System.out.println('B'=='b');
		System.out.println(work.solution());
		
		
	}
}