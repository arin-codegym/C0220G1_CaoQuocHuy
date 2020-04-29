package CaseStudy.Model;

public class Villa extends AdvancedService {
    private double poolArea;

    public Villa(String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors, double poolArea) {
        super(roomStandard, descriptionOfOtherAmenities, numberOfFloors);
        this.poolArea = poolArea;
    }

    public Villa(String id, String name, double areaUsed, double rentalCosts, int maximumNumberOfPeople, String typeOfRent, String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors, double poolArea) {
        super(id, name, areaUsed, rentalCosts, maximumNumberOfPeople, typeOfRent, roomStandard, descriptionOfOtherAmenities, numberOfFloors);
        this.poolArea = poolArea;
    }

    public Villa(double poolArea) {
        this.poolArea = poolArea;
    }


    public Villa() {
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String showInfo() {
        return super.showInfo()+
                "\nPool Area :"+this.poolArea;
    }
}
