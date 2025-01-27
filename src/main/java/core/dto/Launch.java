package core.dto;

public class Launch {

  private String id;

  private String name;

  private String status;

  public Launch() {
  }

  public Launch(String name, String status) {
    this.name = name;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
