package p1;
import java.io.*;
import java.util.*;
import java.lang.*;



public class Elevator{


	FileWriter writer;
	public static void main(String args[])throws Exception{
		outerloop:
		while(true){
	System.out.println("\nPress '1' if you're inside the Elevator");
	System.out.println("Press '2' if you're outside the Elevator");
	System.out.println("Press '3' to know status of the Elevator");
	System.out.println("Press '4' to exit simulation");
	Scanner sc1=new Scanner(System.in);
	int i=sc1.nextInt();
	OutsideElevator obj1=new OutsideElevator();
	FileReader reader= new FileReader("currentfloor.txt");
				int currentfloor=reader.read();
				reader.close();
		
		switch(i){
			case 1:
			obj1.insideElevator();
			break;
			case 2:
			obj1.outsideElevator();
			break;
			case 3:
			obj1.currentfloor(currentfloor);
			break;
			case 4:
			break outerloop;
			default:
			System.out.println("\nInvalid Input\n");

		}
	}

	}
	public void currentfloor(int currentfloor){
		System.out.println("\nCurrent floor:"+currentfloor+"\n");
	}

}


class InsideElevator extends Elevator{

	

		public final int topfloor=5;
		public final int bottomfloor=0;
		public int preferredfloor;

	public void insideElevator()throws Exception{
				OutsideElevator obj=new OutsideElevator();
				FileReader reader= new FileReader("currentfloor.txt");
				int currentfloor=reader.read();
				reader.close();
				
			try{
				obj.currentfloor(currentfloor);
				System.out.println("\nEnter the floor you need to go to:");
				Scanner floor=new Scanner(System.in);
				preferredfloor=floor.nextInt();
				if(preferredfloor<bottomfloor||preferredfloor>topfloor||preferredfloor==currentfloor)
				throw new IOException();
				else
					obj.move(preferredfloor,currentfloor);
			}
			catch(IOException e){
				System.out.println("\nInvalid input,try again!\n");
				Scanner floor=new Scanner(System.in);
				preferredfloor=floor.nextInt();
				if(preferredfloor<bottomfloor||preferredfloor>topfloor||preferredfloor==currentfloor)
				throw new IOException();
				else
					obj.move(preferredfloor,currentfloor);
			}
	}
	public void move(int preferredfloor,int currentfloor)throws Exception{
		OutsideElevator obj=new OutsideElevator();
		if(preferredfloor<currentfloor)
			obj.movedown(preferredfloor,currentfloor);
		else
			obj.moveup(preferredfloor,currentfloor);
	}
	public void moveup(int preferredfloor,int currentfloor)throws Exception{
		System.out.println("\nGOING UP!\n");
		for(int i=currentfloor;i<preferredfloor;i++)
			currentfloor++;
		System.out.println("Current floor:"+currentfloor+"\n");
		writer=new FileWriter("currentfloor.txt");
		writer.write(currentfloor);
		writer.close();

	}
	public void movedown(int preferredfloor,int currentfloor)throws Exception{
		System.out.println("\nGOING DOWN!\n");
		for(int i=currentfloor;i>preferredfloor;i--)
			currentfloor--;
		System.out.println("Current floor:"+currentfloor+"\n");
		writer=new FileWriter("currentfloor.txt");
		writer.write(currentfloor);
		writer.close();
	}
	
}

class OutsideElevator extends InsideElevator{

		
		
		

		public void outsideElevator()throws Exception{
			
			OutsideElevator obj=new OutsideElevator();
			FileReader reader= new FileReader("currentfloor.txt");
				int currentfloor=reader.read();
				reader.close();
				obj.currentfloor(currentfloor);

				try{
				System.out.println("Enter the floor you are currently in:");
				Scanner floor=new Scanner(System.in);
				preferredfloor=floor.nextInt();
				
				if(preferredfloor<bottomfloor||preferredfloor>topfloor||preferredfloor==currentfloor)
				throw new IOException();
				else{
					System.out.println("\nThe Elevator is on its way!\n");
					obj.move(preferredfloor,currentfloor);
				}
			}
			catch(IOException e){
				System.out.println("\nInvalid input,try again!\n");
				Scanner floor=new Scanner(System.in);
				preferredfloor=floor.nextInt();
				if(preferredfloor<bottomfloor||preferredfloor>topfloor||preferredfloor==currentfloor)
				throw new IOException();
				else{
					System.out.println("\nThe Elevator is on its way!\n");
					obj.move(preferredfloor,currentfloor);
				}
			}
			
		}
}
abstract class Lift extends Elevator{
	public abstract void emergency(int currentfloor);
	public abstract void nonStop();
}