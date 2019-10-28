public enum AdventureRoom {

	/*
	 *     +-----------+-----------+-----------+
	 *     | START (0) | CHAIR (1) | GROWL (2) |
	 *     +-----------+-----------+-----------+
	 *     | BLACK (3) | CHILL (4) | TIGER (5) |
	 *     +-----------+-----------+-----------+
	 *     | YUMMY (6) | SMELL (7) | NOISE (8) |
	 *     +-----------+-----------+-----------+
	 */

	TODO;

//	START_ROOM("You are starving, and know food is in here somewhere.", false),
//	CHAIR_ROOM("You find a comfortable chair.", false),
//	GROWL_ROOM("You hear a faint growling noise.", false),
//	BLACK_ROOM("Oh no! You have fallen through a black hole!", true),
//	CHILL_ROOM("You feel a slight chill.", false),
//	TIGER_ROOM("Oh no! You have been eaten by a tiger.", true),
//	YUMMY_ROOM("Congratulations! You found the meal, and it looks delicious!", true),
//	SMELL_ROOM("You smell something pleasant.", false),
//	NOISE_ROOM("You hear a faint noise, almost like purring.", false);

	private AdventureRoom(/* TODO */) {
		// TODO
	}

	@Override
	public String toString() {
		return null; // TODO
	}

	public boolean done() {
		return false; // TODO
	}

	public boolean canMove(Direction direction) {
		boolean move = false;

		switch (direction) {
			case WEST:
				// TODO
				break;
			case EAST:
				// TODO
				break;
			case NORTH:
				// TODO
				break;
			case SOUTH:
				// TODO
				break;
			default:
				assert false;
		}

		return move;
	}

	public AdventureRoom moveRoom(Direction direction) {
		AdventureRoom room = this;

		if (this.canMove(direction)) {
			switch (direction) {
				case WEST:
					// TODO
					break;
				case EAST:
					// TODO
					break;
				case NORTH:
					// TODO
					break;
				case SOUTH:
					// TODO
					break;
				default:
					assert false;
			}
		}

		return room;
	}
}
