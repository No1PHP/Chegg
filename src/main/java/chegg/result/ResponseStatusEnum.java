package chegg.result;

public enum ResponseStatusEnum {

  SUCCESS(200, true, "success"),
  FAILED(500, false, "failed");


  private Integer status;

  private Boolean success;

  private String message;

  ResponseStatusEnum(Integer status, Boolean success, String message) {
    this.status = status;
    this.success = success;
    this.message = message;
  }

  public Integer status() {
    return status;
  }
  public Boolean success() {
    return success;
  }
  public String message() {
    return message;
  }

}
