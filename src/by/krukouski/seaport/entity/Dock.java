package by.krukouski.seaport.entity;

public class Dock {

    private boolean isFree;
    private Seaport seaport;
    private Integer dockNumber;

    public Dock(boolean isFree, Integer dockNumber) {
        this.isFree = isFree;
        this.dockNumber = dockNumber;
    }

    public Dock() {

    }

    public Dock(boolean isFree) {
        this.isFree = isFree;
    }

    public Integer getDockNumber() {
        return dockNumber;
    }

    public void setDockNumber(Integer dockNumber) {
        this.dockNumber = dockNumber;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setSeaport(Seaport seaport) {
        this.seaport = seaport;
    }

    public Seaport getSeaport() {
        return seaport;
    }

    public void bookDock() {
        this.isFree = false;
    }

    public void unbookDock() {
        this.isFree = true;
    }
}
