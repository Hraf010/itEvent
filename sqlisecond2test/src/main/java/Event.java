import java.util.ArrayList;
import java.util.List;

public class Event {
    private Hotel hotel;
    private List<Attendee> attendees;
    private RoomOrganizer roomOrganizer;
    public Event(Hotel hotel) {
        this.hotel = hotel;
        this.attendees = new ArrayList<Attendee>();
        this.hotel.setEvent(this);
        this.roomOrganizer = new RoomOrganizer(this,hotel);
    }

    public boolean register(String offer, String... names) {
        for(String name : names){
            if(getAttendeeByName(name)==null){
                this.attendees.add(new Attendee(name,offer));
            }
            else {
                return false;
            }
        }
        roomOrganizer.getRoomForAttendees(offer,names);
        return true;
    }

    public Attendee getAttendeeByName(String name) {
        for(Attendee a : attendees){
            if(a.getName().equals(name))
                return a;
        }

        return null;
    }
}
