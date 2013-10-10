package utils;

public class Variables {

	public static final String userName = "foo";
	public static final String password = "foo";
	public static final String databaseName = "mobilitycollector";
	public static final String connectionURL = "postgresql://"+"foo.com"+":"+"foo";

	public static final String sqlStatement1 = "CREATE TABLE user_table(  userid serial NOT NULL,  username character varying(20) NOT NULL,  password_i character varying(20) NOT NULL,  CONSTRAINT user_table_pkey PRIMARY KEY (userid))";
	public static final String sqlStatement2 = "CREATE TABLE simple_location_table	(	  id serial NOT NULL,	  upload boolean DEFAULT false,	  accuracy_ double precision,	  altitude_ double precision,	  bearing_ double precision,	  lat_ double precision,	  lon_ double precision,	  time_ bigint,	  speed_ double precision,	  satellites_ integer,	  user_id integer	)";
	public static final String sqlStatement3 = "CREATE TABLE location_table(  id serial NOT NULL,  upload boolean DEFAULT false,  accuracy_ double precision,  altitude_ double precision,  bearing_ double precision,  lat_ double precision,  lon_ double precision,  time_ bigint,  speed_ double precision,  satellites_ integer,  user_id integer,  size integer,  totalismoving boolean,  totalmax real,  totalmean real,  totalmin real,  totalnumberofpeaks integer,  totalnumberofsteps integer,  totalstddev real,  xismoving boolean,  xmaximum real,  xmean real,  xminimum real,  xnumberofpeaks integer,  xstddev real,  yismoving boolean,  ymax real,  ymean real,  ymin real,  ynumberofpeaks integer,  ystddev real,  zismoving boolean,  zmax real,  zmean real,  zmin real,  znumberofpeaks integer,  zstddev real)";
	public static final String sqlStatement4 = "CREATE TABLE annotation_table(  id serial NOT NULL,  upload boolean DEFAULT false,  annotationvalues character varying(30),  userid integer,  annotationstarttime bigint,  annotationstoptime bigint)";
}
