package battle.character.type;

import battle.character.Damageable;
import battle.character.Disableable;

public abstract class SpecialFighter extends Fighter implements Disableable {
	
	//the number of turns that the special fighter will be disabled for
	private int disabledTurns;

	/**
	 * Creates a special fighter. This should set the health to full health and should NOT be
	 * disabled initially.
	 * 
	 * @param maxHealth the maximum amount of health the fighter can have
	 * @param attackPower how hard are their punches
	 */
	public SpecialFighter(int maxHealth, int attackPower) {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		super(maxHealth, attackPower);
	}
	
	/**
	 * Attacks the opponent for a random amount of damage 
	 * between 0 and the full attack power (inclusive)
	 * 
	 * @param opponent person to punch
	 * @return the amount of damage they do; this should always be negative or zero
	 */
	public int attack(Damageable opponent) {
		//TODO: PART 3
		int effect = (int) (Math.random() * getAttackPower()) * -1;  
		opponent.incrementHealth(effect);
		return effect;
	}

	/**
	 * Does one of three things:
	 * 1. 20% chance that the special fighter does 0 damage and is disabled for 5 turns
	 * 2. 50% chance that the special fighter causes the opponent to damage itself for twice
	 *    of the opponents attack power (NOT his own attack power) 
	 * 3. 30% chance that the special fighter does 0 damage
	 * 
	 * @param opponent person that the fighter is trying to damage
	 * @return the amount of damage they do; this should always be negative or zero
	 */
	public int infiltrate(Damageable opponent) {		
		//TODO: PART 3
		int dice = (int) (Math.random() * 100);
		if (dice > 50) {
			int effect = opponent.getAttackPower()*2;
			opponent.incrementHealth(effect);
			return effect;
		}
		else if (dice <= 20) {
			disabledTurns = 5;
			return 0; 
		}
		else {
			return 0;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int incrementHealth(int upHp) {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return -1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaxHealth() {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return super.getMaxHealth();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHealth() {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return super.getHealth();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAttackPower() {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return super.getAttackPower();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAlive() {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return super.isAlive();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void skipTurn() {
		if(disabledTurns > 0) {
			disabledTurns--;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisabled() {
		return disabledTurns > 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStatus() {
		//TODO: PART 3 - uncomment when the rest of PART 3 is done
		if(isDisabled() && isAlive()) {
			return "disabled for " + this.disabledTurns + " more turns; " + super.getStatus();
		} else {
			return super.getStatus();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canTakeTurn() {
		//TODO: PART 3 - is this being done somewhere else? how can we borrow that functionality
		return super.canTakeTurn();
	}
}
