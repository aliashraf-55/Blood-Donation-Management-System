 public class requestperson extends Person{

    requestperson(){

    }
    requestperson(String name,String bloodg,String address,String phone){
        super(name,phone,bloodg,address);


    }


     @Override
     public void setAdd(String add) {

        this.add = add;
     }

     @Override
     public void setName(String name) {
     }

     @Override
     public void setBg(String bg) {
     }

     @Override
     public void setPhone(String phone) {
         this.phone = phone;

     }

     @Override
     public String getName() {
         return name;
     }

     @Override
     public String getPhone() {
         return phone;
     }

     @Override
     public String getBg() {
         return bg;
     }

     @Override
     public String getAdd() {
         return add;
     }
 }
