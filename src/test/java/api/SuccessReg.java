package api;

public class SuccessReg extends Register{
    private Integer id;
    private String token;
    public SuccessReg(){

    }

    public SuccessReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessReg(String email, String password, Integer id, String token) {
        super(email, password);
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
