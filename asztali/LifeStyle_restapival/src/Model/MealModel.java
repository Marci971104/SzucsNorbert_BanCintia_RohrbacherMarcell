package Model;

public class MealModel {
		public int id;
		public String name;
		public String calorievalue;
		public String fat ;
		public String protein;
		public String carbohydrate;
		public String salt ;
		
		
		
		public MealModel(int id , String name, String calorivalue, String fat, String protein,String carbohydrate, String salt) {
			this.id=id;
			this.name=name;
			this.calorievalue=calorivalue;
			this.fat=fat;
			this.protein=protein;
			this.carbohydrate=carbohydrate;
			this.salt=salt;
		}
	
};
