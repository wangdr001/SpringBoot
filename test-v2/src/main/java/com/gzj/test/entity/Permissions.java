package com.gzj.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Data 整合包，只要加了 @Data 这个注解，等于同时加了以下注解
 * @Getter/@Setter
 * @ToString
 * @EqualsAndHashCode  自动生成 equals(Object other) 和 hashcode() 方法，包括所有非静态变量和非 transient 的变量
 * @RequiredArgsConstructor
 *
 * @Value 整合包，但是他会把所有的变量都设成 final 的，其他的就跟 @Data 一样，等于同时加了以下注解
 * @Getter (注意没有setter)
 * @ToString
 * @EqualsAndHashCode
 * @RequiredArgsConstructor
 *
 * @NoArgsConstructor 生成一个没有参数的构造器
 * @AllArgsConstructor 生成一个包含所有参数的构造器
 * @RequiredArgsConstructor  生成一个包含 “特定参数” 的构造器，特定参数指的是那些有加上 final 修饰词的变量们
 */

/**
 * 权限对应实体类
 */

@Data
@AllArgsConstructor
public class Permissions {
    private String id;
    private String permissionsName;
}
