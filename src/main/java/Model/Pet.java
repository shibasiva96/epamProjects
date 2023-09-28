package Model;

public class Pet {
	private String name;
	private Category category;
	private String status;
	private int id;
	
	public Pet(int id,String name, Category category, String status) {
		this.name = name;
		this.category = category;
		this.status = status;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
