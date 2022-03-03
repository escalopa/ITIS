package dao;

public class DriverViews {

    private Long driver_id;
    private String name;
    private String model;

    public DriverViews(Long driver_id, String name, String model) {
        this.driver_id = driver_id;
        this.name = name;
        this.model = model;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
