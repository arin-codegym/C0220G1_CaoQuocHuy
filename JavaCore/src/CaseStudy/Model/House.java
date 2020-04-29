package CaseStudy.Model;

public class House extends AdvancedService {
    public House(String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors) {
        super(roomStandard, descriptionOfOtherAmenities, numberOfFloors);
    }

    public House(String id, String name, double areaUsed, double rentalCosts, int maximumNumberOfPeople, String typeOfRent, String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors) {
        super(id, name, areaUsed, rentalCosts, maximumNumberOfPeople, typeOfRent, roomStandard, descriptionOfOtherAmenities, numberOfFloors);
    }

    public House() {
    }

    @Override
    public String showInfo() {
        return super.showInfo();
    }
}
