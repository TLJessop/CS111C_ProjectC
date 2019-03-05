
public class ProjectCTester {

	public static void main(String[] args) {
		HeadTailListInterface<Integer> list = new ArrayHeadTailList<Integer>(10);

		// un-comment this line and comment the line above to test the extra credit
		// NOTE: for the extra credit, all lines should match except for the capacity print out-
		// the capacity of an ArrayList is private, so this cannot be shown
		// HeadTailListInterface<Integer> list = new ListHeadTailList<Integer>(10);


		// test isEmpty
		System.out.println("********TESTING ISEMPTY AND EMPTY DISPLAY");
		System.out.println("true\n" + list.isEmpty());
		System.out.println();
		System.out.println("0 elements; capacity = 10");
		list.display();
		System.out.println();

		// test addFront to emtpy
		System.out.println("\n\n********TESTING ADD TO FRONT");

		list.addFront(2);
		System.out.println("1 elements; capacity = 10	[2]");
		list.display();
		System.out.println();

		// test addFront to not empty
		list.addFront(4);
		list.addFront(3);
		System.out.println("3 elements; capacity = 10	[3, 4, 2]");
		list.display();
		System.out.println();

		System.out.println("false\n" + list.isEmpty());
		System.out.println();

		System.out.println("\n\n********TESTING CLEAR");
		// test clear
		list.clear();
		System.out.println("0 elements; capacity = 10");
		list.display();
		System.out.println();

		System.out.println("\n\n********TESTING ADD TO BACK");
		// test addBack to empty
		list.addBack(7);
		System.out.println("1 elements; capacity = 10	[7]");
		list.display();
		System.out.println();

		// test addBack to non empty
		list.addBack(10);
		list.addBack(5);
		System.out.println("3 elements; capacity = 10	[7, 10, 5]");
		list.display();
		System.out.println();

		System.out.println("\n\n********TESTING CONTAINS");
		// test contains
		System.out.println("2\n"+list.contains(5));
		System.out.println();
		System.out.println("0\n"+list.contains(7));
		System.out.println();
		System.out.println("-1\n"+list.contains(4));
		System.out.println();

		System.out.println("\n\n********TESTING ADD WITH EXPANSION");
		// test adding with expansion
		list.clear();
		for(int i=0; i<32; i++) {
			list.addBack(i);
		}
		System.out.println("32 elements; capacity = 40	[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]");
		list.display();
		System.out.println();

		System.out.println("\n\n********TESTING SIZE");
		// test size
		System.out.println("32\n" + list.size());
		System.out.println();

		System.out.println("\n********TESTING GET ENTRY");
		// test getEntry
		System.out.println("15\n"+list.getEntry(15));
		System.out.println();
		System.out.println("0\n"+list.getEntry(0));
		System.out.println();
		System.out.println("null\n"+list.getEntry(35));
		System.out.println();
		System.out.println("null\n"+list.getEntry(-1));
		System.out.println();

		System.out.println("\n\n********TESTING REMOVES");
		// test removes from nonEmpty
		System.out.println("0\n"+list.removeFront());
		System.out.println();
		System.out.println("31\n"+list.removeBack());
		System.out.println();
		System.out.println("30 elements; capacity = 40	[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]");
		list.display();
		System.out.println();

		// test removes from empty
		list.clear();
		System.out.println("null\n"+list.removeFront());
		System.out.println();
		System.out.println("null\n"+list.removeBack());
		System.out.println();

		// final test of mixed adds and removes
		list.addFront(3);
		list.addBack(2);
		list.addFront(4);
		list.addFront(5);
		list.addBack(3);
		list.addBack(8);
		list.addBack(9);
		list.display();
		System.out.println("7 elements; capacity = 40	[5, 4, 3, 2, 3, 8, 9]");
		System.out.println();

		list.removeFront();
		list.removeBack();
		list.display();
		System.out.println("5 elements; capacity = 40	[4, 3, 2, 3, 8]");
		System.out.println();

		System.out.println("********TESTING WITH STRINGS");
		HeadTailListInterface<String> wordList = new ArrayHeadTailList<String>(5);
		wordList.addFront("job!");
		wordList.addFront("Nice");
		wordList.addFront("it!");
		wordList.addFront("did");
		wordList.addFront("You");
		wordList.display();
		System.out.println("5 elements; capacity = 5	[You, did, it!, Nice, job!]");
		System.out.println();



	}

}
