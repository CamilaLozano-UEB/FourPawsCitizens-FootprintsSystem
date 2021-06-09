package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit;

public class NameDateVisit {

    private String petName;
    private String initialDate;
    private String finalDate;

    public NameDateVisit(String petName, String initialDate, String finalDate) {
        this.petName = petName;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public NameDateVisit() {
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }
}
