class Employee {

	private String		fName;
	private String		lName;
	private int			IdNum;
	private String		address;
	private int			zipcode;
	private String		phone;
	private int			salary;
	private String		dept;

	public Employee(String fName, String lName, int uid, String address, int zipcode, String phone, int salary, String dept) {
		this.fName = fName;
		this.lName = lName;
		this.IdNum = uid;
		this.address = address;
		this.zipcode = zipcode;
		this.phone = phone;
		this.salary = salary;
		this.dept = dept;
	}

	void setFName(String fName) {
		this.fName = fName;
	}

	void setLName(String lName) {
		this.lName = lName;
	}

	String getLName() {
		return lName;
	}

	String getFName() {
		return fName;
	}

/*
	// do we allow this?
	// probably not - we don't want people changing their ID numbers
	// ...
	// what about special circumstances???

	void setIdNum(int IdNum) {

	}
*/

	int getIdNum() {
		return IdNum;
	}

	void setAddress(String address) {
		this.address = address;
	}

	String getAddress() {
		return address;
	}

	void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	int getZipcode() {
		return zipcode;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	String getPhone() {
		return phone;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	int getSalary() {
		return salary;
	}

	void setDept(String dept) {
		this.dept = dept;
	}

	String getDept() {
		return dept;
	}

	void report() {
		// print out all data together
		System.out.println("Name:       " + this.getFName() + " " + this.getLName() );
		System.out.println("ID Number:  " + this.getIdNum() );
		System.out.println("Address:    " + this.getAddress() );
		System.out.println("Zipcode:    " + this.getZipcode() );
		System.out.println("Phone:      " + this.getPhone() );
		System.out.println("Salary:     " + this.getSalary() );
		System.out.println("Department: " + this.getDept() );
	}
}