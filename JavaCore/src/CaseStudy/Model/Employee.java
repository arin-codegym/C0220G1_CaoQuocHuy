package CaseStudy.Model;

public class Employee  {
    private String id;
    private String fullNameEmp;
    private int ageEmp;
    private String addressEmp;


    public Employee(String id, String fullNameEmp, int ageEmp, String addressEmp) {
        this.id = id;
        this.fullNameEmp = fullNameEmp;
        this.ageEmp = ageEmp;
        this.addressEmp = addressEmp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +'\'' +
                "fullNameEmp='" + fullNameEmp + '\'' +
                ", ageEmp=" + ageEmp +
                ", addressEmp='" + addressEmp + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullNameEmp() {
        return fullNameEmp;
    }

    public void setFullNameEmp(String fullNameEmp) {
        this.fullNameEmp = fullNameEmp;
    }

    public int getAgeEmp() {
        return ageEmp;
    }

    public void setAgeEmp(int ageEmp) {
        this.ageEmp = ageEmp;
    }

    public String getAddressEmp() {
        return addressEmp;
    }

    public void setAddressEmp(String addressEmp) {
        this.addressEmp = addressEmp;
    }

    public Employee() {
    }

    public Employee(String fullNameEmp, int ageEmp, String addressEmp) {
        this.fullNameEmp = fullNameEmp;
        this.ageEmp = ageEmp;
        this.addressEmp = addressEmp;
    }


}
