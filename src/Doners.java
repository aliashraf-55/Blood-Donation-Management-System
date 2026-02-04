public class Doners extends Person{
    private int age;
    private String gender;
    private String date;
    Doners(){}
    Doners(String name,int age,String phone,String gender,String add,String bg,String date){
        super(name,phone,bg,add);
        this.age=age;
        this.date=date;
        this.gender=gender;

    }

    @Override
    public void setName(String name) {
        this.name=name;}

    @Override
    public String getName() {
        return  name;
    }


    @Override
    public void setAdd(String add) {
        super.add=add;
    }
    @Override
    public void setBg(String bg) {
        this.bg=bg;
    }
    @Override
    public void setPhone(String phone) {
        super.phone=phone;
    }
    @Override
    public String getAdd() {
        return add;
    }
    @Override
    public String getBg() {
        return bg;
    }
    @Override
    public String getPhone() {
        return phone;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getAge() +
                "\t" +getPhone() + "\t" + getGender() + "\t" + getAdd()
                + "\t" + getBg() + "\t" + getDate() + "\n";
    }
}

