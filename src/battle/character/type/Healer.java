package battle.character.type;

import battle.character.Combatant;
import battle.character.Damageable;
import battle.character.Disableable;

public abstract class Healer implements Disableable, Combatant {
	//the strength of their magic capabilities
	private final int healingPower;
	
	//the number of turns that the special fighter will be disabled for
	private int disabledTurns;
	
	/**
	 * Creates a healer. Should NOT be disabled initially.
	 * 
	 * @param healingPower an amount corresponding to their magic capabilities
	 */
	public Healer(int healingPower) {
		//TODO: PART 2
		this.healingPower = healingPower;
		this.disabledTurns = 0;
	}
	
	/**
	 * Heals a teammate for anywhere between half of their healing power and all of their healing
	 * power (inclusive)
	 * 
	 * @param teammate person to heal
	 * @return how much health the person gained
	 */
	public int heal(Damageable teammate) {
		//TODO: PART 2
		int effect = (int) Math.random() * (healingPower/2) + (healingPower/2);
		teammate.incrementHealth(effect);
		return effect;
	}
	
	/**
	 * Heals a teammate to full health and disables the healer for 5 turns
	 * 
	 * @param teammate person to heal
	 * @return how much health the person gained
	 */
	public int sacrifice(Damageable teammate) {
		//TODO: PART 2
		int effect = teammate.getHealth();
		teammate.incrementHealth(teammate.getMaxHealth());
		disabledTurns = 5;
		return teammate.getMaxHealth() - effect;
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
		if(isDisabled()) {
			return "disabled for " + disabledTurns + " more turns";
		} else {
			return "available";
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canTakeTurn() {
		return !isDisabled();
	}
}
