
public interface PokemonInterface {
	default Pokemon createPokemon(String name, int health, String type) {
		Pokemon current = new Pokemon();
		current.setName(name);
		current.setHealth(health);
		current.setType(type);
		return current;
	}
	default void attackPokemon(Pokemon pokemon) {
		int curHealth = pokemon.getHealth();
		curHealth -= 10;
		pokemon.setHealth(curHealth);
	}
	default String pokemonInfo(Pokemon pokemon) {
		String name = pokemon.getName();
		int health = pokemon.getHealth();
		String type = pokemon.getType();
		
		return (name+" has "+health+" and is "+type+" type");
	}
	
}
