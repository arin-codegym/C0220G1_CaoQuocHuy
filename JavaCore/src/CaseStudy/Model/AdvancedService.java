package CaseStudy.Model;

public class AdvancedService extends Services {
    @Override
    public String showInfo() {
        return "\nID :" + getId() +
                "\nName Service :" + getName() +
                "\nArea Used :" + getAreaUsed() +
                "\nRental costs  :" + getRentalCosts() +
                "\nMaximum number of the people :" + getMaximumNumberOfPeople() +
                "\nType of rent :" + getTypeOfRent() +
                "\nRoom standard :" + this.roomStandard +
                "\nDescription of other amenities:" + this.descriptionOfOtherAmenities +
                "\nNumber of floors :" + this.numberOfFloors
                ;
    }
    private String roomStandard;
    private String descriptionOfOtherAmenities;
    private int numberOfFloors;


    public AdvancedService(String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
        this.numberOfFloors = numberOfFloors;
    }

    public AdvancedService(String id, String name, double areaUsed, double rentalCosts, int maximumNumberOfPeople, String typeOfRent, String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors) {
        super(id, name, areaUsed, rentalCosts, maximumNumberOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOfOtherAmenities() {
        return descriptionOfOtherAmenities;
    }

    public void setDescriptionOfOtherAmenities(String descriptionOfOtherAmenities) {
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public AdvancedService(){};
}
