package com.example.meowproj.Model;

public class ProfileRcv {
    int icProfileId, icRightId;
    String nameFolder;

    public ProfileRcv(int icProfileId, int icRightId, String nameFolder) {
        this.icProfileId = icProfileId;
        this.icRightId = icRightId;
        this.nameFolder = nameFolder;
    }

    public int getIcProfileId() {
        return icProfileId;
    }

    public void setIcProfileId(int icProfileId) {
        this.icProfileId = icProfileId;
    }

    public int getIcRightId() {
        return icRightId;
    }

    public void setIcRightId(int icRightId) {
        this.icRightId = icRightId;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }
}
