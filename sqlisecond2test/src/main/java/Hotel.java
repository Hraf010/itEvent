public class Hotel {
    private int standardRooms;
    private int suites;
    private int apparts;
    private Event event;

    public Hotel(int standardRooms, int suites, int apparts) {
        this.standardRooms = standardRooms;
        this.suites = suites;
        this.apparts = apparts;
       // this.roomOrganizer = new RoomOrganizer(new Event(this),this);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String checkAvailibility() {
        return "Standard rooms: "+standardRooms+"|Suites: "+suites+"|Aparts: "+apparts;
    }

    public String getRoomFor(String name) {
        return this.event.getAttendeeByName(name).getRoomNumber();
    }

    public int getStandardRooms() {
        return standardRooms;
    }

    public void setStandardRooms(int standardRooms) {
        this.standardRooms = standardRooms;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getApparts() {
        return apparts;
    }

    public void setApparts(int apparts) {
        this.apparts = apparts;
    }
}
