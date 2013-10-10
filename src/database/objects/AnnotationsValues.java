package database.objects;

public class AnnotationsValues {
	public int userid;
	public long annotationStartTime;
	public long annotationStopTime;
	public String annotationValues;

	public AnnotationsValues(int uid, long start, long stop, String val) {
		this.userid = uid;
		this.annotationStartTime = start;
		this.annotationStopTime = stop;
		this.annotationValues = val;
	}

}
