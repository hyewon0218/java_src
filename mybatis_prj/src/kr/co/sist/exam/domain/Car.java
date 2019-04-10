package kr.co.sist.exam.domain;

public class Car {
   private String img, maker, model, carYear, price,carOption, hiredate;

   public void setHiredate(String hiredate) {
      this.hiredate = hiredate;
   }

   public String getHiredate() {
      return hiredate;
   }

   public String getImg() {
      return img;
   }

   public String getMaker() {
      return maker;
   }

   public String getModel() {
      return model;
   }

   public String getCarYear() {
      return carYear;
   }

   public String getPrice() {
      return price;
   }

   public String getCarOption() {
      return carOption;
   }

   public void setImg(String img) {
      this.img = img;
   }

   public void setMaker(String maker) {
      this.maker = maker;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public void setCarYear(String carYear) {
      this.carYear = carYear;
   }

   public void setPrice(String price) {
      this.price = price;
   }

   public void setCarOption(String carOption) {
      this.carOption = carOption;
   } 
   
   
}