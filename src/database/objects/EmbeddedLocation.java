package database.objects;

public class EmbeddedLocation {
	LocationValues currentLocation;
	AccelerometerValues currentAcc;

	public EmbeddedLocation(LocationValues l, AccelerometerValues a) {
		this.currentLocation = l;
		this.currentAcc = a;
	}

	public LocationValues getLocation() {
		return currentLocation;
	}

	public AccelerometerValues getAcc() {
		return currentAcc;
	}

}
