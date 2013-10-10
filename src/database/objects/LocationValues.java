package database.objects;


public class LocationValues {

	public long time_;
	public int user_id;
	public double lat_;
	public double lon_;
	public double speed_;
	public double altitude_;
	public double bearing_;
	public double accuracy_;
	public int satellites_;

	public LocationValues(int user_id, double lat_, double lon_, double speed_,
			double altitude_, double bearing_, double accuracy_,
			int satellites_, long time_) {
		super();
		this.user_id = user_id;
		this.lat_ = lat_;
		this.lon_ = lon_;
		this.speed_ = speed_;
		this.altitude_ = altitude_;
		this.bearing_ = bearing_;
		this.accuracy_ = accuracy_;
		this.satellites_ = satellites_;
		this.time_ = time_;
	}
}
