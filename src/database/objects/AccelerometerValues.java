package database.objects;


public class AccelerometerValues {

	public float xMean, yMean, zMean, totalMean;
	public float xStdDev, yStdDev, zStdDev, totalStdDev;
	public float xMinimum, xMaximum, yMin, yMax, zMin, zMax, totalMin, totalMax;
	public int xNumberOfPeaks, yNumberOfPeaks, zNumberOfPeaks, totalNumberOfPeaks;
	public int totalNumberOfSteps;
	public boolean xIsMoving = false, yIsMoving = false, zIsMoving = false,
			totalIsMoving = false;
	public int size;

	public AccelerometerValues(float xMean, float yMean, float zMean,
			float totalMean, float xStdDev, float yStdDev, float zStdDev,
			float totalStdDev, float xMin, float xMax, float yMin, float yMax,
			float zMin, float zMax, float totalMin, float totalMax,
			int xNumberOfPeaks, int yNumberOfPeaks, int zNumberOfPeaks,
			int totalNumberOfPeaks, int totalNumberOfSteps, boolean xIsMoving,
			boolean yIsMoving, boolean zIsMoving, boolean totalIsMoving,
			int size) {
		super();
		this.xMean = xMean;
		this.yMean = yMean;
		this.zMean = zMean;
		this.totalMean = totalMean;
		this.xStdDev = xStdDev;
		this.yStdDev = yStdDev;
		this.zStdDev = zStdDev;
		this.totalStdDev = totalStdDev;
		this.xMinimum = xMin;
		this.xMaximum = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
		this.zMin = zMin;
		this.zMax = zMax;
		this.totalMin = totalMin;
		this.totalMax = totalMax;
		this.xNumberOfPeaks = xNumberOfPeaks;
		this.yNumberOfPeaks = yNumberOfPeaks;
		this.zNumberOfPeaks = zNumberOfPeaks;
		this.totalNumberOfPeaks = totalNumberOfPeaks;
		this.totalNumberOfSteps = totalNumberOfSteps;
		this.xIsMoving = xIsMoving;
		this.yIsMoving = yIsMoving;
		this.zIsMoving = zIsMoving;
		this.totalIsMoving = totalIsMoving;
		this.size = size;
	}
}
