public class Attendee {
    private String name;
    private String offer;
    private String roomNumber;

    public Attendee() {
    }

    public Attendee(String name, String offer) {
        this.name = name;
        this.offer = offer; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
