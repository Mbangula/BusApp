package nbii.na.edu.busapp.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by namibia on 29/11/15.
 */
public class Frequency {
    private String id;
    private String origin;
    private String destination;
    private String time;

    public Frequency(String id, String origin, String destination, String time){
        this.id = id;
        this.origin=origin;
        this.destination=destination;
        this.time=time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Frequency(Map<String,Object> map){
        this((String)map.get("id"), (String)map.get("origin"),(String)map.get("destination"),(String)map.get("time"));
    }

    public Map<String, Object> toMap(){
        Map<String, Object> frequencyMap = new HashMap<String, Object>();
        frequencyMap.put("id", this.id);
        frequencyMap.put("origin", this.origin);
        frequencyMap.put("destination", this.destination);
        frequencyMap.put("time", this.time);
        return frequencyMap;
    }
}
