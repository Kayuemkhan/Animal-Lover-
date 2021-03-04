package code.fortomorrow.animallover.ModelClass;

public class ProfessionalData {
    private int imageResource;
    private String professionalName;
    private String email;
    private String cell;
    private String chamber;
    private String desination;
    private String qualification;
    public ProfessionalData() {
    }

    public ProfessionalData(int imageResource, String professionalName, String email, String cell, String chamber, String desination, String qualification) {
        this.imageResource = imageResource;
        this.professionalName = professionalName;
        this.email = email;
        this.cell = cell;
        this.chamber = chamber;
        this.desination = desination;
        this.qualification = qualification;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getDesination() {
        return desination;
    }

    public void setDesination(String desination) {
        this.desination = desination;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
