package code.fortomorrow.animallover.ModelClass;

public class ProfessionalData {
    private int imageResource;
    private String professionalName;
    private String email;

    public ProfessionalData() {
    }

    public ProfessionalData(int imageResource, String professionalName, String email) {
        this.imageResource = imageResource;
        this.professionalName = professionalName;
        this.email = email;
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
}
