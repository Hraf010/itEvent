import java.util.ArrayList;
import java.util.List;

public class RoomOrganizer {
    private Event event;
    private Hotel hotel;
    private int currentFreeStandardRoom = 1;
    private int currentFreeSuit= 101;
    private int currentFreeApart = 201;
    private List<Attendee> listOfDeepDiveOrConf;

    public RoomOrganizer(Event event,Hotel hotel) {
        this.event = event;
        this.hotel = hotel;
        this.listOfDeepDiveOrConf = new ArrayList<Attendee>();
    }


    public void getRoomForAttendees(String offer,String[] names) {
        if((offer.equals("TRINGA")||offer.equals("STAFF"))&&isStandardRoomsAvailable(names.length)){
            getStandardRoomForAttendes(names);
            return;
        }
        if((offer.equals("TRINGA")||offer.equals("STAFF"))&&!isStandardRoomsAvailable(names.length)){
            getAparsForAttendes(names);
            return;
        }
        if(offer.equals("DEEP DIVE")){
            for(String name : names){
                String sameRoom = getSameRoomforDeepDive();
                if(!sameRoom.equals("none")){
                    getAttendeebyName(name).setRoomNumber(sameRoom);
                }
                else {
                    getOneAppartOrStandarRoom(name);
                }
            }
        }
        if(offer.equals("CONF")){
            for(String name : names){
                String sameRoom = getSameRoomforConf();
                if(!getSameRoomforConf().equals("none")){
                    getAttendeebyName(name).setRoomNumber(sameRoom);
                }
                else {
                   getOneAppartOrStandarRoom(name);
                }
            }
        }

        if(offer.equals("SPEAKER"))
        {
            getSuitesForSpeakers(names);
            return;
        }


    }

    public void getOneAppartOrStandarRoom(String name){
        if (isStandardRoomsAvailable(1)){
            Attendee attendee = getAttendeebyName(name);
            attendee.setRoomNumber("Standard room N°"+currentFreeStandardRoom++);
            this.hotel.setStandardRooms(hotel.getStandardRooms()-1);
            this.listOfDeepDiveOrConf.add(attendee);
        }
        else {
            Attendee attendee = getAttendeebyName(name);
            attendee.setRoomNumber("Apart N°"+currentFreeApart++);
            this.hotel.setApparts(hotel.getApparts()-1);
            this.listOfDeepDiveOrConf.add(attendee);
        }
    }

    void getStandardRoomForAttendes(String[] names){
        for(String name : names){
            Attendee attendee = getAttendeebyName(name);
            attendee.setRoomNumber("Standard room N°"+currentFreeStandardRoom++);
            this.hotel.setStandardRooms(hotel.getStandardRooms()-1);
        }
    }
    void getAparsForAttendes(String[] names){
        for(String name : names){
            Attendee attendee = getAttendeebyName(name);
            attendee.setRoomNumber("Apart N°"+currentFreeApart++);
            this.hotel.setApparts(hotel.getApparts()-1);
        }
    }

    void getSuitesForSpeakers(String[] names){
        for(String name : names){
            Attendee attendee = getAttendeebyName(name);
            attendee.setRoomNumber("Suite N°"+currentFreeSuit++);
            this.hotel.setSuites(hotel.getSuites()-1);
        }
    }

    public boolean isStandardRoomsAvailable(int numberOfAttendees){
        return hotel.getStandardRooms()>= numberOfAttendees;
    }

    public Attendee getAttendeebyName(String name){
        return this.event.getAttendeeByName(name);
    }

    public String getSameRoomforConf(){
        for(Attendee attendee : listOfDeepDiveOrConf){
            if(attendee.getOffer().equals("DEEP DIVE")){
                String roomNumber = attendee.getRoomNumber();
                this.listOfDeepDiveOrConf.remove(attendee);
                return roomNumber;
            }
        }

        return "none";
    }

    public void deleteAnAttendee(int index){
        this.listOfDeepDiveOrConf.remove(index);
    }


    public String getSameRoomforDeepDive(){
        for(Attendee attendee : listOfDeepDiveOrConf){
            if(attendee.getOffer().equals("CONF")){
                String roomNumber = attendee.getRoomNumber();
                this.listOfDeepDiveOrConf.remove(attendee);
                return roomNumber;
            }
        }

        return "none";
    }


}
