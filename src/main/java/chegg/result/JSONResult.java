package chegg.result;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * Definition and Encapsulation of JSON form response.
 */
@Getter
@Setter
public class JSONResult {
  // response status
  private Integer status;

  private String message;

  private Boolean success;

  // response data, can be map, list etc.
  private Object data;

  /**
   * Instantiates a new Json result.
   *
   * @param data the data
   */
  public JSONResult(Object data) {
    this.status = ResponseStatusEnum.SUCCESS.status();
    this.message = ResponseStatusEnum.SUCCESS.message();
    this.success = ResponseStatusEnum.SUCCESS.success();
    this.data = data;
  }

  /**
   * Instantiates a new Json result.
   *
   * @param responseStatus the response status
   */
  public JSONResult(ResponseStatusEnum responseStatus) {
    this.status = responseStatus.status();
    this.message = responseStatus.message();
    this.success = responseStatus.success();
  }

  /**
   * Instantiates a new Json result.
   *
   * @param responseStatus the response status
   * @param data           the data
   */
  public JSONResult(ResponseStatusEnum responseStatus, Object data) {
    this.status = responseStatus.status();
    this.message = responseStatus.message();
    this.success = responseStatus.success();
    this.data = data;
  }

  /**
   * Instantiates a new Json result.
   *
   * @param responseStatus the response status
   * @param message        the message
   */
  public JSONResult(ResponseStatusEnum responseStatus, String message) {
    this.status = responseStatus.status();
    this.message = message;
    this.success = responseStatus.success();
  }

  /**
   * Instantiates a new Json result.
   */
  public JSONResult() {

  }

  /**
   * Ok http response.
   *
   * @return the json result
   */
  public static JSONResult ok() {
    return new JSONResult(ResponseStatusEnum.SUCCESS);
  }


  /**
   * Ok http response with customized data
   *
   * @param data the data
   * @return the json result
   */
  public static JSONResult ok(Object data) {
    return new JSONResult(ResponseStatusEnum.SUCCESS, data);
  }

  /**
   * Error json result.
   *
   * @return the json result
   */
  public static JSONResult error() {
    return new JSONResult(ResponseStatusEnum.FAILED);
  }

  /**
   * Error map json result with customized map form.
   *
   * @param map the map
   * @return the json result
   */
  public static JSONResult errorMap(Map map) {
    return new JSONResult(ResponseStatusEnum.FAILED, map);
  }

  public static JSONResult errorMsg(String message) {
    return new JSONResult(ResponseStatusEnum.FAILED, message);
  }


}
