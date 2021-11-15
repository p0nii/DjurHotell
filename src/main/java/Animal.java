public class Animal {

   String namn;
   String favoritmat;
   String favoritaktivitet;

   //Konstruktor
   public Animal(String namn, String favoritmat, String favoritaktivitet) {
      this.namn = namn;
      this.favoritmat = favoritmat;
      this.favoritaktivitet = favoritaktivitet;
   }


   public String getNamn() {
      return namn;
   }

   public void setNamn(String namn) {
      this.namn = namn;
   }

   public String getFavoritmat() {
      return favoritmat;
   }

   public void setFavoritmat(String favoritmat) {
      this.favoritmat = favoritmat;
   }

   public String getFavoritaktivitet() {
      return favoritaktivitet;
   }

   public void setFavoritaktivitet(String favoritaktivitet) {
      this.favoritaktivitet = favoritaktivitet;
   }
}
