public class rectangle {
   private double length;
   private double width;


   public rectangle(double length, double width) {
       this.length = length;
       this.width = width;
   }
   public double getLength() {
       return length;
   }
   public double getWidth() {
       return width;
   }
   public void setLength(double length) {
       this.length = length;
   }
   public void setWidth(double width) {
       this.width = width;
   }
   public double surface(double length, double width){
       return (length*width)/2;
   }
   public String toString() {
       return "length: "+length+" width:" +width;
   }
}

