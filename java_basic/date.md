# java8新日期类

==Java 8过后 提供了一个全新的API 来**替代**（`java.util.Date`和`java.util.Calendar`）==

该API包括了类：

## LocalDate

LocalDate用来获取一个日期（年月日？），并不能得到具体时间

```java
LocalDate date = LocalDate.now(); // get the current date 
//格式化
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
System.out.println(date.format(formatter));  // 18-06-2020
```



## LocalTime

LocalTime和LocalDate相反，只代表一个时间（时分秒？），无法获取日期

```java
LocalTime time = LocalTime.now(); // get the current time  
//格式化
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");  
System.out.println(time.format(formatter)); //18:00:58 
```



## LocalDateTime

LocalDateTime，也是Java中最常用的Date / Time类，代表前两个类的组合 - 即日期和时间（年月日时分秒？）的值

```java
LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time  
//格式化
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
System.out.println(dateTime.format(formatter)); // 18-06-2020 18:02:38 
```



## ZonedDateTime

ZonedDateTime是带时区的时间和日期



## DateTimeFormatter

格式化时间

```java
LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time  
//格式化
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
System.out.println(dateTime.format(formatter)); // 18-06-2020 18:02:38 
```



**关于日期类地练习：**

场景：获得两个时间，这两个时间之差为3天时间

```java
LocalDate now = LocalDate.now(); // 2021-07-04
LocalDate plus1 = now.plusDays(1); // 2021-07-05
LocalDate plus2 = now.plusDays(2); // 2021-07-06

LocalTime min = LocalTime.MIN; // 00:00
LocalTime max = LocalTime.MAX; // 23:59:59.999999999

// 组合时间
LocalDateTime start = LocalDateTime.of(now, min); // 2021-07-04 00:00
LocalDateTime end = LocalDateTime.of(plus2, max); // 2021-07-06 23:59:59.999999999

// 时间格式化(两者刚好相差3天时间)
String formatStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 2021-07-04 00:00:00
String endStart = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 2021-07-06 23:59:59
```



```java
/*
需求:计算你出生了多少天?

分析:
    活着的时间的毫秒值 = 现在的日期毫秒值 - 出生的日期毫秒值
    活着的时间的毫秒值转成天

实现步骤:
    1.创建当前时间的Date对象.
    2.定义一个出生日期的字符串"1999-09-09"
    3.出生日期的字符串转成Date对象
    4.活着的时间的毫秒值 = 现在的日期毫秒值 - 出生的日期毫秒值
    5.活着的时间的毫秒值转成天
 */
public class Demo04 {
    public static void main(String[] args) throws ParseException {
        // 1.创建当前时间的Date对象.
        Date now = new Date();
        // 2.定义一个出生日期的字符串"1999-09-09"
        String birthdayStr = "1996年04月23日";
        // 3.出生日期的字符串转成Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = sdf.parse(birthdayStr);
        // 4.活着的时间的毫秒值 = 现在的日期毫秒值 - 出生的日期毫秒值
        long liveTime = now.getTime() - date.getTime();

        // 5.活着的时间的毫秒值转成天
        long day = liveTime / 1000 / 60 / 60 / 24;
        System.out.println("活了 " + day + "天");
    }
}
```