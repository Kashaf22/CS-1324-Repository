import java.util.ArrayList;
////Kashaf Mujeeb, Worked with Moez Ullah Khan on this project
public class Driver 
{
	public static void main(String[] args)
	{
		ArrayList<Triangle> array_List = new ArrayList<Triangle>(); //Constructing the arrays and including the triangles to the arrayList
		array_List.add(new Triangle(1, 2, 3)); 
		array_List.add(new Triangle (2, 3, 4));
		array_List.add(new Triangle (3, 4, 5));
		array_List.add(new Triangle (4, 5, 6));
		array_List.add(new Triangle (5, 6, 7));
		
		System.out.println("New objects");
		System.out.println(array_List); 
		System.out.println();
		
		System.out.println("Using Accessors"); //printing out every side of all the triangles
		
		
		for (int k =0; k < array_List.size(); ++k) 
		{
			Triangle tri = array_List.get(k);
			System.out.print("Triangle: ");
			System.out.print(tri.getSideA() +" ");
			System.out.print(tri.getSideB() + " ");
			System.out.println(tri.getSideC());
		}
		System.out.println();
		
		for (int i =0; i < array_List.size(); ++i)
		{
			Triangle tri = array_List.get(i);
			tri.setSideA(10); //setting 10 for the side A of all the triangles
		}
		System.out.println("After Side A changed");
		System.out.println(array_List);
		System.out.println();
		
		for (int x=0; x < array_List.size(); ++x)
		{
			Triangle tri = array_List.get(x);
			tri.setSideB(10); //setting side 10 for the side B of all the triangles
		}
		System.out.println("After Side B changed");
		System.out.println(array_List);
		System.out.println();
		
		for (int m =0; m < array_List.size(); ++m)
		{
			Triangle tri = array_List.get(m);
			tri.setSideC(10);  //setting side 10 for the side C of all the triangles
		}
		System.out.println("After Side C changed");
		System.out.println(array_List);
	}
}
