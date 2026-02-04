public abstract class Person {
    protected  String name;
    protected  String phone;
    protected  String bg;
    protected  String add;

    Person(){}

    Person(String name,String phone,String bg,String add){
        this.name=name;
        this.phone=phone;
        this.bg=bg;
        this.add=add;

    }


    public  void setName(String name) {
        this.name=name;
    }

    public  void setBg(String bg){
        this.bg=bg;
    }


    public abstract void setAdd(String address) ;

    public abstract void setPhone(String phone);

    public abstract String getName() ;
    public abstract String getAdd() ;
    public abstract String getBg() ;
    public abstract String getPhone() ;

    @Override
    public String toString() {
        return  name ;
    }
}
