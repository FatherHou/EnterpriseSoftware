package lesson.j2ee.ex6.model;

public class Beer {
	private int id;
	private String name;
	private String manufacturer;
	private String color;
    public Beer(int id,String name,String manufacturer,String color)
    {
    	super();
    	this.id=id;
    	this.name=name;
    	this.manufacturer=manufacturer;
    	this.color=color;
    }
	public Beer() {
		super();
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", manufacturer="
				+ manufacturer + ", color=" + color + "]";
	}
    
}
