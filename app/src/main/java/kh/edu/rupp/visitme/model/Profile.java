package kh.edu.rupp.visitme.model;

public class Profile {

    private int id;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String coverImage;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
