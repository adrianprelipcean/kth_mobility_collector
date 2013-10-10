package servlet.handling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.connection.ConnDB;
import database.objects.AnnotationsValues;
import database.objects.EmbeddedLocation;
import database.objects.LocationValues;

public class DBS {
	private Connection connect = null;

	public void getDBS(HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		boolean inserted = false;
		response.setContentType("application/json");
		String embeddedLocations = request.getParameter("embeddedLocations_")
				.trim();
		String simpleLocations = request.getParameter("simpleLocations_")
				.trim();
		String annotations = request.getParameter("annotations_").trim();

		PreparedStatement ps = null;
		DataOutputStream dos = new DataOutputStream(response.getOutputStream());
		ConnDB conndb = new ConnDB();
		Gson json = new Gson();

		EmbeddedLocation[] locations = json.fromJson(embeddedLocations,
				EmbeddedLocation[].class);

		if (locations != null)
			for (int i = 0; i < locations.length; i++) {

				String insertSQL = "insert into location_table(accuracy_ ,  altitude_ ,  bearing_ ,  lat_ ,  lon_ ,  time_ ,  speed_ ,  satellites_ ,  user_id ,  size ,  totalismoving ,  totalmax ,  totalmean ,  totalmin ,  totalnumberofpeaks ,  totalnumberofsteps ,  totalstddev ,  xismoving ,  xmaximum ,  xmean ,  xminimum ,  xnumberofpeaks ,  xstddev ,  yismoving ,  ymax ,  ymean ,  ymin ,  ynumberofpeaks ,  ystddev ,  zismoving ,  zmax ,  zmean ,  zmin ,  znumberofpeaks ,  zstddev ) "
						+ "values('"
						+ locations[i].getLocation().accuracy_
						+ "','"
						+ locations[i].getLocation().altitude_
						+ "','"
						+ locations[i].getLocation().bearing_
						+ "','"
						+ locations[i].getLocation().lat_
						+ "','"
						+ locations[i].getLocation().lon_
						+ "','"
						+ locations[i].getLocation().time_
						+ "','"
						+ locations[i].getLocation().speed_
						+ "','"
						+ locations[i].getLocation().satellites_
						+ "','"
						+ locations[i].getLocation().user_id
						+ "','"
						+ locations[i].getAcc().size
						+ "','"
						+ locations[i].getAcc().totalIsMoving
						+ "','"
						+ locations[i].getAcc().totalMax
						+ "','"
						+ locations[i].getAcc().totalMean
						+ "','"
						+ locations[i].getAcc().totalMin
						+ "','"
						+ locations[i].getAcc().totalNumberOfPeaks
						+ "','"
						+ locations[i].getAcc().totalNumberOfSteps
						+ "','"
						+ locations[i].getAcc().totalStdDev
						+ "','"
						+ locations[i].getAcc().xIsMoving
						+ "','"
						+ locations[i].getAcc().xMaximum
						+ "','"
						+ locations[i].getAcc().xMean
						+ "','"
						+ locations[i].getAcc().xMinimum
						+ "','"
						+ locations[i].getAcc().xNumberOfPeaks
						+ "','"
						+ locations[i].getAcc().xStdDev
						+ "','"
						+ locations[i].getAcc().yIsMoving
						+ "','"
						+ locations[i].getAcc().yMax
						+ "','"
						+ locations[i].getAcc().yMean
						+ "','"
						+ locations[i].getAcc().yMin
						+ "','"
						+ locations[i].getAcc().yNumberOfPeaks
						+ "','"
						+ locations[i].getAcc().yStdDev
						+ "','"
						+ locations[i].getAcc().zIsMoving
						+ "','"
						+ locations[i].getAcc().zMax
						+ "','"
						+ locations[i].getAcc().zMean
						+ "','"
						+ locations[i].getAcc().zMin
						+ "','"
						+ locations[i].getAcc().zNumberOfPeaks
						+ "','"
						+ locations[i].getAcc().zStdDev + "')";

				try {
					connect = conndb.getConn();
					ps = connect.prepareStatement(insertSQL);
					inserted = ps.executeUpdate() > 0;
					conndb.releaseConnection(connect);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		LocationValues[] locationVals = json.fromJson(simpleLocations,
				LocationValues[].class);

		if (locationVals != null)
			for (int i = 0; i < locationVals.length; i++) {
				String insertSQL2 = "insert into simple_location_table(accuracy_ ,  altitude_ ,  bearing_ ,  lat_ ,  lon_ ,  time_ ,  speed_ ,  satellites_ ,  user_id ) "
						+ "values('"
						+ locationVals[i].accuracy_
						+ "','"
						+ locationVals[i].altitude_
						+ "','"
						+ locationVals[i].bearing_
						+ "','"
						+ locationVals[i].lat_
						+ "','"
						+ locationVals[i].lon_
						+ "','"
						+ locationVals[i].time_
						+ "','"
						+ locationVals[i].speed_
						+ "','"
						+ locationVals[i].satellites_
						+ "','"
						+ locationVals[i].user_id + "')";
				try {
					connect = conndb.getConn();
					ps = connect.prepareStatement(insertSQL2);
					inserted = ps.executeUpdate() > 0;
					conndb.releaseConnection(connect);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		AnnotationsValues[] annotationObject = json.fromJson(annotations,
				AnnotationsValues[].class);

		if (annotationObject != null)
			for (int i = 0; i < annotationObject.length; i++) {
				String insertSQL = "insert into annotation_table( annotationvalues ,  userid ,  annotationstarttime ,  annotationstoptime ) "
						+ "values('"
						+ annotationObject[i].annotationValues
						+ "','"
						+ annotationObject[i].userid
						+ "','"
						+ annotationObject[i].annotationStartTime
						+ "','"
						+ annotationObject[i].annotationStopTime + "')";
				try {
					connect = conndb.getConn();
					ps = connect.prepareStatement(insertSQL);
					inserted = ps.executeUpdate() > 0;
					conndb.releaseConnection(connect);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		


		if (inserted)
			dos.writeUTF("OK");
		else
			dos.writeUTF("Failed to insert into the database");
	}
}
