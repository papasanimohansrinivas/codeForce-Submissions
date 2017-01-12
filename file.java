import java.lang.Math;
import java.util.Scanner;
import java.util.StringTokenizer;

public class file{
	public file(){

	}
	public static class Main{
	int numbers[];
	int plot[][];
	public Main(int n){
		plot=new int[900][900];
		numbers =  new int[n];
	}
	public void drawMap(){
		Queue cord = new Queue();
		cord.enque(new Node(445,445,"90"));
		for (int s=0;s<numbers.length ;s++ ) {
			Queue temporary1 = new Queue();
			while(!cord.isEmpty()){
				Node temp[] = draw(cord.dequeue(),numbers[s]);
				temporary1.enque(temp[0]);
				temporary1.enque(temp[1]);
			}
			while(!temporary1.isEmpty()){
				cord.enque(temporary1.dequeue());
			}
		}


	}
	public Node[] drawAtAngle(int x,int y,int a_ngle,int length){
		Node tem[];
		//int length=3;
		//System.out.println(a_ngle);
		int angle=a_ngle;
		if (a_ngle>360) {
			angle=a_ngle%360;
		}
		if (angle==90) {
			for (int h=0;h<length+1 ;h++ ) {
				plot[x-h][y]=1;
			}
			tem= new Node[2];
			tem[0]=new Node(x-length,y,""+(a_ngle+45));
			tem[1]=new Node(x-length,y,""+(a_ngle-45));
			//return new Node(x-length,y,""+a_ngle);
			return tem;
		}
		if (angle==180) {
			for (int f=0;f<length+1 ;f++ ) {
				plot[x][y-f]=1;
			}
			tem = new Node[2];
			tem[0]=new Node(x,y-length,""+(a_ngle+45));
			tem[1]=new Node(x,y-length,""+(a_ngle-45));
			//return new Node(x,y-length,""+a_ngle);
			return tem;
		}
		if (angle==270) {
			for (int g=0;g<length+1 ;g++ ) {
				plot[x+g][y]=1;
			}
			tem = new Node[2];
			tem[0]=new Node(x+length,y,""+(a_ngle+45));
			tem[1]=new Node(x+length,y,""+(a_ngle-45));
			//return new Node(x+length,y,""+a_ngle);
			return tem;
		}
		if (angle==360) {
			for (int v=0;v<length+1 ;v++ ) {
				plot[x][y+v]=1;
			}
			tem = new Node[2];
			tem[0]=new Node(x,y+length,""+(a_ngle+45));
			tem[1]=new Node(x,y+length,""+(a_ngle-45));
			//return new Node(x,y+length,""+a_ngle);
			return tem;
		}
		
		if (Math.sin(angle)>0) {
			if (Math.cos(angle)>0) {
				for (int u=0;u<length+1 ;u++ ) {
					plot[x-u][y+u]=1;
				}
				tem = new Node[2];
				tem[0]=new Node(x-length,y+length,""+(a_ngle+45));
				tem[1]= new Node(x-length,y+length,""+(a_ngle-45));
				//return new Node(x-length,y+length,""+a_ngle);
				return tem;
			}
			else{
				for (int z=0;z<length+1 ;z++ ) {
					plot[x-z][y-z]=1;
				}
				tem = new Node[2];
				tem[0]=new Node(x-length,y-length,""+(a_ngle+45));
				tem[1]=new Node(x-length,y-length,""+(a_ngle-45));
				//return new Node(x-length,y-length,""+a_ngle);
				return tem;
			}

		}
		else{
			if (Math.cos(angle)>0) {
				for (int l=0;l<length+1 ;l++) {
					plot[x+l][y+l]=1;
				}
				tem=new Node[2];
				tem[0]=new Node(x+length,y+length,""+(a_ngle+45));
				tem[1]=new Node(x+length,y+length,""+(a_ngle-45));
				//return new Node(x+length,y+length,""+a_ngle);
				return tem;
			}
			else{
				//System.out.println(a_ngle);
				for (int e=0;e<length+1 ;e++ ) {
					plot[x+e][y-e]=1;
				}
				tem=new Node[2];
				tem[0]=new Node(x+length,y-length,""+(a_ngle+45));
				tem[1]=new Node(x+length,y-length,""+(a_ngle-45));
				//return new Node(x+length,y-length,""+a_ngle);
				return tem;
			}

		}
	}
	public Node[] draw(Node tempo,int length){
		int x = tempo.x;
		int y = tempo.y;
		int newAngle_1 = Integer.parseInt(tempo.angle);
		return drawAtAngle(x,y,newAngle_1,length);

	}
	public int searchTheArray(){
		int count=0;
		for (int c=0;c<plot.length ;c++ ) {
			for (int z=0;z<plot[c].length ;z++ ) {
				if (plot[c][z]==1) {
					count++;
				}
			}
		}
		return count-1;
	}
	public String printThePlot(){
		String output = "";
		for (int q=0;q<plot.length ;q++ ) {
			for (int s=0;s<plot[q].length ;s++ ) {
				if (plot[q][s]==0) {
					output=output+" "+" ";
				}else{
					output=output+plot[q][s]+" ";
				}
			}
			output=output+"\n";
		}
		return output;
	}
	public static void main(String[] args) {
		

		
	}

}
public static class Queue{

	Node array[];
	int size;
	public Queue(){
		size=0;
		array=new Node[200];
	}
	public void enque(Node temp){
		array[size]=temp;
		size++;
	}
	public Node dequeue(){
		Node temp = array[0];

		for (int q=0;q<size ;q++ ) {
			array[q]=array[q+1];
		}
		size--;

		return temp;
	}
	public boolean isEmpty(){

		if (size==0){
			return true;
		}		
		else{
			return false;
		}
			
	}
	
	public static void main(String[] args) {
		
	}
}


public static class Node{
	int x;
	int y;
	String angle;
	public Node(int x,int y,String angle){

		this.x=x;
		this.y=y;
		this.angle=angle;

	}
	
}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n =  Integer.parseInt(scan.nextLine());
		String input=  scan.nextLine();
		Main sample = new Main(n);
		StringTokenizer tokens = new StringTokenizer(input);
		int size=0;
		while(tokens.hasMoreTokens()){
			sample.numbers[size]=Integer.parseInt(tokens.nextToken());
			size=size+1;
		}
		sample.drawMap();
		System.out.println(sample.searchTheArray());
		//System.out.println(sample.printThePlot());
	}
}



