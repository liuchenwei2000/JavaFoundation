/**
 * 
 */
package enums.itf;

/**
 * 饮料接口
 * <p>
 * 如果想使用子类将一个enum中的元素进行分组，因为不能使用继承。</br>
 * 所以只能采用这个方法来达到目的：</br>
 * 创建一个接口，然后创建实现该接口的枚举，以此将元素进行分组。
 * 对于enum而言，实现接口是使其子类化的唯一方法。
 * <p>
 * 接口的作用是将其所包含的enum组合成一个公共类型。
 * 
 * @author 刘晨伟
 * 
 * 创建时间：2008-8-6
 */
public interface Drink {

	/**
	 * 水
	 */
	public enum Water implements Drink {

		HOTWATER("白开水"), CLEANWATER("纯净水");

		private String name;

		private Water(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "水";
		}
	}

	/**
	 * 咖啡
	 */
	public enum Coffee implements Drink {

		NEST("雀巢"), G7("越南G7"), BLUE("蓝山咖啡");

		private String name;

		private Coffee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "咖啡";
		}
	}

	/**
	 * 茶
	 */
	public enum Tea implements Drink {

		GREENTEA("绿茶"), BLACKTEA("红茶"), OOLONGTEA("乌龙茶"), JASMINETEA("茉莉花茶");

		private String name;

		private Tea(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "茶";
		}
	}

	/**
	 * 果汁
	 */
	public enum Juice implements Drink {

		APPLE("苹果汁"), PEACH("桃汁"), GRAPE("葡萄汁");

		private String name;

		private Juice(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "果汁";
		}
	}
}