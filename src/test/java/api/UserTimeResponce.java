package api;

public class UserTimeResponce extends UserTime{
    public UserTimeResponce() {
    }
    private String updatedAt;

    public UserTimeResponce(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public String getUpdateAt() {
        return updatedAt;
    }
}
