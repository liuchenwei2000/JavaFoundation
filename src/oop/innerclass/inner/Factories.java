/**
 * 
 */
package inner;

/**
 * 使用匿名内部类演示工厂方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-14
 */
public class Factories {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		playSport(Football.getSportFactory());
		playSport(Basketball.getSportFactory());
	}

	public static void playSport(SportFactory sf) {
		Sport sport = sf.getSport();
		sport.play();
	}
}

interface Sport {
	
	void play();
}

interface SportFactory {
	
	Sport getSport();
}

class Football implements Sport {
	
	private Football() {
	}

	public void play() {
		System.out.println("shoot a football!");
	}

	public static SportFactory getSportFactory() {
		return new SportFactory() {
			
			public Sport getSport() {
				return new Football();
			}
		};
	}
}

class Basketball implements Sport {
	
	private Basketball() {
	}

	public void play() {
		System.out.println("shoot a basketball!");
	}

	public static SportFactory getSportFactory() {
		return new SportFactory() {
			
			public Sport getSport() {
				return new Basketball();
			}
		};
	}
}