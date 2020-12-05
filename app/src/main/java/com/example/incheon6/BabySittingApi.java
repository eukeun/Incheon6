package com.example.incheon6;

import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

public class BabySittingApi {
    public final static String URL = "https://openapi.gg.go.kr/ChildPlayFacility?";
    public final static String KEY = "accac320bac24f99ae1970142c825852";

    TextView status1 = null;

    public BabySittingApi() {
        try {
            apiParserSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MapPoint> apiParserSearch() throws Exception {


        java.net.URL url = new URL("https://openapi.gg.go.kr/ChildPlayFacility?KEY=accac320bac24f99ae1970142c825852&Type=xml&pIndex=1&pSize=1000");


        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        xpp.setInput(bis, "utf-8");

        String tag = null;
        int event_type = xpp.getEventType();

        ArrayList<MapPoint> mapPoint = new ArrayList<MapPoint>();

        String name = null, lon = null, lat = null;
        boolean bname = false, blon = false, blat = false;

        while (event_type != XmlPullParser.END_DOCUMENT) {
            switch (event_type) {
                case XmlPullParser.START_TAG:
                    tag = xpp.getName();
                    /*
                    if (tag.equals("dutyName")) {
                        bname = true;
                    }
                    if (tag.equals("wgs84Lat")) {
                        blat = true;
                    }
                    if (tag.equals("wgs84Lon")) {
                        blon = true;
                    }
                    break;
                    */
                    if (tag.equals("PLAY_FACLT_NM")) {
                        bname = true;
                    }
                    if (tag.equals("REFINE_WGS84_LAT")) {
                        blat = true;
                    }
                    if (tag.equals("REFINE_WGS84_LOGT")) {
                        blon = true;
                    }
                    break;

                case XmlPullParser.TEXT:
                    if (bname == true) {
                        name = xpp.getText();
                        bname = false;
                    } else if (blat == true) {
                        lat = xpp.getText();
                        blat = false;
                    } else if (blon == true) {
                        lon = xpp.getText();
                        blon = false;
                    }
                    break;
                case XmlPullParser.END_TAG:
                    tag = xpp.getName();
                    if (tag.equals("row")) {

                        MapPoint entity = new MapPoint();
                        entity.setName(name);
                        entity.setLat(Double.valueOf(lat));
                        entity.setLon(Double.valueOf(lon));

                        mapPoint.add(entity);
                        System.out.println(mapPoint.size());

                    }
                    break;
            }
            event_type = xpp.next();
        }
        System.out.println(mapPoint.size());


        return mapPoint;
    }


    public static void main(String[] args) {
        new BabySittingApi();
    }
}
