package dungeon;

public class Sprite {
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int armor;
	private int damage;
	private int maxSpeed;
	private int currentSpeed;
	private int maxMana;
	private int currentMana;
	private int xLocation;
	private int yLocation;
	

	public Sprite(String name, int maxHealth, int currentHealth, int armor, int damage, int maxSpeed, int currentSpeed, int maxMana, int currentMana, int xLocation, int yLocation) {
		this.setName(name);
		this.setMaxHealth(maxHealth);
		this.setCurrentHealth(currentHealth);
		this.setArmor(armor);
		this.setDamage(damage);
		this.setMaxSpeed(maxSpeed);
		this.setCurrentSpeed(currentSpeed);
		this.setMaxMana(maxMana);
		this.setCurrentMana(currentMana);
		this.setXLocation(xLocation);
		this.setYLocation(yLocation);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

	public int getXLocation() {
		return xLocation;
	}

	public void setXLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getYLocation() {
		return yLocation;
	}

	public void setYLocation(int yLocation) {
		this.yLocation = yLocation;
	}	
}
