package code.fortomorrow.animallover.ModelClass;

public class BlogModelClass {
    private int imageResource;
    private String professionalName;
    private String email;
    private String description;

    public BlogModelClass() {
    }

    public BlogModelClass(int imageResource, String professionalName, String email, String description) {
        this.imageResource = imageResource;
        this.professionalName = professionalName;
        this.email = email;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
