package by.krukouski.seaport.entity;

import java.util.List;

public class Seaport {

    private Integer portCapacity;
    private Integer countOfContainers;
    private List<Dock> docks;
    private String name;

    public Seaport(Integer portCapacity, String name) {
        this.portCapacity = portCapacity;
        this.name = name;
    }

    public Seaport() {
    }

    public Seaport(Integer portCapacity) {
        this.portCapacity = portCapacity;
    }

    public Integer getPortCapacity() {
        return portCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountOfContainers() {
        return countOfContainers;
    }

    public List<Dock> getDocks() {
        return docks;
    }

    public void setCountOfContainers(Integer countOfContainers) {
        this.countOfContainers = countOfContainers;
    }

    public void setPortCapacity(Integer portCapacity) {
        this.portCapacity = portCapacity;
    }

    public void setDocks(List<Dock> docks) {
        this.docks = docks;
    }

    public void addDock(Dock dock) {
        docks.add(dock);
    }

    public void addContainers(Integer countOfContainers) {
        this.countOfContainers += countOfContainers;
    }

    public void subtractContainers(Integer countOfContainers) {
        this.countOfContainers -= countOfContainers;
    }

}
