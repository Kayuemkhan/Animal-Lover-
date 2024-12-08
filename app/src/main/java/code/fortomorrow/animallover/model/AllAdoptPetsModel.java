package code.fortomorrow.animallover.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllAdoptPetsModel {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("petsAge")
    @Expose
    private String petsAge;
    @SerializedName("petsBreed")
    @Expose
    private String petsBreed;
    @SerializedName("petsColor")
    @Expose
    private String petsColor;
    @SerializedName("petsHabbit")
    @Expose
    private String petsHabbit;
    @SerializedName("petsName")
    @Expose
    private String petsName;
    @SerializedName("petsPlace")
    @Expose
    private String petsPlace;
    @SerializedName("petsSex")
    @Expose
    private String petsSex;
    @SerializedName("petsWeight")
    @Expose
    private String petsWeight;
    private String phone_number;
    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("time")
    @Expose
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPetsAge() {
        return petsAge;
    }

    public void setPetsAge(String petsAge) {
        this.petsAge = petsAge;
    }

    public String getPetsBreed() {
        return petsBreed;
    }

    public void setPetsBreed(String petsBreed) {
        this.petsBreed = petsBreed;
    }

    public String getPetsColor() {
        return petsColor;
    }

    public void setPetsColor(String petsColor) {
        this.petsColor = petsColor;
    }

    public String getPetsHabbit() {
        return petsHabbit;
    }

    public void setPetsHabbit(String petsHabbit) {
        this.petsHabbit = petsHabbit;
    }

    public String getPetsName() {
        return petsName;
    }

    public void setPetsName(String petsName) {
        this.petsName = petsName;
    }

    public String getPetsPlace() {
        return petsPlace;
    }

    public void setPetsPlace(String petsPlace) {
        this.petsPlace = petsPlace;
    }

    public String getPetsSex() {
        return petsSex;
    }

    public void setPetsSex(String petsSex) {
        this.petsSex = petsSex;
    }

    public String getPetsWeight() {
        return petsWeight;
    }

    public void setPetsWeight(String petsWeight) {
        this.petsWeight = petsWeight;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
