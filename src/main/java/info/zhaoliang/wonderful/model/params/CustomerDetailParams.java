package info.zhaoliang.wonderful.model.params;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * 客户资料参数.
 * 
 * @author zhaoliang
 **/
@Data
public class CustomerDetailParams {

    /**
     * 数据标识.
     */
    private Long id;

    /**
     * 流量标识.
     */
    @NotNull
    private Long customerId;

    /**
     * 渠道名称.
     */
    @NotBlank(message = "用户名不能为空")
    private String channelName;

    /**
     * 手机号码.
     */

    private String mobile;

    /**
     * 生日，格式为：1999-08-12.
     */
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "出生日期格式不正确")
    private String birthday;

    /**
     * 获取时间.
     */
    @Past
    private Date gatherTime;

    /**
     * 客户姓名.
     */
    private String name;

    /**
     * 客户昵称.
     */
    private String nick;

    /**
     * 性别：1、男|2、女|3、其他.
     */
    @Range(min = 1, max = 3, message = "性别：1、男|2、女|3、其他.")
    private Integer gender;

    /**
     * 年龄.
     */
    @Range(min = 0, max = 150, message = "年龄必须为0-150")
    private Integer age;

    /**
     * 邮箱.
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 最高学历标识. 1:本科以上;2本科;3:大专;4:专科;5:高中/中专;6:初中,7:其它
     */
    @Range(min = 0, max = 8, message = "1:本科以上;2本科;3:大专;4:专科;5:高中/中专;6:初中,7:其它")
    private Integer educationLevelValue;

}
