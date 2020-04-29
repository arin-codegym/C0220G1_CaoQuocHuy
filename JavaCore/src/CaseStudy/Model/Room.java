package CaseStudy.Model;

public class Room extends Services {
private String freeServiceIncluded;

    public Room() {
    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String id, String name, double areaUsed, double rentalCosts, int maximumNumberOfPeople, String typeOfRent, String freeServiceIncluded) {
        super(id, name, areaUsed, rentalCosts, maximumNumberOfPeople, typeOfRent);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String showInfo() {
        return "\nName Service :"+getName()+
                "\nArea Used :"+getAreaUsed()+
                "\nRental costs  :"+getRentalCosts()+
                "\nMaxinum number of the people :"+getMaximumNumberOfPeople()+
                "\nType of rent :"+getTypeOfRent()+
                "Free service included : "+  this.freeServiceIncluded;
    }
}
