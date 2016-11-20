
public class OverdueVisitor implements LoanableItemVisitor{

	private static OverdueVisitor visitor;

	/**
	 * The constructor is for the singleton pattern
	 */
	private OverdueVisitor() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the instance of the class
	 */
	public static OverdueVisitor instance() {
		if (visitor == null) {
			visitor = new OverdueVisitor();
		}
		return visitor;
	}
	
	private int count; 
	
	@Override
	public void visit(LoanableItem item) {
		if(item.isOverdue()){
			System.out.println(item + "/n");
			count++;
		}
	}

	@Override
	public void visit(Book book) {
		if(book.isOverdue()){
			System.out.println(book + "/n");
			count++;
		}
	}

	@Override
	public void visit(Periodical periodical) {
		if(periodical.isOverdue()){
			System.out.println(periodical + "/n");
			count++;
		}
	}

	@Override
	public void visit(Laptop laptop) {
		if(laptop.isOverdue()){
			System.out.println(laptop + "/n");
			count++;
		}
	}

	@Override
	public void visit(DigitalCamera camera) {
		if(camera.isOverdue()){
			System.out.println(camera + "/n");
			count++;
		}
	}

	@Override
	public void visit(DVD dvd) {
		if(dvd.isOverdue()){
			System.out.println(dvd + "/n");
			count++;
		}
	}
	
	
	public int getCount(){
		return count;
	}
	
	
}//end class
