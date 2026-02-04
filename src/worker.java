public class worker {
    private String wname;
    private String id;
    private String pass;

    worker(String wname,String id,String pass){
        this.wname=wname;
        this.id=id;
        this.pass=pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getWname() {
        return wname;
    }

}
