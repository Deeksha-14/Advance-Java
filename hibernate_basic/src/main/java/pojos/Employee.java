package pojos;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.persistence.*;


@Entity //mandatory to tell hibernate, following class is a stand-alone entity , whose lc is to be managed
@Table(name= "emps") //to specify table name
public class Employee {

	//emp_id(PK) ,first_name,last_name,email(unique),password,join_date,emp_type(full_time/part_time/contract...), salary
	
	//mandatory to ser id: id property must be ser till 5.x
	//can it be int long  : yess
	//but not recommended
	//recommended types are wrapper classes
	//cause they are seri
	@Id //mandatory , pk constraints it will add
	@GeneratedValue(strategy = GenerationType.IDENTITY) // hibernate should generate ids automatically, as per auto increment strategy
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20) //dont duplicate cols name tble will not get generated
	private String lastName;
	
	@Column(length = 30, unique = true) //unique constraint
	private String email;
	
	@Column(length = 30, nullable = false) //by def true
	private String password;
	

//skip a particular property from persistance
	@Transient //skips from persistence => no col generation
	private String confirmPassword;
	
	@Column(name ="join_date")
	private LocalDate joinDate;
	
	@Enumerated(EnumType.STRING) //col type : varchar => enum const name ; default is ordinal
	@Column(length = 20)
	private EmploymentType type;
	private double salary;
	
	@Lob //large object : def col type : longblob : 4mb
	private byte[] image;//cl type blob - binary  object
	
	//def ctor
	
	public Employee() {
		super();
		
	}
	

	public Employee(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate joinDate, EmploymentType type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}


	//setters and getters
	public Integer getempId() {
		return empId;
	}


	public void setId(Integer empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastName;
	}


	public void setLastname(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}


	public EmploymentType getType() {
		return type;
	}


	public void setType(EmploymentType type) {
		this.type = type;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [id=" + empId + ", firstName=" + firstName + ", lastname=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + "]";
	}
	
	
}
