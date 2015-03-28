package castle;

import graph.Content;

/**
 * Created by user on 24.03.2015.
 */
class CastleContent extends Content {
    private int typeRoom;
    private int colorRoom;

    public CastleContent(int typeRoom, int colorRoom) {
        this.typeRoom = typeRoom;
        this.colorRoom = colorRoom;
    }

    public int getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(int typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getColorRoom() {
        return colorRoom;
    }

    public void setColorRoom(int colorRoom) {
        this.colorRoom = colorRoom;
    }
}
