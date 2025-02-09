package domain.models.customer;

public class ContactInfo {
    private String email;
    private String mobileNo;

    public ContactInfo(String email, String mobileNo) {
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
