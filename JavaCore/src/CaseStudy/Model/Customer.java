package CaseStudy.Model;

public class Customer {
    private String name_customer;

    private String birthday;
    private String gender;
    private String id_card;
    private String phone_number;
    private String email;
    private String guest_type;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name_customer, String birthday, String gender, String id_card, String phone_number, String email, String guest_type, String address, Services services) {
        this.name_customer = name_customer;

        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.guest_type = guest_type;
        this.address = address;
        this.services = services;
    }



    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuest_type() {
        return guest_type;
    }

    public void setGuest_type(String guest_type) {
        this.guest_type = guest_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String showInfo() {
       return  "\nInformation Customer : " +
                "\nCustomer Name: " + this.getName_customer() +

                "\nBirthday: " + this.getBirthday() +
                "\nGender: " + this.getGender() +
                "\nIdCard: " + this.getId_card() +
                "\nNumber Phone: " + this.getPhone_number() +
                "\nEmail: " + this.getEmail() +
                "\nCustomer type: " + this.getGuest_type() +
                "\nAddress: " + this.getAddress();
    }
}
