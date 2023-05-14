package com.tony.three;


import com.tony.custom.CannotBlank;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

@Component
public class User {

  @NotEmpty
  private String name;

  @Max(100)
  @Min(0)
  private int age;

  @NotBlank(message = "手機號碼不能為空")
  //正哲表達式
  @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手機格式錯誤")
  private String phone;


  //自訂的
  @CannotBlank(message = "內容含有空格")
  private String message;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}












